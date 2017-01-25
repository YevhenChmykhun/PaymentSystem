package com.chmykhun.jdbc.entity;

import com.chmykhun.jdbc.dto.UserTypeDto;

public class UserType {

    public static final UserType USER;
    public static final UserType ADMIN;

    static {
        USER = new UserType();
        USER.setType("client");
        ADMIN = new UserType();
        ADMIN.setType("administrator");
    }

    private Long id;
    private String type;

    public UserType() {
    }

    public UserType(UserTypeDto userTypeDto) {
        this.id = userTypeDto.getId();
        this.type = userTypeDto.getType();
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

        UserType userType = (UserType) o;

        return type.equals(userType.type);
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserType{");
        sb.append("id=").append(id);
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
