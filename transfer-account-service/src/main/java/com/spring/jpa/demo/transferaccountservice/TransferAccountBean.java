package com.spring.jpa.demo.transferaccountservice;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TransferAccountBean {
	
	private BigInteger fromId;
	private BigInteger toId;
	private BigDecimal amount;
	private BigDecimal fromBalance;
	private BigDecimal toBalance;
	
	
	public TransferAccountBean() {
	}


	public TransferAccountBean(BigInteger fromId, BigInteger toId, BigDecimal amount, BigDecimal fromBalance,
			BigDecimal toBalance) {
		this.fromId = fromId;
		this.toId = toId;
		this.amount = amount;
		this.fromBalance = fromBalance;
		this.toBalance = toBalance;
	}


	public BigInteger getFromId() {
		return fromId;
	}


	public void setFromId(BigInteger fromId) {
		this.fromId = fromId;
	}


	public BigInteger getToId() {
		return toId;
	}


	public void setToId(BigInteger toId) {
		this.toId = toId;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public BigDecimal getFromBalance() {
		return fromBalance;
	}


	public void setFromBalance(BigDecimal fromBalance) {
		this.fromBalance = fromBalance;
	}


	public BigDecimal getToBalance() {
		return toBalance;
	}


	public void setToBalance(BigDecimal toBalance) {
		this.toBalance = toBalance;
	}


	@Override
	public String toString() {
		return "TransferAccountBean [fromId=" + fromId + ", toId=" + toId + ", amount=" + amount + ", fromBalance="
				+ fromBalance + ", toBalance=" + toBalance + "]";
	}

	
	
	

}
