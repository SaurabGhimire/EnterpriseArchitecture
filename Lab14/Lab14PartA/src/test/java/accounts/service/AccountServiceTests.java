package accounts.service;

import accounts.domain.Account;
import accounts.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
public class AccountServiceTests {
    @TestConfiguration
    static class AccountServiceImplTestContextConfiguration {
        @Bean
        public  AccountService customerService(){
            return  new AccountService();
        }
    }

    @Autowired
    private  AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @Captor
    private ArgumentCaptor<Account> accountCaptor;

    @BeforeEach
    public void setUp(){
        String accountNumber = "123";
        Account account = new Account("123", 100.0, "Account Holder 1");
        Optional<Account> accountOptional = Optional.of(account);
        Mockito.when(accountRepository.findById(accountNumber)).thenReturn(accountOptional);
    }

    @Test
    public void whenValidAccountNumberThenAccountShouldBeFound(){
        // Given
        String accountNumber = "123";
        // When
        AccountResponse found = accountService.getAccount(accountNumber);
        // Then
        assertThat(found.getAccountNumber()).isEqualTo(accountNumber);
    }

    @Test
    public void testCreateAccount() {
        // Given
        String accountNumber = "123";
        double amount = 100.0;
        String accountHolder = "Account Holder 1";

        // When
        accountService.createAccount(accountNumber, amount, accountHolder);

        // Then
        verify(accountRepository).save(accountCaptor.capture());
        Account found = accountCaptor.getValue();
        assert found != null;
        assert found.getAccountNumber().equals(accountNumber);
        assert found.getBalance() == amount;
        assert found.getAccountHolder().equals(accountHolder);
    }
}
