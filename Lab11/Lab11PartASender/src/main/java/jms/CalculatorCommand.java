package jms;

import lombok.Data;

import java.util.Random;

@Data
public class CalculatorCommand {
    char operator;
    int value;

    CalculatorCommand(){
        operator = getRandomOperator();
        Random random = new Random();
        value = random.nextInt(100);
    }

    static char getRandomOperator(){
        char[] operators = {'+', '-', '*', '/'};
        Random random = new Random();
        int randomIndex = random.nextInt(operators.length);
        return operators[randomIndex];
    }
}
