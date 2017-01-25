package com.chmykhun.parsing;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Currency {

	private String currencyCode;
	private BigDecimal rate;
	private LocalDate exchangeDate;
	
	public Currency() {	
	}

	public Currency(String currencyCode, BigDecimal rate, LocalDate exchangeDate) {
		this.currencyCode = currencyCode;
		this.rate = rate;
		this.exchangeDate = exchangeDate;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public LocalDate getExchangeDate() {
		return exchangeDate;
	}

	public void setExchangeDate(LocalDate exchangedate) {
		this.exchangeDate = exchangedate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Currency [code=");
		builder.append(currencyCode);
		builder.append(", rate=");
		builder.append(rate);
		builder.append(", date=");
		builder.append(exchangeDate);
		builder.append("]");
		return builder.toString();
	}

}
