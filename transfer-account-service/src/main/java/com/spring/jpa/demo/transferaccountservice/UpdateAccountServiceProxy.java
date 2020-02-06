package com.spring.jpa.demo.transferaccountservice;

import java.math.BigInteger;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="transfer-account-service")
public interface UpdateAccountServiceProxy {
	
	@PutMapping("/update-account-service/update/account")
	public Account updateAccount(@RequestBody Account theAccount);
	
	@GetMapping("/find-account-service/account/id/{id}")
	public Account findAccount(@PathVariable BigInteger id);


}
