package customers;


//Modify the application so that we inject the CustomerDAO and the EmailSender in the
//CustomerService using setter injection

//Modify the application so that we inject the Logger in the CustomerDAO and the
//EmailSender using constructor injection
public class CustomerServiceImpl implements CustomerService {

	CustomerRepository customerRepository;

	EmailSender emailSender;

	public void addCustomer(String name, String email, String street,
			String city, String zip) {
		Customer customer = new Customer(name, email);
		Address address = new Address(street, city, zip);
		customer.setAddress(address);
		customerRepository.save(customer);
		emailSender.sendEmail(email, "Welcome " + name + " as a new customer");
	}

	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public void setEmailSender(EmailSender emailSender) {
		this.emailSender = emailSender;
	}
}
