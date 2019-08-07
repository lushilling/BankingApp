package com.qa.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.entity.Account;
import com.qa.repository.AccountRepository;

@Service
public class AccountServiceImplemented implements AccountService {

	private AccountRepository accountRepo;
	
	private RestTemplate rest;


	@Autowired 
	public AccountServiceImplemented(AccountRepository accountRepo, RestTemplate rest) {
		this.accountRepo = accountRepo;
		this.rest = rest;
	}
	
	public AccountServiceImplemented() {

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

	public Account addAccount(Account account) {
		String accountNumber = rest.getForObject("http://localhost:8082/accountNumber/getAccountNumber6", String.class);
		account.setAccountNumber(accountNumber);
		
		String prize = rest.getForObject("http://localhost:8081/prize/"+ accountNumber, String.class);
		account.setPrize(prize);
		
		return accountRepo.save(account); 
		
	}

	public String updateAccount(Account account) {
		accountRepo.deleteById(account.getId());
		accountRepo.save(account);
		return account.toString();
	}
}
