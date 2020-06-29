package com.kcarmo.capgemini.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kcarmo.capgemini.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	@Transactional()
	Optional<Account> findByAgencyAndCa(String agency, String ca);
}