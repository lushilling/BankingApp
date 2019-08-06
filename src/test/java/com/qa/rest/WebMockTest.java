package com.qa.rest;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.entity.Account;
import com.qa.service.AccountService;


@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
@AutoConfigureMockMvc
public class WebMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountService service;
	
	@MockBean
	private RestTemplate restTemplate;

	private static final Account MOCK_ACCOUNT_1 = new Account(1L, "first", "last", "abc123");

	private static final Account MOCK_ACCOUNT_2 = new Account(2L, "first2", "last2", "abc123");

	@Test
	public void getAllTest() throws Exception {

		List<Account> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(MOCK_ACCOUNT_1);
		MOCK_LIST.add(MOCK_ACCOUNT_2);

		when(service.getAllAccounts()).thenReturn(MOCK_LIST);

		mockMvc.perform(get("/allAccounts")).andExpect(content().string(containsString("")));
	}

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@Test
	public void addAccountTest() throws Exception {
		
		 String postValue = OBJECT_MAPPER.writeValueAsString(MOCK_ACCOUNT_1);
		 
//		 when(service.createCocktail(MOCK_COCKTAIL_1)).thenReturn(MOCK_COCKTAIL_1);
		 
		 doReturn(MOCK_ACCOUNT_1).when(service).addAccount(MOCK_ACCOUNT_1);
		 
		mockMvc.perform(MockMvcRequestBuilders
                .post("/addAccount")
                .contentType(MediaType.APPLICATION_JSON).content(postValue))
                .andExpect(status().isCreated())
                .andDo(print())
                .andReturn();
	
	}
}
