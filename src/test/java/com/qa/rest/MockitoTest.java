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
	
	private static final Account MOCK_ACCOUNT_1 = new Account("first 1", "last 1", "1");
	
	private static final Account MOCK_ACCOUNT_2 = new Account("first 2", "last 2", "2");
	
	private static final long MOCK_VALUE = (long) 1;
	
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
//		Mockito.when(service.getAccount((long) 1)).thenReturn(MOCK_ACCOUNT_1);
//		assertEquals(MOCK_ACCOUNT_1, controller.getAccount((long) 1));
//	}

	@Test
	public void deleteAccountTest() {
		Mockito.when(service.deleteAccount(MOCK_ACCOUNT_1)).thenReturn("Account deleted");
		assertEquals("Account deleted", controller.deleteAccount(MOCK_ACCOUNT_1));
	}
}
