package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CalculatorCommandListener {
    double result = 0.0;

    @JmsListener(destination = "calculatorQueue")
    public void receiveMessage(final String commandAsString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            CalculatorCommand calculatorCommand = objectMapper.readValue(commandAsString, CalculatorCommand.class);
            result = CalculatorCommand.getCalculatedValue(result,calculatorCommand);
            System.out.println("JMS receiver received message:" + calculatorCommand.getOperator()+" "+calculatorCommand.getValue());
            System.out.println("After calculation: "+ result);

        } catch (IOException e) {
            System.out.println("JMS receiver: Cannot convert : " + commandAsString+" to a Person object");
        }
    }

}

