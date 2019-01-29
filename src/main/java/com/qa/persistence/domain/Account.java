package com.qa.persistence.domain;

import javax.persistence.Entity;

@Entity
public class Account {
	
	private String firstName;
	private String lastName;
	private Integer accountNumber;
	
	public Account(String fName, String lName, Integer accNumber) {
		this.firstName = fName;
		this.lastName = lName;
		this.accountNumber = accNumber;
	}

	public Account() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	
}
