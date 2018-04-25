package com.qa.business;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


import business.AccountEM;
import business.AccountImp;
import com.qa.domain.Account;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class AccountEMTest {
	
	@InjectMocks
	private AccountImp accDBImp = new AccountEM();
	
	@Mock 
	private EntityManager em;
	
	
	@Mock 
	private Account account;
	
	
	@Mock 
	JSONUtil ju;
	
	
	@Test
	public void createAccountTest() {
		assertEquals(accDBImp.createAccount(account),"Account has been created");
	}
	
	@Test 
	public void deleteAccountTest() {
		assertEquals(accDBImp.deleteAccount(account),"Account has been deleted");
	}
	@Test
	public void findAccountTest() {
		Mockito.when(em.find((Account.class),1L)).thenReturn(account);
		assertEquals(accDBImp.findAccount(1L),account);
	}
	
	
}
