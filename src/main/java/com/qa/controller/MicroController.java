package com.qa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

public class MicroController {
	
	private RestTemplate restTemplate;
	
	private static final String ACCOUNT_NUMBER_URL = "http://localhost:8082";
	
	private static final String ACCOUNT_PRIZE_URL = "http://localhost:8081";
	
	@Autowired
	public MicroController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public MicroController() {
	}
	
	@GetMapping("/getAccountNumber")
	public ResponseEntity<String> getAccountNumber(){
		return restTemplate.exchange(ACCOUNT_NUMBER_URL, HttpMethod.GET, null, String.class);
	}
	
	@GetMapping("/getAccountPrize")
	public ResponseEntity<String> getAccountPrize(){
		return restTemplate.exchange(ACCOUNT_PRIZE_URL, HttpMethod.GET, null, String.class);
	}
	
}
