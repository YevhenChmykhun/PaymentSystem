package com.chmykhun.service;

import com.chmykhun.jdbc.connection.ConnectionPool;
import com.chmykhun.jdbc.connection.ConnectionWrapper;
import com.chmykhun.jdbc.dao.UserDao;
import com.chmykhun.jdbc.dao.UserTypeDao;
import com.chmykhun.jdbc.dao.factory.DaoFactory;
import com.chmykhun.jdbc.dto.UserDto;
import com.chmykhun.jdbc.dto.UserTypeDto;
import com.chmykhun.jdbc.entity.User;
import com.chmykhun.jdbc.entity.UserType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Evgenii on 1/17/2017.
 */
public class UserService {

    public static User sighIn(String phoneNumber, String password) {
        User user = null;
        Optional<ConnectionWrapper> optConnection = Optional.empty();
        try {
            optConnection = ConnectionPool.getInstance().takeConnection();
            ConnectionWrapper connection = optConnection.orElseThrow(SQLException::new);

            UserDao userDao = DaoFactory.getDaoFactory(connection).getUserDao();
            UserTypeDao userTypeDao = DaoFactory.getDaoFactory(connection).getUserTypeDao();
            UserDto userDto = userDao.findByPhoneNumber(phoneNumber);
            UserTypeDto userTypeDto = userTypeDao.findById(userDto.getId());

            user = new User(userDto);
            user.setUserType(new UserType(userTypeDto));
            if (!(user != null && user.getPassword().equals(/*Encryptor.encrypt(password)*/ password))) {
                user = null;
            }
        } catch (SQLException e) {
/*            throw new LogicException("DB connection error: ", e);*/
        } finally {
            optConnection.ifPresent(ConnectionPool.getInstance()::returnConnection);
        }
        return user;
    }

    public static List<User> getAll() {
        List<User> users = new ArrayList<>();
        Optional<ConnectionWrapper> optConnection = Optional.empty();
        try {
            optConnection = ConnectionPool.getInstance().takeConnection();
            ConnectionWrapper connection = optConnection.orElseThrow(SQLException::new);

            UserDao userDao = DaoFactory.getDaoFactory(connection).getUserDao();
            List<UserDto> list = userDao.findAll();
            users.addAll(list.stream().map(User::new).collect(Collectors.toList()));
        } catch (SQLException e) {
/*            throw new LogicException("DB connection error: ", e);*/
        } finally {
            optConnection.ifPresent(ConnectionPool.getInstance()::returnConnection);
        }
        return users;
    }

}
