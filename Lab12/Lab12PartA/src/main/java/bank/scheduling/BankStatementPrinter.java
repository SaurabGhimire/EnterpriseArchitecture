package bank.scheduling;

import bank.service.AccountDTO;
import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class BankStatementPrinter {
    @Autowired
    AccountService accountService;
    @Scheduled(fixedRate = 20000)
    public void printAccountDetails(){
        Collection<AccountDTO> accounts = accountService.getAllAccounts();
        System.out.println("Total Accounts:" + (long) accounts.size());
        for(AccountDTO accountDTO: accounts){
            System.out.println(accountDTO);
        }
    }
}
