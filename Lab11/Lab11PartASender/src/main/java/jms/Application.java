package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;


@EnableJms
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	JmsTemplate jmsTemplate;

	public static void main(String[] args)  {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		context.close();
	}

	@Override
	public void run(String... args) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		CalculatorCommand calculatorCommand = new CalculatorCommand();
		String calculatorCommandAsString = objectMapper.writeValueAsString(calculatorCommand);

		System.out.println("Sending a JMS message:" + calculatorCommandAsString);
		jmsTemplate.convertAndSend("calculatorQueue",calculatorCommandAsString);
	}
}
