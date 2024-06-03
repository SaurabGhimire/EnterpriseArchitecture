package repositories;

import domain.Customer;
import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o.orderNumber from Order o where o.status = :status")
    Collection<String> findOrderNumberByStatusJPQLQuery(String status);

    @Query("select o.orderNumber from Order o where o.customer.address.city = :city")
    Collection<String> getOrderNumberByCityJPQLQuery(String city);
}
