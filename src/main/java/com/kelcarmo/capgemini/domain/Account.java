package com.kelcarmo.capgemini.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String agency;
	private String ca;
	private double balance;
	
	@JsonIgnore
	@OneToOne // One-to-one relationship
	@JoinColumn(name="client_id") // Column name
	@MapsId // Id Mapping
	private Client client;
	
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

	public String getCc() {
		return ca;
	}

	public void setCc(String cc) {
		this.ca = cc;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
