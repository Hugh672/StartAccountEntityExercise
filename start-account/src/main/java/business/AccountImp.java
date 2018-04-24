package business;

import static javax.transaction.Transactional.TxType.REQUIRED;

import java.util.List;

import javax.transaction.Transactional;

import com.qa.domain.Account;

public interface AccountImp {

	Account findAccount(Long id);

	List<Account> findAllAccounts();

	void createAccount(Account account);

	void deleteAccount(Account account);

	void updateAccount(long id, String accountAsJSON);

}