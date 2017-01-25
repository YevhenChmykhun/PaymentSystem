package com.chmykhun.service;


import com.chmykhun.jdbc.connection.ConnectionPool;
import com.chmykhun.jdbc.connection.ConnectionWrapper;
import com.chmykhun.jdbc.dao.BankCardDao;
import com.chmykhun.jdbc.dao.UserDao;
import com.chmykhun.jdbc.dao.factory.DaoFactory;
import com.chmykhun.jdbc.dto.BankCardDto;
import com.chmykhun.jdbc.dto.UserDto;
import com.chmykhun.jdbc.entity.BankCard;
import com.chmykhun.jdbc.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CardService {

    public static List<BankCard> getAllByUserId(Long userId) {
        List<BankCard> result = new ArrayList<>();
        Optional<ConnectionWrapper> optConnection = Optional.empty();
        try {
            optConnection = ConnectionPool.getInstance().takeConnection();
            ConnectionWrapper connection = optConnection.orElseThrow(SQLException::new);

            BankCardDao bankCardDao = DaoFactory.getDaoFactory(connection).getBankCardDao();
            List<BankCardDto> list = bankCardDao.findByUserId(userId);
            result.addAll(list.stream().map(BankCard::new).collect(Collectors.toList()));
        } catch (SQLException e) {
/*            throw new LogicException("DB connection error: ", e);*/
        } finally {
            optConnection.ifPresent(ConnectionPool.getInstance()::returnConnection);
        }
        return result;
    }

}
