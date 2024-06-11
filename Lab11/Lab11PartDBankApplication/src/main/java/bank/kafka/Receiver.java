package bank.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    @KafkaListener(topics = {"createAccount"})
    public void receive(@Payload String message) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>Receiver received message= "+ message);
    }

}