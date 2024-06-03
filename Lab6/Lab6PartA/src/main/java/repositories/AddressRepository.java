package repositories;

import domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query(value = "select * from address where city = :city", nativeQuery = true)
    Collection<Address> findByCity(String city);
}
