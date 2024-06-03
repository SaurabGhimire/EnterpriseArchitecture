package repositories;

import domain.Cd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;


public interface CdRepository extends JpaRepository<Cd, Long> {
    Collection<Cd> findByArtistAndPriceLessThan(String artist, double price);

    Collection<Cd> findByArtistNamedQuery(String artist);

    @Query("select c from Cd c where c.artist = :artist and c.price > :amount")
    Collection<Cd> findByArtistAndPriceGreaterThanJPQLQuery(String artist, double amount);


    @Query(value = "select * from cd c join product p on c.id=p.id where c.artist = :artist" , nativeQuery = true)
    Collection<Cd> findByArtistNativeQuery(String artist);
}
