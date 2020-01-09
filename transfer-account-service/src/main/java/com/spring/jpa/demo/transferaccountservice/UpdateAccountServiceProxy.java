package com.spring.jpa.demo.transferaccountservice;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="transfer-account-service")
public interface UpdateAccountServiceProxy {
	
	@PutMapping("/update-account-service/account/{id}/{ownerName}/{balance}")
	public AccountBean updateAccount(@PathVariable BigInteger id, @PathVariable String ownerName, @PathVariable BigDecimal balance);
	
	@GetMapping("/find-account-service/account/{id}")
	public AccountBean findAccount(@PathVariable BigInteger id);


}
