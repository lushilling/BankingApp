package com.qa.service;

import java.util.Collection;

import com.qa.entity.Account;

public interface AccountService {
	
	Collection<Account> getAllAccounts();
	Account getAccount(Long id);
	String deleteAccount(Account account);
	String updateAccount(Account account);
	Account addAccount(Account account);

}
