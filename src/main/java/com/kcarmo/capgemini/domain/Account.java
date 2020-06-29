package com.kcarmo.capgemini.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	@Column(unique = true, nullable = false)
	private String agency;
	@Column(unique = true, nullable = false)
	private String ca;
	private double balance;
	
	@JsonIgnore
	@OneToOne // One-to-one relationship
	@JoinColumn(name="client_id") // Column name
	@MapsId // Id Mapping
	private Client client;
	
	@OneToMany(mappedBy = "accountActive")
	private List<Transaction> transactions = new ArrayList<>();
	
	public Account() {
		
	}
	
	/**
	 * Method Constructor
	 * @param id
	 * @param agency
	 * @param ca
	 * @param balance
	 * @param client
	 */
	public Account(Integer id, String agency, String ca, double balance, Client client) {
		super();
		
		this.id = id;
		this.agency = agency;
		this.ca = ca;
		this.balance = balance;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void addBalance(double balance) {
		this.balance += balance;
	}
	
	public void subBalance(double balance) {
		this.balance -= balance;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agency == null) ? 0 : agency.hashCode());
		result = prime * result + ((ca == null) ? 0 : ca.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (agency == null) {
			if (other.agency != null)
				return false;
		} else if (!agency.equals(other.agency))
			return false;
		if (ca == null) {
			if (other.ca != null)
				return false;
		} else if (!ca.equals(other.ca))
			return false;
		return true;
	}
}
