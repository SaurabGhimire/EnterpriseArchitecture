package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import repositories.CustomerRepository;
import repositories.AddressRepository;
import repositories.CdRepository;
import repositories.CustomerRepository;
import repositories.OrderRepository;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class Application implements CommandLineRunner{
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CdRepository cdRepository;

	@Autowired
	AddressRepository addressRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Product product = new Cd("Pink Floyd");
		product.setName("Wish you were here");
		product.setDescription("This is an album by pink floyd");
		product.setPrice(35.50);
		OrderLine ol1 = new OrderLine(2, product);

		Product product2 = new Dvd("Bryan Adams");
		product2.setName("Wonderful Tonight");
		product2.setDescription("This is an album by bryan");
		product2.setPrice(120.00);
		OrderLine ol2 = new OrderLine(2, product2);

		Order o1 = new Order("234743", "12/10/06", "open");
		o1.addOrderLine(ol1);
		o1.addOrderLine(ol2);

		Customer c1 = new Customer("Frank", "Brown", "Mainstreet 1",
				"New york", "43221");
		c1.addOrder(o1);
		o1.setCustomer(c1);


		orderRepository.save(o1);

		for(Order order: orderRepository.findAll()){
			printOrder(order);
		}

		// Give all all customers
		for(Customer customer: customerRepository.findAll()){
			System.out.println(customer.getFirstName());
		}

		// Give all CD's from artist with a price smaller than
		for(Cd cd: cdRepository.findByArtistAndPriceLessThan("Pink Floyd", 1000.0)){
			System.out.println(cd.getName());
		}

		// Give all customers from the USA : Named Query
		for(Customer customer: customerRepository.findAllByCityNamedQuery("New York")){
			System.out.println(customer.getFirstName());
		}

		// Give all CD's from a certain artist : Named Query
		for(Cd cd: cdRepository.findByArtistNamedQuery("Pink Floyd")){
			System.out.println(cd.getName());
		}

		// Give all orderNumbers of all orders with status "closed
		for(String order: orderRepository.findOrderNumberByStatusJPQLQuery("closed")){
			System.out.println(order);
		}

		// Give the first and lastnames of all customers who live in Amsterdam
		for(String name: customerRepository.findFirstAndLastNameByCityJPQLQuery("New York")){
			System.out.println(name);
		}

		// Give the ordernumbers of all orders from customers who live in a certain city (city is a
		// parameter).
		for(String orderNumber: orderRepository.getOrderNumberByCityJPQLQuery("New York")){
			System.out.println(orderNumber);
		}

		// Give all CD’s from a certain artist with a price bigger than a certain amount (artist and
		// amount are parameter2).
		for(Cd cd: cdRepository.findByArtistAndPriceGreaterThanJPQLQuery("Pink Floyd", 1.0)){
			System.out.println(cd.getName());
		}

		// Give all addresses in Amsterdam.
		for(Address address: addressRepository.findByCity("New York")){
			System.out.println(address);
		}

		// Give all CD’s from U2
		for(Cd cd: cdRepository.findByArtistNativeQuery("Pink Floyd")){
			System.out.println(cd);
		}
	}

	public static void printOrder(Order order) {
		System.out.println("Order with orderNumber: " + order.getOrderNumber());
		System.out.println("Order date: " + order.getDate());
		System.out.println("Order status: " + order.getStatus());
		Customer cust = order.getCustomer();
		System.out.println("Customer: " + cust.getFirstName() + " "
				+ cust.getLastName());
		for (OrderLine orderline : order.getOrderLines()) {
			System.out.println("Order line: quantity= "
					+ orderline.getQuantity());
			Product product = orderline.getProduct();
			System.out.println("Product: " + product.getName() + " "
					+ product.getDescription() + " " + product.getPrice());
		}
	}
}
