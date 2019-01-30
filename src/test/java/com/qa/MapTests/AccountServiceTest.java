package com.qa.MapTests;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {
	
	JSONUtil js;
	AccountMapRepository acc;
	AccountRepository repo;

	@Before
	public void setup() {
		 js = new JSONUtil();
		 acc = new AccountMapRepository();
	}

	@Test
	public void addAccountTest() {
		Account newAccount = new Account("First Name","Last Name", 1);
		String accountString = js.getJSONForObject(newAccount);
		acc.createAccount(accountString);
		Account newAccount1 = js.getObjectForJSON(accountString, Account.class);
		
		assertEquals("1", newAccount.getAccountNumber().toString());
	}

	@Test
	public void add2AccountTest() {
		Account newAccount = new Account("First Name","Last Name", 1);
		Account newAccount2 = new Account("First Name","Last Name", 2);
		
		String accountString = js.getJSONForObject(newAccount);
		String accountString2 = js.getJSONForObject(newAccount2);
		
		acc.createAccount(accountString);
		acc.createAccount(accountString2);
		
		newAccount = js.getObjectForJSON(accountString, Account.class);
		newAccount2 = js.getObjectForJSON(accountString2, Account.class);
		

		assertEquals("1", newAccount.getAccountNumber().toString());
		assertEquals("2", newAccount2.getAccountNumber().toString());
	}
	
	@Test
	public void removeAccountTest() {
		Account newAccount = new Account("First Name","Last Name", 1);
		String accountString = js.getJSONForObject(newAccount);
		acc.createAccount(accountString);
		Account newAccount1 = js.getObjectForJSON(accountString, Account.class);
		
		assertEquals("1", newAccount.getAccountNumber().toString());
		
		System.out.println(acc.getAllAccounts());
		acc.deleteAccount(1);
		System.out.println(acc.getAllAccounts());
		
		assertEquals("{}",acc.getAllAccounts());
	}
	
	@Test
	public void remove2AccountTest() {
		Account newAccount = new Account("First Name","Last Name", 1);
		Account newAccount2 = new Account("First Name","Last Name", 2);
		
		String accountString = js.getJSONForObject(newAccount);
		String accountString2 = js.getJSONForObject(newAccount2);  
		
		acc.createAccount(accountString);
		acc.createAccount(accountString2);
		
		newAccount = js.getObjectForJSON(accountString, Account.class);
		newAccount2 = js.getObjectForJSON(accountString2, Account.class);

		assertEquals("1", newAccount.getAccountNumber().toString());
		acc.deleteAccount(1);
		
		assertEquals("2", newAccount2.getAccountNumber().toString());
		acc.deleteAccount(2);
		
		assertEquals("{}",acc.getAllAccounts());
	}
	
	@Test
	public void getAccountsByFirstName() {
		Account newAccount = new Account("John","Last Name", 1);
		Account newAccount2 = new Account("John","Last Name", 2);
		
		String accountString = js.getJSONForObject(newAccount);
		String accountString2 = js.getJSONForObject(newAccount2);
		
		acc.createAccount(accountString);
		acc.createAccount(accountString2);
		
		newAccount = js.getObjectForJSON(accountString, Account.class);
		newAccount2 = js.getObjectForJSON(accountString2, Account.class);
		

		assertEquals("1", newAccount.getAccountNumber().toString());
		assertEquals("2", newAccount2.getAccountNumber().toString());
		
		acc.getAllAccounts();
		
		assertEquals(2, acc.getAccountsByName("John"));
		
	}

}
