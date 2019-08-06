package com.qa.rest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.entity.Account;
import com.qa.service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockitoTest {

	@InjectMocks
	AccountController controller;

	@Mock
	AccountService service;

	private static final Account MOCK_ACCOUNT_1 = new Account(1L, "first", "last", "abc123");

	private static final Account MOCK_ACCOUNT_2 = new Account(2L, "first2", "last2", "abc123");

	private static final String MOCK_DELETE_RESPONSE = "Account deleted";
	
	private static final String MOCK_HTTPREQUEST = "200 OK OK,";
	
	private static final String MOCK_ARRAY = "[]";
	

	@Test
	public void getAllAccountsTest() {
		List<Account> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(MOCK_ACCOUNT_1);
		MOCK_LIST.add(MOCK_ACCOUNT_2);
		Mockito.when(service.getAllAccounts()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, controller.getAllAccounts());
		Mockito.verify(service).getAllAccounts();
	}

//	@Test
//	public void getAccountTest() {
//		Mockito.when(service.getAccount(1L)).thenReturn(MOCK_ACCOUNT_1);
//		assertEquals(MOCK_HTTPREQUEST+MOCK_ACCOUNT_1+MOCK_ARRAY, controller.getAccount(1L));
//		Mockito.verify(service).getAccount(1L);
//	}

	@Test
	public void deleteAccountTest() {
		Mockito.when(service.deleteAccount(MOCK_ACCOUNT_1)).thenReturn(MOCK_DELETE_RESPONSE);
		assertEquals(MOCK_DELETE_RESPONSE, controller.deleteAccount(MOCK_ACCOUNT_1));
		Mockito.verify(service).deleteAccount(MOCK_ACCOUNT_1);
	}

	@Test
	public void addAccountTest() {
		Mockito.when(service.addAccount(MOCK_ACCOUNT_1)).thenReturn(MOCK_ACCOUNT_1);
		assertEquals(MOCK_ACCOUNT_1, controller.addAccount(MOCK_ACCOUNT_1).getBody());
		Mockito.verify(service).addAccount(MOCK_ACCOUNT_1);
	}
}
