package com.spring.jpa.demo.findaccountservice.controller;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.jpa.demo.findaccountservice.entity.Account;
import com.spring.jpa.demo.findaccountservice.entity.AccountBean;
import com.spring.jpa.demo.findaccountservice.repository.AccountRepository;

@RestController
public class AccountController {
	
	
	RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping("/account/id/{id}")
	public AccountBean findAccountById(@PathVariable(value = "id") BigInteger id) {
		
		Optional<Account> theAccount = accountRepository.findById(id);
		
		
		if(!theAccount.isPresent()) {
			throw new AccountNotFoundException("Account ID not found - " + id);
		}else return new AccountBean(true, theAccount.get());
		
	}
	
	@GetMapping("/id/{id}")
	public AccountBean getAccountEntityById(@PathVariable(value = "id") BigInteger id) {
		
		String url = "http://localhost:8400/account/id/{id}";
		
	    ResponseEntity<Account> response = restTemplate.getForEntity(url, Account.class, id);
	    
	    if (response.getBody()==null) {
	    	
	    	throw new AccountNotFoundException("Account ID not found - " + id);
	    	
	    }if(response.getStatusCode() == HttpStatus.OK) {
	        
	    	return new AccountBean(true, response.getBody());
	    			
	    }else return null;
		
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
