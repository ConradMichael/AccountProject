package com.qa.persistence.repository;

public interface AccountRepository {

	String getAllAccounts();
	String createAccount(String account);
	String deleteAccount(Integer id);
	String updateAccount(Integer id, String account);

}
