package com.kcarmo.capgemini.services;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kcarmo.capgemini.domain.Account;
import com.kcarmo.capgemini.domain.Deposit;
import com.kcarmo.capgemini.domain.Transaction;
import com.kcarmo.capgemini.domain.WithDraw;
import com.kcarmo.capgemini.domain.enums.StatusTransaction;
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
	
	public Transaction deposit(Integer id_active, String agency_passive, String ca_passive, double value) {
		Optional<Account> active = repoAccount.findById(id_active);
		Optional<Account> passive = repoAccount.findByAgencyAndCa(agency_passive, ca_passive);
		
		Transaction t1 = null;
		
		if(active.orElse(null) != null && passive.orElse(null) != null) {
			Account ca1 = active.orElse(null);
			Account ca2 = passive.orElse(null);
			
			t1 = new Deposit(null, ca1, ca2, value);
			
			StatusTransaction status = t1.transaction(); 
			
			if(StatusTransaction.SUCCESS == status) {
				ca1.getTransactions().add(t1);
				repoAccount.saveAll(Arrays.asList(ca1, ca2));
				
				repoTransaction.save(t1);
				
				return t1;
			}
		}
		
		t1 = new Deposit(null, active.orElse(null), passive.orElse(null), value);
		t1.setStatus(StatusTransaction.ACCOUNT_NOT_FIND);
		
		return t1;
	}
	
	public Transaction withDraw(Integer id, double value) {
		Optional<Account> active = repoAccount.findById(id);
		
		Transaction t1 = null;
		
		if(active.orElse(null) != null) {
			Account ca1 = active.orElse(null);
			
			t1 = new WithDraw(null, ca1, ca1, value);
			
			StatusTransaction status = t1.transaction(); 
			
			if(StatusTransaction.SUCCESS == status) {
				ca1.getTransactions().add(t1);
				repoAccount.save(ca1);
				
				repoTransaction.save(t1);
			}
		}
		
		return t1;
	}
}
