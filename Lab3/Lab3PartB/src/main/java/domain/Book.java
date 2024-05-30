package domain;

//Save some books, and retrieve all books from the database.
//- Create 3 books, and save them in the database
//- Retrieve all books from the database and display them in the console
//- Update a book
//- Delete a book (not the book that was just updated)
//- Retrieve all books from the database again and display them in the console

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String ISBN;
    private String author;
    private double price;

    // Default constructor required by JPA
    public Book() {
    }

    public Book(String title, String ISBN, String author, double price){
        super();
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("Book[id=%d, title='%s', ISBN='%s', author='%s', price='%s']", id, title, ISBN, author, price);
    }
}


