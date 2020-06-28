package com.kcarmo.capgemini.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class AccountPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String agency;
	private String ca;
	
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
		AccountPK other = (AccountPK) obj;
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
