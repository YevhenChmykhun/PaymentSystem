package com.chmykhun.jdbc.dao.mysql;

import com.chmykhun.jdbc.connection.ConnectionWrapper;
import com.chmykhun.jdbc.dao.PaymentDao;
import com.chmykhun.jdbc.dto.PaymentDto;

import java.util.List;

public class MySQLPaymentDaoImpl extends MySQLAbstractDao<Long, PaymentDto> implements PaymentDao {

    public MySQLPaymentDaoImpl(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Long save(PaymentDto entity) {
        return genericSave(entity);
    }

    @Override
    public void update(PaymentDto entity) {
        genericUpdate(entity);
    }

    @Override
    public void delete(PaymentDto entity) {
        genericDelete(entity);
    }

    @Override
    public PaymentDto findById(Long id) {
        return genericFindById(id);
    }

    @Override
    public List<PaymentDto> findAll() {
        return genericFindAll();
    }

}
