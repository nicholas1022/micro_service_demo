package com.spring.jpa.demo.deleteaccountservice.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jpa.demo.deleteaccountservice.repository.AccountRepository;

@RestController
public class AccountController {
	
	@Autowired
	AccountRepository accountRepository;
	
	@DeleteMapping("/delete/{id}")
	public void deleteAccount(@PathVariable BigInteger id) {
		
		accountRepository.deleteById(id);
		
	}

}
