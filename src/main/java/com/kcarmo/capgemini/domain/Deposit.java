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
			if(this.getAccountActive().getBalance() >= this.value) {
				this.getAccountActive().subBalance(value);
				this.getAccountPassive().addBalance(value);
				super.setStatus(StatusTransaction.SUCCESS);
			} else {
				super.setStatus(StatusTransaction.INSUFFICIENT_FUNDS);
			}
		}
		
		return this.getStatus();
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
}
