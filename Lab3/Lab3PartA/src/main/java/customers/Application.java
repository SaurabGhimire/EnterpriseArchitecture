package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.clearDB();
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		System.out.println(customerRepository.getCustomer(101));
		System.out.println(customerRepository.getCustomer(66));
		System.out.println("-----------All customers ----------------");
		System.out.println(customerRepository.getAllCustomers());

		productRepository.clearDB();

		// Create Product
		Product product = new Product(1, "Macbook", 1600.00);
		Supplier supplier = new Supplier("Apple Inc.", "9843217549");
		product.setSupplier(supplier);
		productRepository.save(product);

		product = new Product(2, "IPhone", 2000.00);
		supplier = new Supplier("Bisho and Companies", "1237463789");
		product.setSupplier(supplier);
		productRepository.save(product);


		System.out.println(productRepository.getProductByProductName("Macbook"));
		System.out.println(productRepository.getProductByProductNumber(2));
		System.out.println("-----------All products ----------------");
		System.out.println(productRepository.getAllProducts());

		productRepository.remove(1);
		System.out.println("Removing product with productNumber = 1");
		System.out.println("-----------All products ----------------");
		System.out.println(productRepository.getAllProducts());
	}
}
