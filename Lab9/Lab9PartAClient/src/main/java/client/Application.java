package client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private RestTemplate restTemplate = new RestTemplate();

	private String serverUrl = "http://localhost:8080/books";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Get a book by ISBN (assuming ISBN is used to fetch book)
		Book book = restTemplate.getForObject(serverUrl + "/{isbn}", Book.class, "Isbn 1");
		System.out.println(book);

		// Add a new book
		restTemplate.postForLocation(serverUrl, new Book("Isbn 3", "John Doe", "Spring in Action", 29.99));

		// Get the newly added book
		book = restTemplate.getForObject(serverUrl + "/{isbn}", Book.class, "Isbn 3");
		System.out.println(book);

		// Delete a book by ISBN
		restTemplate.delete(serverUrl + "/{isbn}", "Isbn 3");

		// Update a book's price
		book.setPrice(35.99);
		restTemplate.put(serverUrl + "/{isbn}", book, "Isbn 2");

		// Get the updated book
		book = restTemplate.getForObject(serverUrl + "/{isbn}", Book.class, "Isbn 2");
		System.out.println(book);

		// Get all books
		Books books = restTemplate.getForObject(serverUrl, Books.class);
		System.out.println(books);

	}

}
