import books.controller.Books;
import books.domain.Book;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
public class BooksRESTTest {
    @BeforeClass
    public static void setup() {
        RestAssured.port = 8080;
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testGetOneBook() {
        // add the book to be fetched
        Book book = new Book("123","Book 123", 18.95, "Author 1");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        // test getting the book
        given()
                .when()
                .get("books/123")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn",equalTo("123"))
                .body("title",equalTo("Book 123"))
                .body("price",equalTo(18.95f))
                .body("author",equalTo("Joe Smith"));
        //cleanup
        given()
                .when()
                .delete("books/123");
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book("123", "Book 123", 10.0, "Author 1");
        String isbnToDelete = "123";

        given()
                .contentType(ContentType.JSON)
                .body(book)
                .when()
                .post("/books")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("isbn", equalTo("123"))
                .body("title", equalTo("Book 123"))
                .body("price", equalTo(10.0f))
                .body("author", equalTo("Author 1"));
        given()
                .pathParam("isbn", isbnToDelete)
                .when()
                .delete("/books/{isbn}")
                .then()
                .statusCode(204);
        given()
                .pathParam("isbn", isbnToDelete)
                .when()
                .get("/books/{isbn}")
                .then()
                .statusCode(404);
    }

    @Test
    public void testAddBook() {
        Book book = new Book("123", "Book 123", 10.0, "Author 1");

        // Add the book using the POST /books endpoint
        given()
                .contentType(ContentType.JSON)
                .body(book)
                .when()
                .post("/books")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("isbn", equalTo("123"))
                .body("title", equalTo("Book 123"))
                .body("price", equalTo(10.0f))
                .body("author", equalTo("Author 1"));
    }

    @Test
    public void testUpdateBook() {
        Book updatedBook = new Book("123", "Updated Book Title", 15.0, "Updated Author");
        String isbnToUpdate = "123";
        given()
                .pathParam("isbn", isbnToUpdate)
                .contentType("application/json")
                .body(updatedBook)
                .when()
                .put("/books/{isbn}")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("isbn", equalTo("123"))
                .body("title", equalTo("Updated Book Title"))
                .body("price", equalTo(15.0f))
                .body("author", equalTo("Updated Author"));
        given()
                .pathParam("isbn", isbnToUpdate)
                .when()
                .get("/books/{isbn}")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("isbn", equalTo("123"))
                .body("title", equalTo("Updated Book Title"))
                .body("price", equalTo(15.0f))
                .body("author", equalTo("Updated Author"));
    }

    @Test
    public void testGetBooks() {
        // Add books to be fetched
        Book book1 = new Book("123", "Book 123", 10.0, "Author 1");
        Book book2 = new Book("234", "Book 234", 11.0, "Author 2");
        Book book3 = new Book("Isbn 3", "New Title", 9.0, "New Author");

        given()
                .contentType("application/json")
                .body(book1)
                .when().post("/books").then()
                .statusCode(200);
        given()
                .contentType("application/json")
                .body(book2)
                .when().post("/books").then()
                .statusCode(200);
        given()
                .contentType("application/json")
                .body(book3)
                .when().post("/books").then()
                .statusCode(200);
        given()
                .when()
                .get("/books")
                .then()
                .contentType(ContentType.JSON)
                .body("books.find { it.isbn == '123' }.title", equalTo("Book 123"))
                .body("books.find { it.isbn == '123' }.price", equalTo(10.0f))
                .body("books.find { it.isbn == '123' }.author", equalTo("Author 1"))
                .body("books.find { it.isbn == '234' }.title", equalTo("Book 234"))
                .body("books.find { it.isbn == '234' }.price", equalTo(11.0f))
                .body("books.find { it.isbn == '234' }.author", equalTo("Author 2"));

        // Cleanup
        given()
                .when()
                .delete("/books/123").then().statusCode(204);
        given()
                .when()
                .delete("/books/234").then().statusCode(204);

    }
}




