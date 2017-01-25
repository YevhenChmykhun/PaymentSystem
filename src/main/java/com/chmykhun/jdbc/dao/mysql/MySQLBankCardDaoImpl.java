package com.chmykhun.jdbc.dao.mysql;

import com.chmykhun.jdbc.connection.ConnectionWrapper;
import com.chmykhun.jdbc.dao.BankCardDao;
import com.chmykhun.jdbc.dto.BankCardDto;

import java.io.Serializable;
import java.util.List;

public class MySQLBankCardDaoImpl extends MySQLAbstractDao<Long, BankCardDto> implements BankCardDao {

    private static final String FIND_BY_USER_ID = "SELECT * FROM bank_card WHERE user_id = ?;";

    public MySQLBankCardDaoImpl(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Long save(BankCardDto entity) {
        return genericSave(entity);
    }

    @Override
    public void update(BankCardDto entity) {
        genericUpdate(entity);
    }

    @Override
    public void delete(BankCardDto entity) {
        genericDelete(entity);
    }

    @Override
    public BankCardDto findById(Long id) {
        return genericFindById(id);
    }

    @Override
    public List<BankCardDto> findAll() {
        return genericFindAll();
    }

    @Override
    public List<BankCardDto> findByUserId(Long userId) {
        return findByDynamicSelect(FIND_BY_USER_ID, new Serializable[]{userId});
    }
}
