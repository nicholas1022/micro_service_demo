package com.spring.jpa.demo.transferaccountservice.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AccountBean {
	
	private BigInteger id;
	private BigInteger customerCode;
	private BigDecimal balance;
	
	public AccountBean() {
	}
	public AccountBean(BigInteger id, BigInteger customerCode, BigDecimal balance) {
		this.id = id;
		this.customerCode = customerCode;
		this.balance = balance;
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public BigInteger getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(BigInteger customerCode) {
		this.customerCode = customerCode;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AccountBean [id=" + id + ", ownerName=" + customerCode + ", balance=" + balance + "]";
	}
	
	
}
