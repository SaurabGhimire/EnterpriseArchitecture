package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class Application implements CommandLineRunner {

    @Autowired
    Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sender.send("createAccount", "1, Account 1");
        System.out.println("Create new account: Account 1");

        sender.send("depositMoney", "1, 1000");
        System.out.println("Deposit 1000 in account 1");

        sender.send("withdrawMoney", "1, 100");
        System.out.println("Withdraw 100 from account 1");
    }

}
