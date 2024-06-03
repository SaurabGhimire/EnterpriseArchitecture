package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(
        name = "Cd.findByArtistNamedQuery",
        query = "select c from Cd c where c.artist = :artist"
)
public class Cd extends Product{
    String artist;

    public Cd(String artist){
        this.artist = artist;
    }

    public Cd(){}

    public String getArtist() {
        return artist;
    }
}
