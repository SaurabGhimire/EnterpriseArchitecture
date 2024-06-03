package repositories;

import domain.Cd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;


public interface CdRepository extends JpaRepository<Cd, Long> {
    Collection<Cd> findByArtistAndPriceLessThan(String artist, double price);

    Collection<Cd> findByArtistNamedQuery(String artist);
}
