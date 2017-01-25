package com.chmykhun.jdbc.dao.factory;

import com.chmykhun.jdbc.connection.ConnectionWrapper;
import com.chmykhun.jdbc.dao.*;
import com.chmykhun.jdbc.dao.mysql.*;
import com.chmykhun.jdbc.entity.*;

/**
 * Created by evgenii on 6/23/16.
 */
public class MySQLDaoFactory implements AbstractDaoFactory {

    private ConnectionWrapper connection;

    public MySQLDaoFactory(ConnectionWrapper connection) {
        this.connection = connection;
    }

    @Override
    public AbstractDao getDaoByEntityClass(Class entityClass) {
        AbstractDao dao = null;
        if (Account.class.isAssignableFrom(entityClass)) {
            dao = new MySQLAccountDaoImpl(connection);
        } else if (AccountStatus.class.isAssignableFrom(entityClass)) {
            dao = new MySQLAccountStatusDaoImpl(connection);
        } else if (AccountType.class.isAssignableFrom(entityClass)) {
            dao = new MySQLAccountTypeDaoImpl(connection);
        } else if (BankCard.class.isAssignableFrom(entityClass)) {
            dao = new MySQLBankCardDaoImpl(connection);
        } else if (Payment.class.isAssignableFrom(entityClass)) {
            dao = new MySQLAccountDaoImpl(connection);
        } else if (User.class.isAssignableFrom(entityClass)) {
            dao = new MySQLUserDaoImpl(connection);
        } else if (UserType.class.isAssignableFrom(entityClass)) {
            dao = new MySQLUserTypeDaoImpl(connection);
        } else if (Visitor.class.isAssignableFrom(entityClass)) {
            dao = new MySQLAccountDaoImpl(connection);
        }
        return dao;
    }

    public AccountDao getAccountDao() {
        return new MySQLAccountDaoImpl(connection);
    }

    public AccountStatusDao getAccountStatusDao() {
        return new MySQLAccountStatusDaoImpl(connection);
    }

    public AccountTypeDao getAccountTypeDao() {
        return new MySQLAccountTypeDaoImpl(connection);
    }

    public BankCardDao getBankCardDao() {
        return new MySQLBankCardDaoImpl(connection);
    }

    public PaymentDao getPaymentDao() {
        return new MySQLPaymentDaoImpl(connection);
    }

    public UserDao getUserDao() {
        return new MySQLUserDaoImpl(connection);
    }

    public UserTypeDao getUserTypeDao() {
        return new MySQLUserTypeDaoImpl(connection);
    }

    public VisitorDao getVisitorDao() {
        return new MySQLVisitorDaoImpl(connection);
    }
}
