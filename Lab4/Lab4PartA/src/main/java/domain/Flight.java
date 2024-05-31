package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    long id;

    String flightNumber;
    String fromAddress;
    String toAddress;
    LocalDate date;

    public  Flight(){}

    public Flight( String flightNumber, String fromAddress, String toAddress, LocalDate date) {
        this.flightNumber = flightNumber;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getfromAddress() {
        return fromAddress;
    }

    public void setfromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String gettoAddress() {
        return toAddress;
    }

    public void settoAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", fromAddress='" + fromAddress + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", date=" + date +
                '}';
    }
}
