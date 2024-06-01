package domain;

import jakarta.persistence.Entity;

@Entity
public class Dvd extends  Product{
    String genre;

    public Dvd(String genre){
        this.genre = genre;
    }

    public Dvd(){}

}

