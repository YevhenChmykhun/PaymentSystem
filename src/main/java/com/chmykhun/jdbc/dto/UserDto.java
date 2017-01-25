package com.chmykhun.jdbc.dto;

import com.chmykhun.jdbc.annotation.Entity;
import com.chmykhun.jdbc.annotation.Id;
import com.chmykhun.jdbc.annotation.Table;

import java.io.Serializable;

@Entity
@Table(name = "user")
public class UserDto implements Serializable {

    @Id
    private Long id;
    private String phoneNumber;
    private String password;
    private Long userTypeId;

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

    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

}
