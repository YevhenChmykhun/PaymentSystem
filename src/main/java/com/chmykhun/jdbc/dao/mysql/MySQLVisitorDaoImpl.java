package com.chmykhun.jdbc.dao.mysql;

import com.chmykhun.jdbc.connection.ConnectionWrapper;
import com.chmykhun.jdbc.dao.VisitorDao;
import com.chmykhun.jdbc.dto.VisitorDto;
import com.chmykhun.util.DateUtils;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class MySQLVisitorDaoImpl extends MySQLAbstractDao<Long, VisitorDto> implements VisitorDao {

    private static final String FIND_BY_DATE = "SELECT * FROM visitor WHERE date = ?;";

    public MySQLVisitorDaoImpl(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Long save(VisitorDto entity) {
        return genericSave(entity);
    }

    @Override
    public void update(VisitorDto entity) {
        genericUpdate(entity);
    }

    @Override
    public void delete(VisitorDto entity) {
        genericDelete(entity);
    }

    @Override
    public VisitorDto findById(Long id) {
        return genericFindById(id);
    }

    @Override
    public List<VisitorDto> findAll() {
        return genericFindAll();
    }

    @Override
    public VisitorDto findByDate(Date date) {
        List<VisitorDto> list = findByDynamicSelect(FIND_BY_DATE, new Serializable[]{DateUtils.dateToString(date, DateUtils.YYYY_MM_DD)});
        VisitorDto entity = null;
        if (list != null && list.size() != 0) {
            entity = list.get(0);
        }
        return entity;
    }

}
