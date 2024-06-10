package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Collection;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	BankGateway bankGateway;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create 2 accounts
		bankGateway.createAccount(1234567, "Alice Smith");
		bankGateway.createAccount(7654321, "Bob Johnson");

		// Use account 1
		bankGateway.deposit(1234567, 500);
		bankGateway.deposit(1234567, 150);
		bankGateway.withdrawEuros(1234567, 100);

		// Use account 2
		bankGateway.deposit(7654321, 10000);
		bankGateway.depositEuros(7654321, 300);
		bankGateway.transferFunds(7654321, 1234567, 200, "payment of invoice 98765");

		// Show balances
		Collection<AccountDTO> accountlist = bankGateway.getAllAccounts();
		CustomerDTO customer = null;
		for (AccountDTO account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println(
					"-Date-------------------------" + "-Description------------------" + "-Amount-------------");
			for (AccountEntryDTO entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate().toString(), entry.getDescription(),
						entry.getAmount());
			}
			System.out.println("----------------------------------------" + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
		}

	}
}
