package com.spring.jpa.demo.transferaccountservice;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransferAccountController {
	
	@Autowired
	private FindAccountRepository accountRepository;
	
	@Autowired
	private UpdateAccountServiceProxy addProxy;
	
	@Autowired
	private UpdateAccountServiceProxy substractProxy;
	
	@Autowired
	private UpdateAccountServiceProxy findFromProxy;
	
	@Autowired
	private UpdateAccountServiceProxy findToProxy;
	
	@PutMapping("transfer/account")
	public TransferAccountResponse transferAccountFeign(@RequestBody TransferAccountBean theTransferAccountBean) {
			
			BigDecimal amount = theTransferAccountBean.getAmount();
		
			BigInteger fromId = theTransferAccountBean.getFromId();
			
			BigInteger toId = theTransferAccountBean.getToId();
			
			Optional<Account> fromAccount = accountRepository.findById(fromId);
			
			Optional<Account> toAccount = accountRepository.findById(toId);
			
			if(!fromAccount.isPresent()) {
				
				throw new AccountNotFoundException("Account ID not found - " + fromId);
				
			}else if(!toAccount.isPresent()) {
				
				throw new AccountNotFoundException("Account ID not found - " + toId);
				
			}else if(amount.compareTo(new BigDecimal("0"))<=0) {
				
				throw new AmountLessThanZeroException("Transfer amount must be greater than zero");
			}else if(fromId.compareTo(toId)==0) {
				throw new TransferToIdenticalAccountException("Unable to transfer amount to same account");
			}
			
			Account fromResponse = findFromProxy.findAccount(fromId);
			
			Account toResponse = findToProxy.findAccount(toId);
			
			if(fromResponse.getBalance().compareTo(amount)<0) {
				
				throw new BalanceLessThanAmountException("Account balance is less than transfer amount");
			
			}
			
			BigDecimal afterTransFromBalance = fromResponse.getBalance().subtract(amount);
			
			fromResponse.setBalance(afterTransFromBalance);
			
			BigDecimal afterTransToBalance = toResponse.getBalance().add(amount);
			
			toResponse.setBalance(afterTransToBalance);
			
			substractProxy.updateAccount(fromResponse);
			
			addProxy.updateAccount(toResponse);
			
			TransferAccountResponse transferAccount = new TransferAccountResponse(true, fromResponse.getId(), toResponse.getId(), amount, fromResponse.getBalance(), toResponse.getBalance());
			
			return transferAccount;
			
		
	}
	
	@ExceptionHandler
	public ResponseEntity<AccountErrorResponse> handleException (AccountNotFoundException e){
		
		AccountErrorResponse error = new AccountErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		
		error.setMessage(e.getMessage());
		
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<AccountErrorResponse> handleException (AmountLessThanZeroException e){
		
		AccountErrorResponse error = new AccountErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		
		error.setMessage(e.getMessage());
		
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<AccountErrorResponse> handleException (BalanceLessThanAmountException e){
		
		AccountErrorResponse error = new AccountErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		
		error.setMessage(e.getMessage());
		
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<AccountErrorResponse> handleException (Exception e){
		
		AccountErrorResponse error = new AccountErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		
		error.setMessage(e.getMessage());
		
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	


}
