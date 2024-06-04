package bank.service;

import bank.domain.Account;
import bank.domain.Customer;
import bank.domain.TraceRecord;
import bank.integration.EmailSender;
import bank.repository.AccountRepository;
import bank.repository.CustomerRepository;
import bank.repository.TraceRecordRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BankService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private TraceRecordRepository traceRecordRepository;
	@Autowired
	private EmailSender emailSender;
	
	@Transactional
	public void createCustomerAndAccount(int customerId, String customerName, String emailAddress, String AccountNumber){
		try{
			Account account = new Account(AccountNumber);
			accountRepository.save(account);
			Customer customer = new Customer(customerId, customerName);
			customer.setAccount(account);
			customerRepository.saveCustomer(customer);
			emailSender.sendEmail(emailAddress, "Welcome "+customerName);
			traceRecordRepository.save(new TraceRecord(LocalDateTime.now(), "Customer "+ customerName + " created with account " + AccountNumber));
		} catch(Exception e){
			emailSender.sendEmail(emailAddress, "We could not create your account " + AccountNumber);
			traceRecordRepository.save(new TraceRecord(LocalDateTime.now(), "Could not create customer " + customerName +   " with account " + AccountNumber));

		}
	}
}
