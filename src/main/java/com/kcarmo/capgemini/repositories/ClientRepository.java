package com.kcarmo.capgemini.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kcarmo.capgemini.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
