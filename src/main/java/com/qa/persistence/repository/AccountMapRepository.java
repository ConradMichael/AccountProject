package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountMapRepository implements AccountRepository{
	
	Map<Integer, Account> account = new HashMap<>();
	JSONUtil js = new JSONUtil();

	public String getAllAccounts() {
		return js.getJSONForObject(account);
	}

	public String createAccount(String accountIn) {
		
		Account newAccount;
		newAccount = js.getObjectForJSON(accountIn, Account.class);
		this.account.put(newAccount.getAccountNumber(), newAccount);
		
		return "Created Account: " + newAccount.getAccountNumber();
	}

	public String deleteAccount(Integer id) {
		account.remove(id);
		
		return "Deleted Account: " + id;
	}

	public String updateAccount(Integer id, String accountIn) {
		Account newAccount = new Account(accountIn, accountIn, Integer.parseInt(accountIn));
		account.replace(id, newAccount);
		
		return "Update Account: " + id;
	}

	public int getAccountsByName(String string) {
		int accountsFound = 0;
		
		for(Map.Entry<Integer, Account> entry : account.entrySet()) {
			if(entry.getValue().getFirstName().equals(string)) {
				accountsFound++;
			}
		}
		
		return accountsFound;
	}
}
