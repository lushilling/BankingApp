package com.qa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String accountNumber;
	private String prize;
	
	public Account(Long id, String firstName, String lastName, String accountNumber, String prize) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.prize = prize;
	}
	
	public Account() {
		
	}
	
	public Long getId () {
		return id;
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
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

}
