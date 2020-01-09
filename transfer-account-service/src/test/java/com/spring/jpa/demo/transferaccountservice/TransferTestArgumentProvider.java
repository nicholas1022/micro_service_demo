package com.spring.jpa.demo.transferaccountservice;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TransferTestArgumentProvider {
	
	private BigInteger fromId;
	private BigInteger toId;
	private BigDecimal amount;
	private BigDecimal result;
	
	
	public TransferTestArgumentProvider() {
	}
	public TransferTestArgumentProvider(BigInteger fromId, BigInteger toId, BigDecimal amount, BigDecimal result) {
		this.fromId = fromId;
		this.toId = toId;
		this.amount = amount;
		this.result = result;
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
	public BigDecimal getResult() {
		return result;
	}
	public void setResult(BigDecimal result) {
		this.result = result;
	}

}
