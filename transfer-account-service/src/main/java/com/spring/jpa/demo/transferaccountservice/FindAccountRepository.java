package com.spring.jpa.demo.transferaccountservice;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FindAccountRepository extends JpaRepository<Account, BigInteger> {

}
