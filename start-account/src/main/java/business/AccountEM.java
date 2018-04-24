package business;

import java.awt.List;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.domain.Account;

@Transactional(SUPPORTS)
public class AccountEM {

			@PersistenceContext(unitName = "primary")
			private EntityManager em;
			
			@Inject
			JSONUtil util;
			
			public Account findAccount(long id) {
				
				return em.find(Account.class, id);
			}
			
			public List<Account> findAllAccounts(){
				TypedQuery<Account> query = em.createQuery("SELECT a FROM account a ORDER BY a.firstName DESC",Account.class);
				return query.getResultList();
			}
			
			public void createAccount(Account account) {
				em.persist(account);
			}
			
			public void removeAccount(Account account) {
				em.remove(account);
			}
			
			
			public void updateAccount(long id, String accountAsJSON) {
				Account original=em.find(Account.class, id)
				Account updated=getObjectForJSON();
				
			}
			
			
			
}

