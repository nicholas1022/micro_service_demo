package com.spring.jpa.demo.transferaccountservice;

public class BalanceLessThanAmountException extends RuntimeException{

	public BalanceLessThanAmountException(String message, Throwable cause) {
		super(message, cause);

	}

	public BalanceLessThanAmountException(String message) {
		super(message);
	
	}

	public BalanceLessThanAmountException(Throwable cause) {
		super(cause);
		
	}
	
	

}
