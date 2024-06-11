package partC.lab12.Lab12PartC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class Lab12PartCApplication implements CommandLineRunner {
	@Autowired
	AppConfigService appConfigService;

	public static void main(String[] args) {
		SpringApplication.run(Lab12PartCApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		appConfigService.print();
	}
}
