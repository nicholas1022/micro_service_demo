package com.spring.jpa.demo.transferaccountservice.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jpa.demo.transferaccountservice.entity.Account;

public interface FindAccountRepository extends JpaRepository<Account, BigInteger> {

}
