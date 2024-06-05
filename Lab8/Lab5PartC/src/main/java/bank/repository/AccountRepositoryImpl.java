package bank.repository;
import bank.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class AccountRepositoryImpl implements AccountRepository{
    @Autowired
    AccountRepositoryJPA accountRepositoryJPA;
    @Override
    public void saveAccount(Account account) {
        accountRepositoryJPA.save(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountRepositoryJPA.save(account);
    }

    @Override
    public Account loadAccount(long accountNumber) {
        return accountRepositoryJPA.findByAccountNumber(accountNumber);
    }

    @Override
    public Collection<Account> getAccounts() {
        return accountRepositoryJPA.findAll();
    }
}
