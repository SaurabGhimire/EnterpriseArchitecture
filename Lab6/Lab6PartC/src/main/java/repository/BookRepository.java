package repository;

import domain.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Modifying
    @Transactional
    @Query("update Book b set b.locationCode = Concat(:locationCode, b.locationCode)")
    void setLocationCodePrefix(String locationCode);

    @Modifying
    @Transactional
    @Query("delete Book b where b.publicationYear < :year")
    void deleteBookBefore(int year);
}
