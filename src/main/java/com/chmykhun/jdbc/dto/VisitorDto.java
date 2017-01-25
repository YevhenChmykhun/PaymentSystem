package com.chmykhun.jdbc.dto;

import com.chmykhun.jdbc.annotation.Entity;
import com.chmykhun.jdbc.annotation.Id;
import com.chmykhun.jdbc.annotation.Table;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "visitor")
public class VisitorDto implements Serializable {

    @Id
    private Long id;
    private int count;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

