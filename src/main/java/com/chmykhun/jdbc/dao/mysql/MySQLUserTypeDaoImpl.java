package com.chmykhun.jdbc.dao.mysql;

import com.chmykhun.jdbc.connection.ConnectionWrapper;
import com.chmykhun.jdbc.dao.UserTypeDao;
import com.chmykhun.jdbc.dto.UserTypeDto;

import java.util.List;

public class MySQLUserTypeDaoImpl extends MySQLAbstractDao<Long, UserTypeDto> implements UserTypeDao {

    public MySQLUserTypeDaoImpl(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Long save(UserTypeDto entity) {
        return genericSave(entity);
    }

    @Override
    public void update(UserTypeDto entity) {
        genericUpdate(entity);
    }

    @Override
    public void delete(UserTypeDto entity) {
        genericDelete(entity);
    }

    @Override
    public UserTypeDto findById(Long id) {
        return genericFindById(id);
    }

    @Override
    public List<UserTypeDto> findAll() {
        return genericFindAll();
    }

}
