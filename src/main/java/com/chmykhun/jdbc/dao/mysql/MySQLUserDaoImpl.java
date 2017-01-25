package com.chmykhun.jdbc.dao.mysql;

import com.chmykhun.jdbc.connection.ConnectionWrapper;
import com.chmykhun.jdbc.dao.UserDao;
import com.chmykhun.jdbc.dto.UserDto;
import com.chmykhun.jdbc.dto.UserTypeDto;

import java.io.Serializable;
import java.util.List;

public class MySQLUserDaoImpl extends MySQLAbstractDao<Long, UserDto> implements UserDao {

    private static final String FIND_BY_PHONE_NUMBER = "SELECT * FROM user WHERE phone_number = ?;";
    private static final String FIND_ALL_BY_USER_TYPE = "SELECT * FROM user WHERE user_type_id IN (SELECT id FROM user_type WHERE type = ?);";

    public MySQLUserDaoImpl(ConnectionWrapper connection) {
        super(connection);
    }

    @Override
    public Long save(UserDto entity) {
        return genericSave(entity);
    }

    @Override
    public void update(UserDto entity) {
        genericUpdate(entity);
    }

    @Override
    public void delete(UserDto entity) {
        genericDelete(entity);
    }

    @Override
    public UserDto findById(Long id) {
        return genericFindById(id);
    }

    @Override
    public List<UserDto> findAll() {
        return genericFindAll();
    }

    @Override
    public UserDto findByPhoneNumber(String phoneNumber) {
        List<UserDto> list = findByDynamicSelect(FIND_BY_PHONE_NUMBER, new Serializable[]{phoneNumber});
        UserDto entity = null;
        if (list != null && list.size() != 0) {
            entity = list.get(0);
        }
        return entity;
    }

    @Override
    public List<UserDto> findAllUsersByUserType(UserTypeDto userType) {
        return findByDynamicSelect(FIND_ALL_BY_USER_TYPE, new Serializable[]{userType.getType()});
    }

}
