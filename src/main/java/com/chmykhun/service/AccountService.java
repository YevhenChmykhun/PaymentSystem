package com.chmykhun.service;

import com.chmykhun.jdbc.connection.ConnectionPool;
import com.chmykhun.jdbc.connection.ConnectionWrapper;
import com.chmykhun.jdbc.dao.AccountDao;
import com.chmykhun.jdbc.dao.AccountStatusDao;
import com.chmykhun.jdbc.dao.AccountTypeDao;
import com.chmykhun.jdbc.dao.BankCardDao;
import com.chmykhun.jdbc.dao.factory.DaoFactory;
import com.chmykhun.jdbc.dto.AccountDto;
import com.chmykhun.jdbc.dto.AccountStatusDto;
import com.chmykhun.jdbc.dto.AccountTypeDto;
import com.chmykhun.jdbc.dto.BankCardDto;
import com.chmykhun.jdbc.entity.Account;
import com.chmykhun.jdbc.entity.AccountStatus;
import com.chmykhun.jdbc.entity.AccountType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountService {

    public static List<Account> getActiveAccounts() {
        List<Account> accounts = new ArrayList<>();
        Optional<ConnectionWrapper> optConnection = Optional.empty();
        try {
            optConnection = ConnectionPool.getInstance().takeConnection();
            ConnectionWrapper connection = optConnection.orElseThrow(SQLException::new);
            accounts = getByStatus(connection, AccountStatus.ACTIVE);
        } catch (SQLException e) {
/*            throw new LogicException("DB connection error: ", e);*/
        } finally {
            optConnection.ifPresent(ConnectionPool.getInstance()::returnConnection);
        }
        return accounts;
    }

    public static List<Account> getBlockedAccounts() {
        List<Account> accounts = new ArrayList<>();
        Optional<ConnectionWrapper> optConnection = Optional.empty();
        try {
            optConnection = ConnectionPool.getInstance().takeConnection();
            ConnectionWrapper connection = optConnection.orElseThrow(SQLException::new);
            accounts = getByStatus(connection, AccountStatus.BLOCKED);
        } catch (SQLException e) {
/*            throw new LogicException("DB connection error: ", e);*/
        } finally {
            optConnection.ifPresent(ConnectionPool.getInstance()::returnConnection);
        }
        return accounts;
    }

    public static Account getByCardId(Long cardId) {
        Account account = null;
        Optional<ConnectionWrapper> optConnection = Optional.empty();
        try {
            optConnection = ConnectionPool.getInstance().takeConnection();
            ConnectionWrapper connection = optConnection.orElseThrow(SQLException::new);
            BankCardDao cardDao = DaoFactory.getDaoFactory(connection).getBankCardDao();
            AccountDao accountDao = DaoFactory.getDaoFactory(connection).getAccountDao();
            AccountStatusDao accountStatusDao = DaoFactory.getDaoFactory(connection).getAccountStatusDao();
            AccountTypeDao accountTypeDao = DaoFactory.getDaoFactory(connection).getAccountTypeDao();

            BankCardDto cardDto = cardDao.findById(cardId);
            AccountDto accountDto = accountDao.findById(cardDto.getAccountId());
            account = getAccount(accountStatusDao, accountTypeDao, accountDto);
        } catch (SQLException e) {
/*            throw new LogicException("DB connection error: ", e);*/
        } finally {
            optConnection.ifPresent(ConnectionPool.getInstance()::returnConnection);
        }
        return account;
    }

    public static Account activateById(Long id) {
        Account account = null;
        Optional<ConnectionWrapper> optConnection = Optional.empty();
        try {
            optConnection = ConnectionPool.getInstance().takeConnection();
            ConnectionWrapper connection = optConnection.orElseThrow(SQLException::new);
            account = changeStatus(connection, AccountStatus.ACTIVE, id);
        } catch (SQLException e) {
/*            throw new LogicException("DB connection error: ", e);*/
        } finally {
            optConnection.ifPresent(ConnectionPool.getInstance()::returnConnection);
        }
        return account;
    }

    public static Account blockById(Long id) {
        Account account = null;
        Optional<ConnectionWrapper> optConnection = Optional.empty();
        try {
            optConnection = ConnectionPool.getInstance().takeConnection();
            ConnectionWrapper connection = optConnection.orElseThrow(SQLException::new);
            account = changeStatus(connection, AccountStatus.BLOCKED, id);
        } catch (SQLException e) {
/*            throw new LogicException("DB connection error: ", e);*/
        } finally {
            optConnection.ifPresent(ConnectionPool.getInstance()::returnConnection);
        }
        return account;
    }

    private static Account changeStatus(ConnectionWrapper connection, AccountStatus accountStatus, Long id) {
        AccountDao accountDao = DaoFactory.getDaoFactory(connection).getAccountDao();
        AccountStatusDao accountStatusDao = DaoFactory.getDaoFactory(connection).getAccountStatusDao();
        AccountTypeDao accountTypeDao = DaoFactory.getDaoFactory(connection).getAccountTypeDao();

        AccountStatusDto statusDto = accountStatusDao.findByStatus(accountStatus.getStatus());
        AccountDto accountDto = accountDao.findById(id);
        accountDto.setAccountStatusId(statusDto.getId());
        accountDao.update(accountDto);

        return getAccount(accountStatusDao, accountTypeDao, accountDto);
    }

    private static List<Account> getByStatus(ConnectionWrapper connection, AccountStatus accountStatus) {
        List<Account> result = new ArrayList<>();
        AccountDao accountDao = DaoFactory.getDaoFactory(connection).getAccountDao();
        AccountStatusDao accountStatusDao = DaoFactory.getDaoFactory(connection).getAccountStatusDao();
        AccountTypeDao accountTypeDao = DaoFactory.getDaoFactory(connection).getAccountTypeDao();

        List<AccountDto> accounts = accountDao.findAllByStatus(accountStatus.getStatus());
        for (AccountDto accountDto : accounts) {
            Account account = getAccount(accountStatusDao, accountTypeDao, accountDto);
            result.add(account);
        }
        return result;
    }

    private static Account getAccount(AccountStatusDao accountStatusDao, AccountTypeDao accountTypeDao, AccountDto dto) {
        Account account = new Account(dto);
        AccountStatusDto statusDto = accountStatusDao.findById(dto.getAccountStatusId());
        AccountTypeDto typeDto = accountTypeDao.findById(dto.getAccountTypeId());
        account.setAccountStatus(new AccountStatus(statusDto));
        account.setAccountType(new AccountType(typeDto));
        return account;
    }

}
