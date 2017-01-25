package com.chmykhun.jdbc.dto;

import com.chmykhun.jdbc.annotation.Entity;
import com.chmykhun.jdbc.annotation.Id;
import com.chmykhun.jdbc.annotation.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "payment")
public class PaymentDto implements Serializable {

    @Id
    private Long id;
    private BigDecimal amount;
    private Date date;
    private Long senderId;
    private Long recipientId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

}
