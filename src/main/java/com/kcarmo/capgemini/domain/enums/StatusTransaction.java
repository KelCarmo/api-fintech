package com.kcarmo.capgemini.domain.enums;

public enum StatusTransaction {
	
	SUCCESS(1, "Sucess"),
	DENIED(2, "Denied"),
	ERROR(3, "Error"),
	PROCESSING(4, "Processing");
	
	private int cod;
	private String description;

	private StatusTransaction() {
		
	}

	private StatusTransaction(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static StatusTransaction toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(StatusTransaction x : StatusTransaction.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid Id: " + cod);
	}
}
