package bank.service;

import bank.repository.AccountRepository;
import bank.domain.Account;
import bank.domain.Customer;
import bank.jms.JMSSender;
import bank.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.Collection;
import java.util.List;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CurrencyConverter currencyConverter;
	@Autowired
	private JMSSender jmsSender;
	@Autowired
	private Logger logger;



	public AccountDTO createAccount(long accountNumber, String customerName) {
		Account account = new Account(accountNumber);
		Customer customer = new Customer(customerName);
		account.setCustomer(customer);
		accountRepository.save(account);
		logger.log("createAccount with parameters accountNumber= "
				+ accountNumber + " , customerName= " + customerName);
		jmsSender.sendJMSMessage("createAccount with parameters accountNumber= "
				+ accountNumber + " , customerName= " + customerName);
		return AccountAdapter.getAccountDTOFromAccount(account);
	}


	public void deposit(long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber).get();
		account.deposit(amount);
		accountRepository.save(account);
		logger.log("deposit with parameters accountNumber= " + accountNumber
				+ " , amount= " + amount);
		if (amount > 1000) {
			jmsSender.sendJMSMessage("Deposit of $ " + amount
					+ " to account with accountNumber= " + accountNumber);
		}
	}

	public AccountDTO getAccount(long accountNumber) {
		Account account = accountRepository.findById(accountNumber).get();
		return AccountAdapter.getAccountDTOFromAccount(account);
	}

	public Collection<AccountDTO> getAllAccounts() {
		List<Account> accountList = accountRepository.findAll();
		return AccountAdapter.getAccountDTOListFromAccountList(accountList);
	}


	public void withdraw(long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber).get();
		account.withdraw(amount);
		accountRepository.save(account);
		logger.log("withdraw with parameters accountNumber= " + accountNumber
				+ " , amount= " + amount);
	}

	public void depositEuros(long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber).get();
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.deposit(amountDollars);
		accountRepository.save(account);
		logger.log("depositEuros with parameters accountNumber= "
				+ accountNumber + " , amount= " + amount);
		if (amountDollars > 10000) {
			jmsSender.sendJMSMessage("Deposit of $ " + amount
					+ " to account with accountNumber= " + accountNumber);
		}
	}

	public void withdrawEuros(long accountNumber, double amount) {
		Account account = accountRepository.findById(accountNumber).get();
		double amountDollars = currencyConverter.euroToDollars(amount);
		account.withdraw(amountDollars);
		accountRepository.save(account);
		logger.log("withdrawEuros with parameters accountNumber= "
				+ accountNumber + " , amount= " + amount);
	}


	public void transferFunds(long fromAccountNumber, long toAccountNumber,
							  double amount, String description) {
		Account fromAccount = accountRepository.findById(fromAccountNumber).get();
		Account toAccount = accountRepository.findById(toAccountNumber).get();
		fromAccount.transferFunds(toAccount, amount, description);
		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);
		logger.log("transferFunds with parameters fromAccountNumber= "
				+ fromAccountNumber + " , toAccountNumber= " + toAccountNumber
				+ " , amount= " + amount + " , description= " + description);
		if (amount > 10000) {
			jmsSender.sendJMSMessage("TransferFunds of $ " + amount
					+ " from account with accountNumber= " + fromAccount
					+ " to account with accountNumber= " + toAccount);
		}
	}
}
