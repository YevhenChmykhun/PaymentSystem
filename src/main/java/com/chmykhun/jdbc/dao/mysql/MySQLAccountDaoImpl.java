package com.chmykhun.jdbc.dao.mysql;

import com.chmykhun.jdbc.connection.ConnectionWrapper;
import com.chmykhun.jdbc.dao.AccountDao;
import com.chmykhun.jdbc.dto.AccountDto;

import java.io.Serializable;
import java.util.List;

public class MySQLAccountDaoImpl extends MySQLAbstractDao<Long, AccountDto> implements AccountDao {

    private static final String FIND_ALL_BY_USER_ID = "SELECT * FROM account WHERE id IN (SELECT account_id FROM bank_card WHERE user_id = ?);";
    private static final String FIND_BY_STATUS = "SELECT * FROM account WHERE account_status_id IN (SELECT id FROM account_status WHERE status = ?);";

    public MySQLAccountDaoImpl(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Long save(AccountDto entity) {
        return genericSave(entity);
    }

    @Override
    public void update(AccountDto entity) {
        genericUpdate(entity);
    }

    @Override
    public void delete(AccountDto entity) {
        genericDelete(entity);
    }

    @Override
    public AccountDto findById(Long id) {
        return genericFindById(id);
    }

    @Override
    public List<AccountDto> findAll() {
        return genericFindAll();
    }

    @Override
    public List<AccountDto> findAllAccountsByUserId(Long id) {
        return findByDynamicSelect(FIND_ALL_BY_USER_ID, new Serializable[]{id});
    }

    @Override
    public List<AccountDto> findAllByStatus(String status) {
        return findByDynamicSelect(FIND_BY_STATUS, new Serializable[]{status});
    }


}
