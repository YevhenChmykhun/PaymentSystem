package com.chmykhun.jdbc.entity;

import com.chmykhun.jdbc.dto.UserDto;

import java.util.List;

public class User {

    private Long id;
    private String phoneNumber;
    private String password;
    private UserType userType;
    private List<BankCard> bankCards;

    public User(UserDto userDto) {
        this.id = userDto.getId();
        this.phoneNumber = userDto.getPhoneNumber();
        this.password = userDto.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<BankCard> getBankCards() {
        return bankCards;
    }

    public void setBankCards(List<BankCard> bankCards) {
        this.bankCards = bankCards;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", userType=").append(userType);
        sb.append(", bankCards=").append(bankCards);
        sb.append('}');
        return sb.toString();
    }

}
