package bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import bank.domain.Account;

public interface AccountRepositoryJPA extends JpaRepository<Account, Long> {
    Account findByAccountNumber(long accountNumber);

}
