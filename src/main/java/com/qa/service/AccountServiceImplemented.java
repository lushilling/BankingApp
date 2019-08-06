package com.qa.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.entity.Account;
import com.qa.repository.AccountRepository;

@Service
public class AccountServiceImplemented implements AccountService {

	private AccountRepository accountRepo;

	public AccountServiceImplemented() {

	}

	@Autowired 
	public AccountServiceImplemented(AccountRepository accountRepo) {
		this.accountRepo = accountRepo;
	}

	public Collection<Account> getAllAccounts() {
		return accountRepo.findAll();
	}

	public Account getAccount(Long id) {
		Account accountWanted = accountRepo.findById(id).get();
		return accountWanted;
	}

	public String deleteAccount(Account account) {
		accountRepo.delete(account);
		return "Account deleted";
	}

	public String updateAccount(Account account) {
		accountRepo.deleteById(account.getId());
		accountRepo.save(account);
		return account.toString();
	}

	public Account addAccount(Account account) {
		return accountRepo.save(account); 
	}

}
