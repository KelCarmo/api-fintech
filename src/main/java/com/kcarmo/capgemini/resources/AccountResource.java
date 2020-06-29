package com.kcarmo.capgemini.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kcarmo.capgemini.domain.Account;
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
	
	@RequestMapping(value="account/deposit/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> deposit(@PathVariable Integer id) {
		Account obj = accountService.findOne(id);
		
		return ResponseEntity.ok().body(obj);
	}

}
