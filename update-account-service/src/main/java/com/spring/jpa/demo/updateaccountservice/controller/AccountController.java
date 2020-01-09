package com.spring.jpa.demo.updateaccountservice.controller;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.demo.updateaccountservice.entity.Account;
import com.spring.jpa.demo.updateaccountservice.repository.AccountRepository;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@PutMapping("/{id}/{ownerName}/{balance}")
	public Account updateAccount(@PathVariable BigInteger id, @PathVariable(value = "ownerName") String name, @PathVariable BigDecimal balance) {
		
		Account account = new Account();
		
		account.setId(id);
		
		account.setOwnerName(name);
		
		account.setBalance(balance);
		
		return accountRepository.save(account);
		
	}

}
