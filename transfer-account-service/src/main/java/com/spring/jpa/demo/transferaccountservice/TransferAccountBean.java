package com.spring.jpa.demo.transferaccountservice;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TransferAccountBean {
	
	private BigInteger fromId;
	private BigInteger toId;
	private BigDecimal amount;
	
	
	public TransferAccountBean() {
	}
	
	public TransferAccountBean(BigInteger fromId, BigInteger toId, BigDecimal amount) {

		this.fromId = fromId;
		this.toId = toId;
		this.amount = amount;

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


	@Override
	public String toString() {
		return "TransferAccountBean [fromId=" + fromId + ", toId=" + toId + ", amount=" + amount + "]";
	}
	

}
