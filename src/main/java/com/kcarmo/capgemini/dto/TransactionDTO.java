package com.kcarmo.capgemini.dto;

import java.io.Serializable;

public class TransactionDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private double value;
	private Integer accountActive_id;
	private String  agency;
	private String 	ca;
	
	public TransactionDTO() {
		
	}
	
	public TransactionDTO(Integer accountActive_id, String agency, String ca, double value) {
		this.accountActive_id = accountActive_id;
		this.agency = agency;
		this.ca = ca;
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

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getCa() {
		return ca;
	}

	public void setCa(String ca) {
		this.ca = ca;
	}
	
}
