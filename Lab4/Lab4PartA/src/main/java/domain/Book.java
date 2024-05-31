package domain;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue
    long id;

    String isbn;
    String title;
    String author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name="book_publisher",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "publisher_id")}
    )
    Publisher publisher;

    public Book(){}

    public Book(String isbn, String title, String author){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public Book(String isbn, String title, String author, Publisher publisher){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher=" + publisher +
                '}';
    }
}
