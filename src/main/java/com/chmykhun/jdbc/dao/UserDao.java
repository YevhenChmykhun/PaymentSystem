package com.chmykhun.jdbc.dao;

import com.chmykhun.jdbc.dto.UserDto;
import com.chmykhun.jdbc.dto.UserTypeDto;

import java.util.List;

public interface UserDao extends AbstractDao<Long, UserDto> {

    UserDto findByPhoneNumber(String phoneNumber);

    List<UserDto> findAllUsersByUserType(UserTypeDto userType);

}
