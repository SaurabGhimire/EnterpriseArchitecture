package bank.kafka;

import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
    @Autowired
    AccountService accountService;

    @KafkaListener(topics = {"createAccount"})
    public void createAccountMessage(@Payload String message) {
        String[] messageList =  message.split(",");
        accountService.createAccount(Long.parseLong(messageList[0]), messageList[1]);
    }

    @KafkaListener(topics = {"depositMoney"})
    public void depositMoneyMessage(@Payload String message) {
        String[] messageList =  message.split(",");
        accountService.deposit(Long.parseLong(messageList[0]),Double.parseDouble(messageList[1]));
    }

    @KafkaListener(topics = {"withdrawMoney"})
    public void withdrawMoneyMessage(@Payload String message) {
        String[] messageList =  message.split(",");
        accountService.withdraw(Long.parseLong(messageList[0]), Double.parseDouble(messageList[1]));
    }
}