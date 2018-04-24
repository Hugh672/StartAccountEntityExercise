package com.qa.application;

import com.qa.domain.Account;
import com.qa.service.AccountService;
import com.qa.util.JSONUtil;

import business.AccountEM;
import business.AccountImp;

public class App {

	public static void main(String[] args) {
		AccountService service = new AccountService();
		JSONUtil util = new JSONUtil();
		Account joeBloggs = new Account("JOE", "BLOGGS", 1234);
		Account janeBloggs = new Account("JANE", "BLOGGS", 1235);
		Account samStone = new Account("SAM", "STONE", 1236);
		service.addAccountFromMap(joeBloggs);
		service.addAccountFromMap(janeBloggs);
		service.addAccountFromMap(samStone);

		String mapAsJSON = util.getJSONForObject(service.getAccountMap());
		System.out.println("This is the account map as JSON " + mapAsJSON);
		AccountImp business = new AccountEM();

	}

}