package com.spring.jpa.demo.findaccountsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.jpa.demo.findaccountsservice.entity.Account;
import com.spring.jpa.demo.findaccountsservice.entity.Accounts;
import com.spring.jpa.demo.findaccountsservice.repository.AccountRepository;

@RestController
public class FindAccountsController {
	
	@Autowired
	AccountRepository accountRepository;
	
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/accounts")
	public List<Account> findAllAccounts(){
		
		List<Account> accounts = accountRepository.findAll();
		
		return accounts;
	}
	
	@GetMapping("/getAllAccounts")
	public Accounts getAllAccount() {
		
		String url = "http://localhost:8300/accounts";
		
	    ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);
	    
	    if(response.getStatusCode() == HttpStatus.OK) {
	        
	    	return new Accounts(true, response.getBody());
	    			
	    }else return null;
		
	}

}
