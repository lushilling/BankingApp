package com.qa.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.entity.Account;
import com.qa.entity.SentAccount;
import com.qa.repository.AccountRepository;

@Service
public class AccountServiceImplemented implements AccountService {

	private AccountRepository accountRepo;
	
	private RestTemplate rest;

	private JmsTemplate jmsTemplate;


	@Autowired 
	public AccountServiceImplemented(AccountRepository accountRepo, RestTemplate rest, JmsTemplate jmsTemplate) {
		this.accountRepo = accountRepo;
		this.rest = rest;
		this.jmsTemplate = jmsTemplate;
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
		sendToQueue(account);
		
		return accountRepo.save(account); 
		
	}
	
	private Account sendToQueue(Account account) {
		SentAccount sentAccount = new SentAccount(account);
		jmsTemplate.convertAndSend("AccountQueue", sentAccount);
		return account;
	}

	public String updateAccount(Account account) {
		accountRepo.deleteById(account.getId());
		accountRepo.save(account);
		return account.toString();
	}
}
