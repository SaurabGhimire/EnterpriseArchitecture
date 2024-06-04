package bank.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class TraceRecord {
    @Id
    @GeneratedValue
    long id;
    LocalDateTime dateTime;
    String result;

    public TraceRecord(LocalDateTime dateTime, String result) {
        this.dateTime = dateTime;
        this.result = result;
    }
}
