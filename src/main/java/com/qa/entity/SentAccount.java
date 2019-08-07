package com.qa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SentAccount {

	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String accountNumber;
	private String prize;
	
	public SentAccount(Account account) {
		this.id = account.getId();
		this.firstName = account.getFirstName();
		this.lastName = account.getLastName();
		this.accountNumber = account.getLastName();
		this.prize = account.getPrize();
	}
	
	public SentAccount() {
		
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
