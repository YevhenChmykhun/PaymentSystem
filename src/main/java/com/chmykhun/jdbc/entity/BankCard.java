package com.chmykhun.jdbc.entity;

import com.chmykhun.jdbc.dto.BankCardDto;
import com.chmykhun.util.DateUtils;

import java.time.LocalDate;

public class BankCard {

    private Long id;
    private String number;
    private LocalDate validity;
    private String password;
    private String cvv;
    private Account account;

    public BankCard(BankCardDto cardDto) {
        this.id = cardDto.getId();
        this.number = cardDto.getNumber();
        this.validity = DateUtils.dateToLocalDate(cardDto.getValidity());
        this.password = cardDto.getPassword();
        this.cvv = cardDto.getCvv();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BankCard{");
        sb.append("id=").append(id);
        sb.append(", number='").append(number).append('\'');
        sb.append(", validity=").append(validity);
        sb.append(", password='").append(password).append('\'');
        sb.append(", cvv='").append(cvv).append('\'');
        sb.append(", account=").append(account);
        sb.append('}');
        return sb.toString();
    }

}
