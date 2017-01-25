package com.chmykhun.jdbc.dao.factory;

import com.chmykhun.jdbc.dao.*;

/**
 * Created by evgenii on 6/23/16.
 */
public interface AbstractDaoFactory {

    AbstractDao getDaoByEntityClass(Class entityClass);

    AccountDao getAccountDao();

    AccountStatusDao getAccountStatusDao();

    AccountTypeDao getAccountTypeDao();

    BankCardDao getBankCardDao();

    PaymentDao getPaymentDao();

    UserDao getUserDao();

    UserTypeDao getUserTypeDao();

    VisitorDao getVisitorDao();

}
