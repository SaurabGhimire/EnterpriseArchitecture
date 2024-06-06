package bank.dtos;

import bank.domain.AccountEntry;
import bank.domain.Customer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.Collection;

public class AccountDTO {
    long accountNumber;

    Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();

    CustomerDTO customer;

    public AccountDTO(long accountNumber, CustomerDTO customer, Collection<AccountEntry> entryList){
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.entryList = entryList;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public Collection<AccountEntry> getEntryList() {
        return entryList;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public double getBalance() {
        double balance=0;
        for (AccountEntry entry : entryList) {
            balance+=entry.getAmount();
        }
        return balance;
    }
}
