package com.chmykhun.jdbc.dao.mysql;

import com.chmykhun.jdbc.connection.ConnectionWrapper;
import com.chmykhun.jdbc.util.MappingHelper;
import com.chmykhun.jdbc.util.ResultSetMapper;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MySQLAbstractDao<K extends Serializable, T> {
    private static Logger log = LogManager.getLogger(MySQLAbstractDao.class);

    private ConnectionWrapper connection;

    public MySQLAbstractDao(ConnectionWrapper connection) {
        this.connection = connection;
    }

    public K genericSave(T entity) {
        PreparedStatement preparedStatement = null;
        K id = null;
        try {
            Map<String, Serializable> tuple = entityToTuple(entity);

            // construct the SQL statement
            StringBuilder sqlNamesPart = new StringBuilder();
            sqlNamesPart.append("INSERT INTO ");
            sqlNamesPart.append(getTableName());
            sqlNamesPart.append(" (");
            StringBuilder sqlValuesPart = new StringBuilder();
            sqlValuesPart.append(") VALUES (");
            for (Map.Entry<String, Serializable> entry : tuple.entrySet()) {
                //skip id field
                if (entry.getKey().equals(MappingHelper.getFieldName(MappingHelper.getIdField(entity.getClass())))) {
                    continue;
                }
                sqlNamesPart.append(entry.getKey());
                sqlNamesPart.append(", ");
                sqlValuesPart.append("'");
                sqlValuesPart.append(entry.getValue());
                sqlValuesPart.append("', ");
            }
            sqlNamesPart.delete(sqlNamesPart.length() - 2, sqlNamesPart.length());
            sqlValuesPart.delete(sqlValuesPart.length() - 2, sqlValuesPart.length());
            sqlValuesPart.append(");");
            String sql = sqlNamesPart.append(sqlValuesPart).toString();

            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = (K) new Long(generatedKeys.getLong(1));
                } else {
                    throw new SQLException(
                            "Exception: Creating entity failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            log.log(Level.ERROR, e, e);
        } finally {
            connection.closePreparedStatement(preparedStatement);
        }

        return id;
    }

    public void genericUpdate(T entity) {
        PreparedStatement preparedStatement = null;
        try {
            Map<String, Serializable> tuple = entityToTuple(entity);

            // construct the SQL statement
            StringBuilder SQL = new StringBuilder();
            SQL.append("UPDATE ");
            SQL.append(getTableName());
            SQL.append(" SET ");
            for (Map.Entry<String, Serializable> entry : tuple.entrySet()) {
                SQL.append(entry.getKey());
                SQL.append(" = '");
                SQL.append(entry.getValue());
                SQL.append("', ");
            }
            SQL.delete(SQL.length() - 2, SQL.length());
            SQL.append(" WHERE ");
            SQL.append(MappingHelper.getFieldName(MappingHelper.getIdField(getEntityClass())));
            SQL.append(" = '");
            SQL.append(MappingHelper.getId(entity));
            SQL.append("';");

            preparedStatement = connection.prepareStatement(SQL.toString());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            log.log(Level.ERROR, e, e);
        } finally {
            connection.closePreparedStatement(preparedStatement);
        }

    }

    public void genericDelete(T entity) {
        PreparedStatement preparedStatement = null;
        try {
            Map<String, Serializable> tuple = entityToTuple(entity);

            // construct the SQL statement
            StringBuilder SQL = new StringBuilder();
            SQL.append("DELETE FROM ");
            SQL.append(getTableName());
            SQL.append(" WHERE ");
            SQL.append(MappingHelper.getFieldName(MappingHelper.getIdField(getEntityClass())));
            SQL.append(" = ");
            SQL.append(MappingHelper.getId(getEntityClass()));

            preparedStatement = connection.prepareStatement(SQL.toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.log(Level.ERROR, e, e);
        } finally {
            connection.closePreparedStatement(preparedStatement);
        }
    }

    public T genericFindById(K id) {
        List<T> list = findByDynamicSelect("SELECT * FROM " + getTableName() + " WHERE id = ?", new Serializable[]{id});
        T entity = null;
        if (list != null && list.size() != 0) {
            entity = list.get(0);
        }
        return entity;
    }

    public List<T> genericFindAll() {
        return findByDynamicSelect("SELECT * FROM " + getTableName() + " ;", null);
    }

    protected List<T> findByDynamicSelect(String sql, Serializable[] sqlParams) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> result = null;
        try {
            // prepare statement
            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setMaxRows(maxRows);

            // bind parameters
            for (int i = 0; sqlParams != null && i < sqlParams.length; i++) {
                preparedStatement.setObject(i + 1, sqlParams[i]);
            }

            resultSet = preparedStatement.executeQuery();
            result = new ResultSetMapper<T>(getEntityClass()).mapAll(resultSet);
        } catch (Exception e) {
            log.log(Level.ERROR, e, e);
        } finally {
            connection.closeResultSet(resultSet);
            connection.closePreparedStatement(preparedStatement);
        }
        return result;
    }

    protected Map<String, Serializable> entityToTuple(Object entity) {
        Map<String, Serializable> tuple = new HashMap<>();
        for (Field field : entity.getClass().getDeclaredFields()) {
            tuple.put(MappingHelper.getFieldName(field), MappingHelper.getFieldValue(field, entity));
        }
        return tuple;
    }

    protected String getTableName() {
        return MappingHelper.getTableName(getEntityClass());
    }

    protected Class<T> getEntityClass() {
        return ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    }

}
