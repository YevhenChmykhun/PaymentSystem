package com.chmykhun.jdbc.entity;

import com.chmykhun.jdbc.dto.AccountStatusDto;

public class AccountStatus {

    public static final AccountStatus ACTIVE;
    public static final AccountStatus BLOCKED;

    static {
        ACTIVE = new AccountStatus();
        ACTIVE.setStatus("active");
        BLOCKED = new AccountStatus();
        BLOCKED.setStatus("blocked");
    }

    private Long id;
    private String status;

    public AccountStatus() {
    }

    public AccountStatus(AccountStatusDto statusDto) {
        this.id = statusDto.getId();
        this.status = statusDto.getStatus();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountStatus that = (AccountStatus) o;

        return status.equals(that.status);

    }

    @Override
    public int hashCode() {
        return status.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountStatus{");
        sb.append("id=").append(id);
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
