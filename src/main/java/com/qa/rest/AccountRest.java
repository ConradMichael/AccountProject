package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.persistence.repository.AccountRepository;

@Path("/account")

public class AccountRest {
	
	@Inject
	private AccountRepository accountRepo;
	
	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts(){		
		return accountRepo.getAllAccounts();
	}
	
	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return accountRepo.createAccount(account);
	}

	public void setRepo(AccountRepository accountRepo) {
		this.accountRepo = accountRepo;
	}
	
}
