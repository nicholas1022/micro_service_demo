package com.spring.jpa.demo.deleteaccountservice.controller;

public class AccountNotFoundException extends RuntimeException{

	public AccountNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public AccountNotFoundException(String message) {
		super(message);
	
	}

	public AccountNotFoundException(Throwable cause) {
		super(cause);
		
	}
	
	

}
