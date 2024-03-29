package com.qa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.entity.Account;
import com.qa.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	public AccountController(AccountService accountService, JmsTemplate jmsTemplate) {
		this.accountService = accountService;
		this.setJmsTemplate(jmsTemplate);
	}

	public AccountController() {
	}

	@GetMapping("/allAccounts")
	public Collection<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	@GetMapping("/getAccount/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable Long id) {
		return new ResponseEntity<>(accountService.getAccount(id), HttpStatus.OK);
	}

	@DeleteMapping("/deleteAccount")
	public String deleteAccount(Account account) {
		return accountService.deleteAccount(account);
	}

	@PutMapping("/updateAccount/{id}")
	public ResponseEntity<Object> updateAccount(@PathVariable Long id, Account account) {
		return new ResponseEntity<>(accountService.updateAccount(account), HttpStatus.OK);
	}

	@PostMapping("/addAccount")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {
		Account newAccount = accountService.addAccount(account);
		return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
	}

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
		


}