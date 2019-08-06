package com.qa.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import com.qa.entity.Account;
import com.qa.repository.AccountRepository;

public class AccountServiceImplemented implements AccountService {

	@Autowired
	AccountRepository accountRepo;
	
	@Override
	public Collection<Account> getAllAccounts() {
		return accountRepo.findAll();
	}

	@Override
	public Account getAccount(Long id) {
		Account accountWanted = accountRepo.findById(id).get();
		return accountWanted;
	}

	@Override
	public Account deleteAccount(Long id) {
		return null;
				//accountRepo.deleteById(id);
	}

	@Override
	public Account updateAccount(Long id, String account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account addAccount(Account account) {
		return accountRepo.save(account);
	}

}
