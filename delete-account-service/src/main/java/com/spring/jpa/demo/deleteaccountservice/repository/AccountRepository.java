package com.spring.jpa.demo.deleteaccountservice.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.demo.deleteaccountservice.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, BigInteger>{

}
