package com.chmykhun.jdbc.dao;

import com.chmykhun.jdbc.dto.VisitorDto;

import java.sql.Date;

public interface VisitorDao extends AbstractDao<Long, VisitorDto> {

    VisitorDto findByDate(Date date);

}
