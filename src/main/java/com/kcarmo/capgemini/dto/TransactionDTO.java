package com.kcarmo.capgemini.dto;

import java.io.Serializable;

public class TransactionDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private double value;
	private Integer accountActive_id;
	private Integer accountPassive_id;
	
	public TransactionDTO() {
		
	}
	
	public TransactionDTO(Integer accountActive_id, Integer accountPassive_id, double value) {
		this.accountActive_id = accountActive_id;
		this.accountPassive_id = accountPassive_id;
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Integer getAccountActive_id() {
		return accountActive_id;
	}

	public void setAccountActive_id(Integer accountActive_id) {
		this.accountActive_id = accountActive_id;
	}

	public Integer getAccountPassive_id() {
		return accountPassive_id;
	}

	public void setAccountPassive_id(Integer accountPassive_id) {
		this.accountPassive_id = accountPassive_id;
	}
}
