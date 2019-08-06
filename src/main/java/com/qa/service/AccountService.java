package com.qa.service;

import java.util.Collection;

import com.qa.entity.Account;

public interface AccountService {
	
	Collection<Account> getAllAccounts();
	Account getAccount(Long id);
	Account deleteAccount(Long id);
	Account updateAccount(Long id, String account);
	Account addAccount(Account account);

}
