package com.chmykhun.jdbc.dao.mysql;

import com.chmykhun.jdbc.connection.ConnectionWrapper;
import com.chmykhun.jdbc.dao.AccountStatusDao;
import com.chmykhun.jdbc.dto.AccountStatusDto;

import java.io.Serializable;
import java.util.List;

public class MySQLAccountStatusDaoImpl extends MySQLAbstractDao<Long, AccountStatusDto> implements AccountStatusDao {

    private static final String FIND_BY_STATUS = "SELECT * FROM account_status WHERE status = ?;";

    public MySQLAccountStatusDaoImpl(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Long save(AccountStatusDto entity) {
        return genericSave(entity);
    }

    @Override
    public void update(AccountStatusDto entity) {
        genericUpdate(entity);
    }

    @Override
    public void delete(AccountStatusDto entity) {
        genericDelete(entity);
    }

    @Override
    public AccountStatusDto findById(Long id) {
        return genericFindById(id);
    }

    @Override
    public List<AccountStatusDto> findAll() {
        return genericFindAll();
    }

    @Override
    public AccountStatusDto findByStatus(String status) {
        List<AccountStatusDto> list = findByDynamicSelect(FIND_BY_STATUS, new Serializable[]{status});
        AccountStatusDto entity = null;
        if (list != null && list.size() != 0) {
            entity = list.get(0);
        }
        return entity;
    }

}
