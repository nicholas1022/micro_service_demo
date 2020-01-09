package com.spring.jpa.demo.findaccountservice.controller;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.demo.findaccountservice.entity.Account;
import com.spring.jpa.demo.findaccountservice.repository.AccountRepository;

@RestController
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping("/account/{id}")
	public Optional<Account> findAccountById(@PathVariable(value = "id") BigInteger id) {
		
		Optional<Account> theAccount = accountRepository.findById(id);
		
		return theAccount;
		
	}

}
