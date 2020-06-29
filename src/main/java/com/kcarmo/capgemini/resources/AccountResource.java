package com.kcarmo.capgemini.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kcarmo.capgemini.domain.Account;
import com.kcarmo.capgemini.domain.Deposit;
import com.kcarmo.capgemini.domain.Transaction;
import com.kcarmo.capgemini.domain.enums.StatusTransaction;
import com.kcarmo.capgemini.dto.TransactionDTO;
import com.kcarmo.capgemini.services.AccountService;

@RestController
public class AccountResource {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="account/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		Account obj = accountService.findOne(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="account/deposit", method = RequestMethod.POST)
	public ResponseEntity<?> deposit(@RequestBody TransactionDTO requestBody) {
		Transaction obj = accountService.deposit(requestBody.getAccountActive_id(), requestBody.getAccountPassive_id(), requestBody.getValue());
		
		if(obj != null) {
			if(obj.getStatus() == StatusTransaction.SUCCESS) {
				return ResponseEntity.ok().body(obj);
			} else {
				return ResponseEntity.status(400).body(obj);
			}
		}
		
		return ResponseEntity.status(400).body(null);
		
	}
	
	@RequestMapping(value="account/withdraw", method = RequestMethod.POST)
	public ResponseEntity<?> withdraw(@RequestBody TransactionDTO requestBody) {
		Transaction obj = accountService.withDraw(requestBody.getAccountActive_id(), requestBody.getValue());
		
		if(obj != null) {
			if(obj.getStatus() == StatusTransaction.SUCCESS) {
				return ResponseEntity.ok().body(obj);
			} else {
				return ResponseEntity.status(400).body(obj);
			}
		}
			
		return ResponseEntity.status(400).body(null);
	}

}
