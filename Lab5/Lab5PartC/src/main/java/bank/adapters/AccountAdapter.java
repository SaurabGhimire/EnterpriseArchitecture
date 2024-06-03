package bank.adapters;

import bank.domain.Account;
import bank.dtos.AccountDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountAdapter {
    public static Account getAccountFromAccountDTO(AccountDTO accountDTO){
        Account account = new  Account(
                accountDTO.getAccountNumber()
        );
        account.setCustomer(accountDTO.getCustomer());
        account.setEntryList(accountDTO.getEntryList());
        return  account;
    }

    public static AccountDTO getAccountDTOFromAccount(Account account){
        return new AccountDTO(
                account.getAccountNumber(),
                account.getCustomer(),
                account.getEntryList()
        );
    }

    public static Collection<AccountDTO> getAccountDTOsFromAccounts(Collection<Account> accounts){
        Collection<AccountDTO> accountDTOs = new ArrayList<AccountDTO>();
        for (Account account: accounts){
            accountDTOs.add(getAccountDTOFromAccount(account));
        }
        return accountDTOs;
    }
}
