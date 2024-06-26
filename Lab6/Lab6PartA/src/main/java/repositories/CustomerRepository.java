package repositories;

import domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Collection<Customer> findAllByCityNamedQuery(String city);

    @Query("select concat(c.firstName, ' ', c.lastName) from Customer c where c.address.city = :city")
    Collection<String> findFirstAndLastNameByCityJPQLQuery(String city);
   }
