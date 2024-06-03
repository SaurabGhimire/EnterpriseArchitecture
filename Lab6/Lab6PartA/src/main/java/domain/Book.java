package domain;

import jakarta.persistence.Entity;

@Entity
public class Book extends  Product{
    String isbn;

    Book(String isbn, String name, String description, double price){
        super(name, description, price);
        this.isbn = isbn;
    }

    public Book(){}

}

