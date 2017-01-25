package com.chmykhun.jdbc.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultSetMapper<T> {
    private static Logger log = LogManager.getLogger(ResultSetMapper.class);

    private Class<T> entityClass;

    public ResultSetMapper(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public List<T> mapAll(ResultSet resultSet) {
        if (!check(resultSet)) {
            return null;
        }

        List<T> result = new ArrayList<T>();
        try {
            while (resultSet.next()) {
                result.add(mapRow(resultSet));
            }
        } catch (SQLException e) {
            log.log(Level.ERROR, e, e);
        }
        return result;
    }

    /* before using this method one have to call resultSet.next() */
    public T mapRow(ResultSet resultSet) {
        if (!check(resultSet)) {
            return null;
        }

        T bean = null;
        try {
            bean = (T) entityClass.newInstance();
            for (int columnNumber = 0; columnNumber < resultSet.getMetaData().getColumnCount(); columnNumber++) {
                String columnName = resultSet.getMetaData().getColumnName(columnNumber + 1);
                Object columnValue = resultSet.getObject(columnNumber + 1);
                setValue(bean, columnName, columnValue);
            }
        } catch (IllegalAccessException | SQLException | InstantiationException | InvocationTargetException e) {
            log.log(Level.ERROR, e, e);
        }
        return bean;
    }

    private void setValue(T bean, String columnName, Object columnValue) throws IllegalAccessException, InvocationTargetException {
        for (Field field : bean.getClass().getDeclaredFields()) {
            String name = MappingHelper.getFieldName(field);
            if (name.equalsIgnoreCase(columnName) && columnValue != null) {
                BeanUtils.setProperty(bean, field.getName(), columnValue);
                break;
            }
        }
    }

    private boolean check(ResultSet resultSet) {
        boolean isOk = true;
        if (resultSet == null || !MappingHelper.isEntity(entityClass)) {
            isOk = false;
        }
        return isOk;
    }

}
