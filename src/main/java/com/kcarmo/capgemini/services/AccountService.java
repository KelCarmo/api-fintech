package com.kcarmo.capgemini.services;

import java.util.Arrays;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kcarmo.capgemini.domain.Account;
import com.kcarmo.capgemini.domain.Deposit;
import com.kcarmo.capgemini.domain.Transaction;
import com.kcarmo.capgemini.domain.WithDraw;
import com.kcarmo.capgemini.repositories.AccountRepository;
import com.kcarmo.capgemini.repositories.TransactionRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository repoAccount;
	
	@Autowired
	private TransactionRepository repoTransaction;

	public Account findOne(Integer id) {
		Optional<Account> obj = repoAccount.findById(id);
		
		if(obj.orElse(null) == null) {
			throw new RuntimeException("Object not found!");
		}
		
		return obj.orElse(null);
	}
	
	public Transaction deposit(Integer id_active, Integer id_passive, double value) {
		Optional<Account> active = repoAccount.findById(id_active);
		Optional<Account> passive = repoAccount.findById(id_passive);
		
		Transaction t1 = null;
		
		if(active.orElse(null) != null && passive.orElse(null) != null) {
			Account ca1 = active.orElse(null);
			Account ca2 = passive.orElse(null);
			
			t1 = new Deposit(null, ca1, ca2, value);
			
			t1.transaction();
			ca1.getTransactions().add(t1);
			repoAccount.saveAll(Arrays.asList(ca1, ca2));
			
			repoTransaction.save(t1);
		}
		
		return t1;
	}
	
	public Transaction withDraw(Integer id_active, double value) {
		Optional<Account> active = repoAccount.findById(id_active);
		
		Transaction t1 = null;
		
		if(active.orElse(null) != null) {
			Account ca1 = active.orElse(null);
			
			t1 = new WithDraw(null, ca1, ca1, value);
			
			t1.transaction();
			ca1.getTransactions().add(t1);
			repoAccount.saveAll(Arrays.asList(ca1));
			repoTransaction.save(t1);
		}
		
		return t1;
	}
}
