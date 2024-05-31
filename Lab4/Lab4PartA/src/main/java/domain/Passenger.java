package domain;

import jakarta.persistence.*;

import java.util.Collection;
@Entity
public class Passenger {
    @Id
    @GeneratedValue
    long id;
    String name;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable()
//    @OrderBy("id ASC")
    @OrderColumn(name="sequence")
    Collection<Flight> flights;

    public Passenger(String name, Collection<Flight> flights) {
        this.name = name;
        this.flights = flights;
    }

    public Passenger() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Collection<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flights=" + flights +
                '}';
    }
}
