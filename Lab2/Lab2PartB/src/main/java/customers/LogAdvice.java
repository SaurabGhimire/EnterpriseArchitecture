package customers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
@Configuration
public class LogAdvice {
    @Autowired
    Logger logger;
    @After("execution(* customers.EmailSender.sendEmail(..))  && args(email,message)")
    public void logEmailSent(JoinPoint joinpoint, String email, String message) {
        LocalDateTime localDate =  LocalDateTime.now();
        logger.logInRedColor(localDate +
                        " method=" + joinpoint.getSignature().getName() +
                        " email=" + email +
                        " message=" + message +
                        " outgoing mail server=" + ((EmailSender)joinpoint.getThis()).getOutgoingMailServer()
                );
    }
}
