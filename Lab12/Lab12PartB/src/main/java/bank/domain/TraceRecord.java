package bank.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class TraceRecord {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime dateTime;
    private long accountNumber;
    private String operation;
    private double amount;

    public TraceRecord(LocalDateTime dateTime, long accountNumber, String operation, double amount) {
        this.dateTime = dateTime;
        this.accountNumber = accountNumber;
        this.operation = operation;
        this.amount = amount;
    }
}
