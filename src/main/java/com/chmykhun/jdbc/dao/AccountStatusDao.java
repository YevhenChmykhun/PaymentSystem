package com.chmykhun.jdbc.dao;

import com.chmykhun.jdbc.dto.AccountStatusDto;

public interface AccountStatusDao extends AbstractDao<Long, AccountStatusDto> {

    AccountStatusDto findByStatus(String status);

}
