package com.qa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.entity.Account;
import com.qa.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	private AccountService accountService;

	private RestTemplate restTemplate;

	@Autowired
	public AccountController(AccountService accountService, RestTemplate restTemplate) {
		this.accountService = accountService;
		this.restTemplate = restTemplate;
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

	@GetMapping("/getMicro")
	public String getMicro() {
		ResponseEntity<String> exchangeCocktail = restTemplate.exchange("http://localhost:8081/getMicro",
				HttpMethod.GET, null, String.class);
		return exchangeCocktail.getBody();

	}

}