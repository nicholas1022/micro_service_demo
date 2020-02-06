package com.spring.jpa.demo.deleteaccountservice.controller;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.demo.deleteaccountservice.entity.Account;
import com.spring.jpa.demo.deleteaccountservice.entity.ResponseStatus;
import com.spring.jpa.demo.deleteaccountservice.repository.AccountRepository;


@RestController
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	
	
	@DeleteMapping("/delete/id/{id}")
	public ResponseStatus deleteAccount(@PathVariable BigInteger id) {
		
		Optional<Account> theAccount = accountRepository.findById(id);
		
		
		if(!theAccount.isPresent()) {
			throw new AccountNotFoundException("Account ID not found - " + id);
		}
		
		ResponseStatus responseStatus = new ResponseStatus(false);
		
		accountRepository.deleteById(id);
		
		responseStatus.setSuccess(true);
		
		return responseStatus;
		
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
