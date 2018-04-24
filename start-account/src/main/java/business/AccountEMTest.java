package business;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.domain.Account;
import com.qa.util.JSONUtil;

import business.AccountEM;

@RunWith(MockitoJUnitRunner.class)
public class AccountEMTest {
	
	@InjectMocks
	private AccountImp accEmImp = new AccountEM();
	
	@Mock 
	private EntityManager em;
	
	@Mock
	private Account account;
	
	@Mock 
	JSONUtil ju;

	@Test
	public void createAccountTest() {
		assertEquals(accEmImp.createAccount(account),"Account has been created");
	}
	
	@Test 
	public void deleteAccountTest() {
		assertEquals(accEmImp.deleteAccount(account),"Account has been deleted");
	}
	@Test
	public void findAccount() {
		Mockito.when(em.find((Account.class),1L)).thenReturn(account);
		assertEquals(accEmImp.findAccount(1L),account);
	}
	
}
