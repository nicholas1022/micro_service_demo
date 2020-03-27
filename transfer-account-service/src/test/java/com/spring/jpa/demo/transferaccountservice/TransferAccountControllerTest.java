package com.spring.jpa.demo.transferaccountservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.jpa.demo.transferaccountservice.controller.TransferAccountController;
import com.spring.jpa.demo.transferaccountservice.entity.Account;
import com.spring.jpa.demo.transferaccountservice.repository.UpdateAccountServiceProxy;


@SpringBootTest
class TransferAccountControllerTest extends TransferAccountController{
	
	@Autowired
	private UpdateAccountServiceProxy updateProxy;
	
	//@ParameterizedTest
	//@ArgumentsSource(fromAccountTestParameterProvider.class)
	@Test
	void fromAccountTest() {
		BigInteger fromId = new BigInteger("1");
		
		//BigInteger toId = new BigInteger("2");
		
		Account fromResponse = updateProxy.findAccount(new BigInteger("1"));
		
		Account toResponse = updateProxy.findAccount(new BigInteger("2"));
		
		BigDecimal amount = new BigDecimal("1");
		
		BigDecimal fromBeforeBalance = fromResponse.getBalance();
		
		BigDecimal fromAfterBalance = fromResponse.getBalance().subtract(amount);
		
		BigDecimal toBalance = toResponse.getBalance().add(amount);
		
		BigInteger fromCode = fromResponse.getCustomerCode();
		
		BigInteger toCode = toResponse.getCustomerCode();
		
		updateProxy.updateAccount(new Account(fromCode, fromAfterBalance));
		
		updateProxy.updateAccount(new Account(toCode, toBalance));
		
		assertEquals(fromBeforeBalance.subtract(amount), updateProxy.findAccount(fromId).getBalance(), "Original balance - transfer amount should be equal to completed balance of transfer out account");
	
	}
	
	
	
	/*@ParameterizedTest
	@CsvSource({
		"3, 4, 99, 99.37"
	})
	void toAccountTest(ArgumentsAccessor arguments) {
		
		TransferTestArgumentProvider argumentProvider = new TransferTestArgumentProvider(new BigInteger(arguments.getString(0)), new BigInteger(arguments.getString(1)), new BigDecimal(arguments.getString(2)), new BigDecimal(arguments.getString(3)));  
		
		TransferAccountController tester = new TransferAccountController();
		
		assertEquals(argumentProvider.getResult(), tester.transferAccountFeign(argumentProvider.getFromId(), argumentProvider.getToId(), argumentProvider.getAmount()).getToBalance(), "Original balance + transfer amount should be equal to completed balance of transfer in account");
	}*/
	

	
	

}
