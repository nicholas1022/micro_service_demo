package com.spring.jpa.demo.transferaccountservice;

public class TransferToIdenticalAccountException extends RuntimeException{

	public TransferToIdenticalAccountException(String message, Throwable cause) {
		super(message, cause);

	}

	public TransferToIdenticalAccountException(String message) {
		super(message);
	
	}

	public TransferToIdenticalAccountException(Throwable cause) {
		super(cause);
		
	}
	
	

}
