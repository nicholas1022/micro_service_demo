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
public class AccountBean {
	
	private boolean success;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private BigInteger Id;
	
	@Column(name="owner_name")
	private String ownerName;
	
	@Column(name="balance")
	private BigDecimal balance;
	
	public AccountBean() {
		
	}
	
	
	public AccountBean(Boolean success, BigInteger id, String ownerName, BigDecimal balance) {
		this.success = success;
		this.Id = id;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public AccountBean(Boolean success, Account account) {
		this.success = success;
		this.Id = account.getId();
		this.ownerName = account.getOwnerName();
		this.balance = account.getBalance();
	}
	
	

	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public BigInteger getId() {
		return Id;
	}

	public void setId(BigInteger id) {
		Id = id;
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
		return "Account [success=" + success + ", Id=" + Id + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}

}
