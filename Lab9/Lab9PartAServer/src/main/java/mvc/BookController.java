package mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class BookController {
    private Map<String, Book> books = new HashMap<String , Book>();

    public BookController() {
        books.put("Isbn 1", new Book("Isbn 1", "Author 1", "Java Fundamentals", 100.0));
        books.put("Isbn 2", new Book("Isbn 2", "Author 2", "Python Fundamentals", 150.0));
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn= "
                    + isbn + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        Collection<Book> allBooks = books.values();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        books.put(book.isbn, book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<?> updateBook(@PathVariable String isbn, @RequestBody Book book) {
        books.put(isbn, book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn){
        Book book = books.get(isbn);
        if(book == null){
            return  new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("The book with isbn=" +isbn + " could not be found."),
                    HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("books/author/{author}")
    public ResponseEntity<?> searchBooks(@PathVariable String author){
        Collection<Book> allBooks= books.values();
        Collection<Book> booksByAuthor = allBooks.stream().filter(book -> book.getAuthor().equals(author))
                    .collect(Collectors.toList());
        return new ResponseEntity<>(booksByAuthor, HttpStatus.OK);
    }
}
