package com.chmykhun.jdbc.entity;

import com.chmykhun.jdbc.dto.PaymentDto;
import com.chmykhun.util.DateUtils;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Payment {

    private Long id;
    private BigDecimal amount;
    private LocalDate date;
    private User sender;
    private User recipient;

    public Payment(PaymentDto paymentDto) {
        this.id = paymentDto.getId();
        this.amount = paymentDto.getAmount();
        this.date = DateUtils.dateToLocalDate(paymentDto.getDate());
    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Payment{");
        sb.append("id=").append(id);
        sb.append(", amount=").append(amount);
        sb.append(", date=").append(date);
        sb.append(", sender=").append(sender);
        sb.append(", recipient=").append(recipient);
        sb.append('}');
        return sb.toString();
    }

}
