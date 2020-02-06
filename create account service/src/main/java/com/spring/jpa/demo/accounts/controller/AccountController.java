package com.spring.jpa.demo.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.demo.accounts.entity.Account;
import com.spring.jpa.demo.accounts.entity.AccountBean;
import com.spring.jpa.demo.accounts.repository.AccountRepository;
import com.spring.jpa.demo.accounts.controller.AccountErrorResponse;

@RestController
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@PostMapping("/createAccount")
	public AccountBean createAccount(@RequestBody Account theAccount) {
		
		Account account = accountRepository.save(theAccount);
		
	    return new AccountBean(true, account.getId(), account.getOwnerName(), account.getBalance());
	}
	
	
	@ExceptionHandler
	public ResponseEntity<AccountErrorResponse> handleException (Exception e){
		
		AccountErrorResponse error = new AccountErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		
		error.setMessage(e.getMessage());
		
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
