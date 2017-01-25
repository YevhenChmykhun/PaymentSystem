package com.chmykhun.jdbc.dto;

import com.chmykhun.jdbc.annotation.Entity;
import com.chmykhun.jdbc.annotation.Id;
import com.chmykhun.jdbc.annotation.Table;

import java.io.Serializable;

@Entity
@Table(name = "user_type")
public class UserTypeDto implements Serializable {

    @Id
    private Long id;
    private String type;

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

}
