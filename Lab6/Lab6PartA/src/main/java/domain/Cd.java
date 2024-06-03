package domain;

import jakarta.persistence.Entity;

@Entity
public class Cd extends Product{
    String artist;

    public Cd(String artist){
        this.artist = artist;
    }

    public Cd(){}
}
