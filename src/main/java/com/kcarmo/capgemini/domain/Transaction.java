package com.kcarmo.capgemini.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kcarmo.capgemini.domain.enums.StatusTransaction;

@Entity
@Table(name = "transactions")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	private Integer status;
	private String type;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "accountActive_id", nullable = false)
	private Account accountActive;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "accountPassive_id", nullable = false)
	private Account accountPassive;

	public Transaction(Integer id, Account accountActive, Account accountPassive, String type) {
		super();
		this.id = id;
		this.status = StatusTransaction.PROCESSING.getCod();
		this.accountActive = accountActive;
		this.accountPassive = accountPassive;
		this.type = type;
	}
	
	public Transaction() {
		
	}
	
	// abstract methods
	public abstract StatusTransaction transaction();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusTransaction getStatus() {
		return StatusTransaction.toEnum(status);
	}

	public void setStatus(StatusTransaction status) {
		this.status = status.getCod();
	}

	public Account getAccountPassive() {
		return accountPassive;
	}

	public void setAccountPassive(Account accountPassive) {
		this.accountPassive = accountPassive;
	}
	
	public Account getAccountActive() {
		return accountActive;
	}

	public void setAccountActive(Account accountActive) {
		this.accountActive = accountActive;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		Transaction other = (Transaction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
