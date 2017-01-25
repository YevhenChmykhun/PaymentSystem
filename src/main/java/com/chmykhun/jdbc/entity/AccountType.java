package com.chmykhun.jdbc.entity;

import com.chmykhun.jdbc.dto.AccountTypeDto;

public class AccountType {

    public static final AccountType DEBIT;
    public static final AccountType CREDIT;

    static {
        DEBIT = new AccountType();
        DEBIT.setType("debit");
        CREDIT = new AccountType();
        CREDIT.setType("credit");
    }

    private Long id;
    private String type;

    public AccountType() {
    }

    public AccountType(AccountTypeDto typeDto) {
        this.id = typeDto.getId();
        this.type = typeDto.getType();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountType that = (AccountType) o;

        return type.equals(that.type);

    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountType{");
        sb.append("id=").append(id);
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
