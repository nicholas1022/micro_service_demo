package com.spring.jpa.demo.transferaccountservice;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AccountBean {
	
	private BigInteger id;
	private String ownerName;
	private BigDecimal balance;
	
	public AccountBean() {
	}
	public AccountBean(BigInteger id, String ownerName, BigDecimal balance) {
		this.id = id;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AccountBean [id=" + id + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}
	
	
}
