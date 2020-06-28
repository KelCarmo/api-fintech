package com.kcarmo.capgemini.domain;

import javax.persistence.Entity;

import com.kcarmo.capgemini.domain.enums.StatusTransaction;

@Entity
public class WithDraw extends Transaction {
	private static final long serialVersionUID = 1L;
	
	private Double value;
	
	public WithDraw() {
		
	}
	
	public WithDraw(Integer id, Account accountActive, Double value) {
		super(id, accountActive);
		
		this.value = value;
	}

	@Override
	public StatusTransaction transaction() {
		// Execute Transaction
		
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
