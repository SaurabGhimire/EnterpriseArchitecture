package bank.event;

import bank.domain.TraceRecord;

import java.time.LocalDateTime;

public class AccountChangeEvent {
    private LocalDateTime dateTime;
    private long accountNumber;
    private String operation;
    private double amount;

    public AccountChangeEvent( long accountNumber, String operation, double amount) {
        this.dateTime = LocalDateTime.now();
        this.accountNumber = accountNumber;
        this.operation = operation;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AccountChangeEvent{" +
                "dateTime=" + dateTime +
                ", accountNumber=" + accountNumber +
                ", operation='" + operation + '\'' +
                ", amount=" + amount +
                '}';
    }

    public TraceRecord toTraceRecord(){
        return new TraceRecord(
                dateTime,
                accountNumber,
                operation,
                amount
        );
    }
}
