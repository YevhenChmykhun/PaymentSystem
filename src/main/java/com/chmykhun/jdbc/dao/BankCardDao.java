package com.chmykhun.jdbc.dao;

import com.chmykhun.jdbc.dto.BankCardDto;

import java.util.List;

public interface BankCardDao extends AbstractDao<Long, BankCardDto> {

    List<BankCardDto> findByUserId(Long userId);

}
