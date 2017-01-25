package com.chmykhun.jdbc.dao.mysql;

import com.chmykhun.jdbc.connection.ConnectionWrapper;
import com.chmykhun.jdbc.dao.AccountTypeDao;
import com.chmykhun.jdbc.dto.AccountTypeDto;

import java.util.List;

public class MySQLAccountTypeDaoImpl extends MySQLAbstractDao<Long, AccountTypeDto> implements AccountTypeDao {

    public MySQLAccountTypeDaoImpl(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Long save(AccountTypeDto entity) {
        return genericSave(entity);
    }

    @Override
    public void update(AccountTypeDto entity) {
        genericUpdate(entity);
    }

    @Override
    public void delete(AccountTypeDto entity) {
        genericDelete(entity);
    }

    @Override
    public AccountTypeDto findById(Long id) {
        return genericFindById(id);
    }

    @Override
    public List<AccountTypeDto> findAll() {
        return genericFindAll();
    }

}
