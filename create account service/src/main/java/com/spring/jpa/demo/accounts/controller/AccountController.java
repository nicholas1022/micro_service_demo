package com.spring.jpa.demo.accounts.controller;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.jpa.demo.accounts.entity.Account;
import com.spring.jpa.demo.accounts.repository.AccountRepository;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@PostMapping("/create/{ownerName}/{initialBalance}")
	public Account createAccount(Account theAccount, @PathVariable(value = "ownerName") String ownerName, @PathVariable(value = "initialBalance") BigDecimal balance) {
		
		theAccount.setOwnerName(ownerName);
		theAccount.setBalance(balance);
		
	    return accountRepository.save(theAccount);
	}

}
