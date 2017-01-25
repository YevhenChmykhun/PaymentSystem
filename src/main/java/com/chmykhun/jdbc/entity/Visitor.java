package com.chmykhun.jdbc.entity;

import com.chmykhun.jdbc.dto.VisitorDto;
import com.chmykhun.util.DateUtils;

import java.time.LocalDate;

public class Visitor {

    private Long id;
    private int count;
    private LocalDate date;

    public Visitor(VisitorDto visitorDto) {
        this.id = visitorDto.getId();
        this.count = visitorDto.getCount();
        this.date = DateUtils.dateToLocalDate(visitorDto.getDate());
    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Visitor{");
        sb.append("id=").append(id);
        sb.append(", count=").append(count);
        sb.append(", date=").append(date);
        sb.append('}');
        return sb.toString();
    }

}
