package bank.integration.logging;

import bank.integration.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogRepositoryAdvice {
    @Autowired
    Logger logger;
    @After("execution(* bank.repository.AccountRepositoryImpl.*(..))")
    public void logRepositoryCall(JoinPoint joinPoint){
        logger.log(joinPoint.getSignature().getName());
    }

    @After("execution(* bank.integration.jms.JMSSenderImpl.*(..)) && args(text)")
    public void logJMSMessage(JoinPoint joinPoint, String text){
        logger.log(text);
    }
}
