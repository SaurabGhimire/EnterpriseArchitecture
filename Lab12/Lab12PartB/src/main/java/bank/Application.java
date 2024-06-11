package bank;

import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Application {

	@Autowired
	private AccountService accountService;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
