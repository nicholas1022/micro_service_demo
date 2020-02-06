package com.spring.jpa.demo.findaccountsservice.entity;


import java.util.List;


public class Accounts {
	
	private boolean success;
	
	private List<Account> list;
	
	public Accounts() {
		
	}

	public Accounts(boolean success, List<Account> list) {
		this.success = success;
		this.list = list;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<Account> getList() {
		return list;
	}

	public void setList(List<Account> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Accounts [success=" + success + ", list=" + list + "]";
	}
	
	
	

}
