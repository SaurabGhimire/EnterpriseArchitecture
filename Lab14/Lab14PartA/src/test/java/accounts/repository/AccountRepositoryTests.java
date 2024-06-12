package accounts.repository;

import accounts.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void whenFindByAccountHolder_thenReturnAccount() {
        // Given
        Account account = new Account("123", 100.0, "Account Holder 1");
        entityManager.persist(account);
        entityManager.flush();
        // When
        Account found = accountRepository.findByAccountHolder(account.getAccountHolder());
        // Then
        assertThat(found.getAccountNumber()).isEqualTo(account.getAccountNumber());
    }

    @Test
    public void whenFindByAccountNumber_thenReturnAccount() {
        // Given
        Account account = new Account("123", 100.0, "Account Holder 1");
        entityManager.persist(account);
        entityManager.flush();
        // When
        Account found = accountRepository.findByAccountNumber(account.getAccountNumber());
        // Then
        assertThat(found.getAccountNumber()).isEqualTo(account.getAccountNumber());
    }

    @Test
    public void whenFindByBalanceGreaterThan_thenReturnAccounts(){
        // Given
        Account account1 = new Account("1", 100.0, "Account Holder 1");
        Account account2 = new Account("2", 200.0, "Account Holder 2");
        entityManager.persist(account1);
        entityManager.persist(account2);
        entityManager.flush();
        // When
        Collection<Account> accounts =  accountRepository.findByBalanceGreaterThan(120.0);
        assertThat(accounts.contains(account1)).isEqualTo(false);
        assertThat(accounts.contains(account2)).isEqualTo(true);
    }
}