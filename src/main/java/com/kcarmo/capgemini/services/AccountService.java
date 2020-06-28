package com.kcarmo.capgemini.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kcarmo.capgemini.domain.Account;
import com.kcarmo.capgemini.repositories.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repoAccount;

	public Account findOne(Integer id) {
		Optional<Account> obj = repoAccount.findById(id);
		
		return obj.orElse(null); 
	}
}
