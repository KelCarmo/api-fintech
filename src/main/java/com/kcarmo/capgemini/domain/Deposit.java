package com.kcarmo.capgemini.domain;

import javax.persistence.Entity;

import com.kcarmo.capgemini.domain.enums.StatusTransaction;

@Entity
public class Deposit extends Transaction {
	private static final long serialVersionUID = 1L;
	
	private Double value;
	
	public Deposit() {
		
	}

	public Deposit(Integer id, Account accountActive, Account accountPassive, Double value) {
		super(id, accountActive, accountPassive, "Deposit");
		
		this.value = value;
	}

	@Override
	public StatusTransaction transaction() {
		// Execute Transaction
		if(super.getAccountActive().equals(super.getAccountPassive())) {
			this.getAccountActive().addBalance(value);
		} else {
			this.getAccountActive().subBalance(value);
			this.getAccountPassive().addBalance(value);
		}
		
		super.setStatus(StatusTransaction.SUCCESS);
		
		return StatusTransaction.SUCCESS;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
