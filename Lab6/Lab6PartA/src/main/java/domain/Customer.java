package domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
@NamedQuery(
		name = "Customer.findAllByCity",
		query = "select c from Customer c where c.address.city = :city"
)
public class Customer {
	@Id
	@GeneratedValue
	private long id;

	private String firstName;

	private String lastName;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Address address;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Order> theOrders = new ArrayList<>();

	public Customer() {
	}

	public Customer(String firstName, String lastName, String street,
					String city, String zip) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = new Address(street, city, zip);
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Collection<Order> getTheOrders() {
		return Collections.unmodifiableCollection(theOrders);
	}

	public boolean addOrder(Order order) {
		boolean added = theOrders.add(order); 
		if (added) {
			order.setCustomer(this);
		}
		return added;
	}

	public boolean removeOrder(Order order) {
		boolean removed = theOrders.remove(order);
		if (removed) {
			theOrders.remove(order);
		}
		return removed;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", address=" + address +
				", theOrders=" + theOrders +
				'}';
	}
}
