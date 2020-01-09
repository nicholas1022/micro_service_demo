package com.spring.jpa.demo.transferaccountservice;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransferAccountController {
	
	@Autowired
	private UpdateAccountServiceProxy addProxy;
	
	@Autowired
	private UpdateAccountServiceProxy substractProxy;
	
	@Autowired
	private UpdateAccountServiceProxy findFromProxy;
	
	@Autowired
	private UpdateAccountServiceProxy findToProxy;
	
	@PutMapping("transfer-account-feign/{fromId}/{toId}/{amount}")
	public TransferAccountBean transferAccountFeign(@PathVariable("fromId") BigInteger fromId, @PathVariable("toId") BigInteger toId, @PathVariable("amount") BigDecimal amount) {
		
		if(amount.compareTo(new BigDecimal("0"))<=0) return null;
		
		AccountBean fromResponse = findFromProxy.findAccount(fromId);
		
		AccountBean toResponse = findToProxy.findAccount(toId);
		
		if(fromResponse.getBalance().compareTo(amount)<0) return null;
		
		BigDecimal fromBalance = fromResponse.getBalance().subtract(amount);
		
		BigDecimal toBalance = toResponse.getBalance().add(amount);
		
		String fromName = fromResponse.getOwnerName();
		
		String toName = toResponse.getOwnerName();
		
		substractProxy.updateAccount(fromId, fromName, fromBalance);
		
		addProxy.updateAccount(toId, toName, toBalance);
		
		return new TransferAccountBean(fromId, toId, amount, fromBalance, toBalance);
		
	}

}
