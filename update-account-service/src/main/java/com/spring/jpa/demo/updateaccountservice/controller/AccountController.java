package com.spring.jpa.demo.updateaccountservice.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.jpa.demo.updateaccountservice.controller.AccountNotFoundException;
import com.spring.jpa.demo.updateaccountservice.controller.AccountErrorResponse;
import com.spring.jpa.demo.updateaccountservice.entity.Account;
import com.spring.jpa.demo.updateaccountservice.entity.AccountBean;
import com.spring.jpa.demo.updateaccountservice.repository.AccountRepository;

@RestController
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	
	RestTemplate restTemplate = new RestTemplate();
	
	@PutMapping("/update/account")
	public AccountBean updateAccount(@RequestBody Account theAccount) {
		
		Optional<Account> account = accountRepository.findById(theAccount.getId());
		
		
		if(!account.isPresent()) {
			throw new AccountNotFoundException("Account ID not found - " + theAccount.getId());
		}
		
		accountRepository.save(theAccount);
		
		return new AccountBean(true, theAccount.getId(), theAccount.getCustomerCode(), theAccount.getBalance());
		
	}
	

	
	@ExceptionHandler
	public ResponseEntity<AccountErrorResponse> handleException (AccountNotFoundException e){
		
		AccountErrorResponse error = new AccountErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		
		error.setMessage(e.getMessage());
		
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
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
