package com.kcarmo.capgemini;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kcarmo.capgemini.domain.Account;
import com.kcarmo.capgemini.domain.Client;
import com.kcarmo.capgemini.domain.Deposit;
import com.kcarmo.capgemini.domain.Transaction;
import com.kcarmo.capgemini.domain.WithDraw;
import com.kcarmo.capgemini.repositories.AccountRepository;
import com.kcarmo.capgemini.repositories.ClientRepository;
import com.kcarmo.capgemini.repositories.TransactionRepository;

@SpringBootApplication
public class CapgeminiFintechApplication implements CommandLineRunner{
	
	@Autowired
	private ClientRepository repoClient;
	@Autowired
	private AccountRepository repoAccount;
	@Autowired
	private TransactionRepository repoTransaction;

	public static void main(String[] args) {
		SpringApplication.run(CapgeminiFintechApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client c1 = new Client(null, "Chico Buarque", "bossanova@brasil.com", "00553456847", "Rua Rio de Janeiro, 1960", "(75)999999999");
		Account ca1 = new Account(null, "068-1", "50.580-9", 1000.0, c1);
		
		c1.setAccount(ca1);
		
		Client c2 = new Client(null, "Maria Bethania", "mpb@brasil.com", "00553456848" ,"Rua Bahia , 101", "(75)999999999");
		Account ca2 = new Account(null, "068-0", "40.580-5", 1000.0, c2);
		
		c2.setAccount(ca2);
		
		Transaction t1 = new Deposit(null,ca1, ca2, 50.00);
		Transaction t2 = new WithDraw(null, ca2, ca2, 50.00);
		t1.transaction();
		t2.transaction();
		ca1.getTransactions().addAll(Arrays.asList(t1, t2));
		
		repoClient.saveAll(Arrays.asList(c1, c2));
		repoAccount.saveAll(Arrays.asList(ca1, ca2));
		
		repoTransaction.saveAll(Arrays.asList(t1, t2));
	}

}
