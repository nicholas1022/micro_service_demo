package com.spring.jpa.demo.transferaccountservice.exception;

public class AmountLessThanZeroException extends RuntimeException{

	public AmountLessThanZeroException(String message, Throwable cause) {
		super(message, cause);

	}

	public AmountLessThanZeroException(String message) {
		super(message);
	
	}

	public AmountLessThanZeroException(Throwable cause) {
		super(cause);
		
	}
	
	

}
