package com.chmykhun.jdbc.dao;

import com.chmykhun.jdbc.dto.AccountDto;

import java.util.List;

public interface AccountDao extends AbstractDao<Long, AccountDto> {

    List<AccountDto> findAllAccountsByUserId(Long id);

    List<AccountDto> findAllByStatus(String status);

}
