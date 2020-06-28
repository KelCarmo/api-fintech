package com.kcarmo.capgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kcarmo.capgemini.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

}