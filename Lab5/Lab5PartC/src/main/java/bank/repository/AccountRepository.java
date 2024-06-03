package bank.repository;

import bank.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

public interface AccountRepository extends JpaRepository<Account, Long>{
	public Account getByAccountNumber(long accountNumber);
}
