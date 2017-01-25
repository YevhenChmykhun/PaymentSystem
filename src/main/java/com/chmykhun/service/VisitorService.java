package com.chmykhun.service;

import com.chmykhun.jdbc.connection.ConnectionPool;
import com.chmykhun.jdbc.connection.ConnectionWrapper;
import com.chmykhun.jdbc.dao.VisitorDao;
import com.chmykhun.jdbc.dao.factory.DaoFactory;
import com.chmykhun.jdbc.dto.VisitorDto;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class VisitorService {

    public static void checkInVisitor() {
        VisitorDto visitor = null;
        Date date = Date.valueOf(LocalDate.now());
        Optional<ConnectionWrapper> optConnection = Optional.empty();
        try {
            optConnection = ConnectionPool.getInstance().takeConnection();
            ConnectionWrapper connection = optConnection.orElseThrow(SQLException::new);
            VisitorDao visitorDao = DaoFactory.getDaoFactory(connection).getVisitorDao();
            visitor = visitorDao.findByDate(date);
            if (visitor == null) {
                visitor = new VisitorDto();
                visitor.setCount(1);
                visitor.setDate(date);
                visitorDao.save(visitor);
            } else {
                visitor.setCount(visitor.getCount() + 1);
                visitorDao.update(visitor);
            }
        } catch (SQLException e) {
/*            throw new LogicException("DB connection error: ", e);*/
        } finally {
            optConnection.ifPresent(ConnectionPool.getInstance()::returnConnection);
        }
    }

}
