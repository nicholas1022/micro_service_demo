package com.spring.jpa.demo.findaccountsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.demo.findaccountsservice.entity.Account;
import com.spring.jpa.demo.findaccountsservice.repository.AccountRepository;

@RestController
public class FindAccountsController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping("/accounts")
	public List<Account> findAllAccounts(){
		
		List<Account> accounts = accountRepository.findAll();
		
		return accounts;
	}

}
