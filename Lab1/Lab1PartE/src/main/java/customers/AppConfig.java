package customers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CustomerService customerService(){
        CustomerService customerService = new CustomerServiceImpl();
        customerService.setCustomerRepository(customerRepository());
        customerService.setEmailSender(emailSender());
        return customerService;
    }

    @Bean
    public CustomerRepository customerRepository(){
        return new CustomerRepositoryImpl(logger());
    }

    @Bean
    public EmailSender emailSender(){
        return new EmailSenderImpl(logger());
    }

    @Bean
    public Logger logger(){
        return new LoggerImpl();
    }


    @Bean
    public ProductService productService(){
        ProductService customerService = new ProductServiceImpl();
        customerService.setProductRepository(productRepository());
        customerService.setEmailSender(emailSender());
        return customerService;
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepositoryImpl(logger());
    }

}
