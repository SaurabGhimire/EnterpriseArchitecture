package bank.advice;

import bank.event.AccountChangeEvent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AccountEventAdvice {
    @Autowired
    private ApplicationEventPublisher publisher;
    @After("execution(* bank.service.AccountServiceImpl.*(long, *)) && args(accountNumber, amount)")
    public void logChangeToAccount(JoinPoint joinPoint, long accountNumber, Object amount){
        double amountValue = (amount instanceof Double) ? (Double) amount : 0.0;
        publisher.publishEvent(new AccountChangeEvent(
                accountNumber,
                joinPoint.getSignature().getName(),
                amountValue
        ));
    }
}
