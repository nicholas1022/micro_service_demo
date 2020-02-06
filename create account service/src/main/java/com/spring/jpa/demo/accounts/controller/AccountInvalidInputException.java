package com.spring.jpa.demo.accounts.controller;

public class AccountInvalidInputException extends RuntimeException{

	public AccountInvalidInputException(String message, Throwable cause) {
		super(message, cause);

	}

	public AccountInvalidInputException(String message) {
		super(message);
	
	}

	public AccountInvalidInputException(Throwable cause) {
		super(cause);
		
	}
	
	

}
