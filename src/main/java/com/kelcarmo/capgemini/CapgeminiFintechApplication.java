package com.kelcarmo.capgemini;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import com.kelcarmo.capgemini.domain.Account;
import com.kelcarmo.capgemini.domain.Client;
import com.kelcarmo.capgemini.repositories.ClientRepository;
import com.kelcarmo.capgemini.repositories.AccountRepository;

@SpringBootApplication
@ComponentScan({"com.delivery.request"})
public class CapgeminiFintechApplication implements CommandLineRunner{
	
	@Autowired
	private ClientRepository repoClient;
	@Autowired
	private AccountRepository repoAccount;

	public static void main(String[] args) {
		SpringApplication.run(CapgeminiFintechApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client c1 = new Client(null, "Kelvin Carmo", "teste@gmail.com", "Rua Serrinha, 101", "(75)999999999");
		Account ca1 = new Account(null, "068-1", "50.587-9", 1024.0, c1);
		
		c1.setAccount(ca1);
		
		repoClient.saveAll(Arrays.asList(c1));
		repoAccount.saveAll(Arrays.asList(ca1));
		
	}

}
