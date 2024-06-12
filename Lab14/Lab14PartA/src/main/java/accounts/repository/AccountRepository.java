package accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import accounts.domain.Account;

import java.util.Collection;


public interface AccountRepository extends JpaRepository<Account, String>{
   Account findByAccountHolder(String accountHolder);

   Account findByAccountNumber(String accountNumber);

   Collection<Account> findByBalanceGreaterThan(double balance);

}
