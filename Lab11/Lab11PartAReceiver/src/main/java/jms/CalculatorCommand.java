package jms;

import lombok.Data;

@Data
public class CalculatorCommand {
    char operator;
    int value;

    static double getCalculatedValue(double result, CalculatorCommand cm){
        try{
            switch (cm.getOperator()){
                case '+':
                    return result + cm.getValue();
                case '-':
                    return result - cm.getValue();
                case '*':
                    return result * cm.getValue();
                case '/':
                    return result / cm.getValue();
                default:
                    return result;
            }
        } catch(Exception e){
            return result;
        }
    }
}