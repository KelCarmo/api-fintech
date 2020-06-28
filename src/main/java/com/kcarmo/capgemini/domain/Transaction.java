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
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account accountActive;

	public Transaction(Integer id, Account accountActive) {
		super();
		this.id = id;
		this.status = StatusTransaction.PROCESSING.getCod();
		this.accountActive = accountActive;
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
