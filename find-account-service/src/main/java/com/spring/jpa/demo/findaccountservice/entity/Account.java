package com.spring.jpa.demo.findaccountservice.entity;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private BigInteger Id;
	
	@Column(name="customer_code")
	private BigInteger customerCode;
	
	@Column(name="balance")
	private BigDecimal balance;
	
	public Account() {
		
	}
	
	public Account(BigInteger customerCode, BigDecimal balance) {
		this.customerCode = customerCode;
		this.balance = balance;
	}

	public BigInteger getId() {
		return Id;
	}

	public void setId(BigInteger id) {
		Id = id;
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
		return "Account [Id=" + Id + ", ownerName=" + customerCode + ", balance=" + balance + "]";
	}

}
