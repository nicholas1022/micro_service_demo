package com.spring.jpa.demo.deleteaccountservice.entity;

public class ResponseStatus {
	
	private boolean success;

	public ResponseStatus() {
	}

	public ResponseStatus(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "ResponseStatus [success=" + success + "]";
	}
	
	

}
