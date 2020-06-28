package com.kcarmo.capgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kcarmo.capgemini.domain.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

}