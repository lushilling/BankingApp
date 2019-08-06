package com.qa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.entity.Account;
import com.qa.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController{
	
	@Autowired
	AccountService accountService;

	@GetMapping("/allAccounts")
	public Collection<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	@GetMapping("/getAccount/{id}")
	public String getAccount(@PathVariable("id") Long id) {
		return accountService.getAccount(id);
	}

	@DeleteMapping("/deleteAccount/{id}")
	public String deleteAccount(@PathVariable("id") Long id) {
		return accountService.deleteAccount(id);
	}

	@PutMapping("/{id}")
	public String updateAccount(@PathVariable("id") Long id, String account) {
		return accountService.updateAccount(id, account);
	}

	@PostMapping("/addAccount")
	public String addAccount(String account) {
		return accountService.addAccount(account);
	}

}
