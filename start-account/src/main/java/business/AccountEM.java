package business;

import java.util.List;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import com.qa.domain.Account;
import com.qa.util.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class AccountEM implements AccountImp {
	
	@PersistenceContext(unitName = "primary")
    private EntityManager em;

	@Inject
	JSONUtil ju;
    
    @Override
	public Account findAccount(Long id) {
        return em.find(Account.class, id);
    }
 
    @Override
	public List<Account> findAllAccounts(){
    	TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a ORDER BY a.firstName DESC", Account.class);
    	return query.getResultList();
    }
    
    @Override
	@Transactional(REQUIRED)
    public String createAccount(Account account) {
    	em.persist(account);
    	return "Account has been created";
    }
    
    @Override
	@Transactional(REQUIRED)
    public String deleteAccount(Account account) {
    	em.remove(account);
    	return "Account has been deleted";
    }
   
    @Override
	@Transactional(REQUIRED)
    public String updateAccount(long id, String accountAsJSON) {
    	Account original=em.find(Account.class,id);
    	Account updated=ju.getObjectForJSON(accountAsJSON,Account.class);
    	if (original!=null) {
    		em.merge(updated);
    		return "Account has been updated";
    	}
    	
    	return "Account has not been updated";
    }
    
 

}


