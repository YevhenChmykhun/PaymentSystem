package com.chmykhun.jdbc.entity;

import com.chmykhun.jdbc.dto.AccountDto;

import java.math.BigDecimal;

public class Account {

    private Long id;
    private BigDecimal balance;
    private AccountType accountType;
    private AccountStatus accountStatus;

    public Account(AccountDto accountDto) {
        this.id = accountDto.getId();
        this.balance = accountDto.getBalance();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public boolean isActive() {
        return accountStatus.equals(AccountStatus.ACTIVE);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("id=").append(id);
        sb.append(", balance=").append(balance);
        sb.append(", accountType=").append(accountType);
        sb.append(", accountStatus=").append(accountStatus);
        sb.append('}');
        return sb.toString();
    }

}
