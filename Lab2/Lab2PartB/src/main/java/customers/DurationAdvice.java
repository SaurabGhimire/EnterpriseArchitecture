package customers;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
    import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class DurationAdvice {
    @Autowired
    Logger logger;
    @Around("execution(* customers.*RepositoryImpl.*(..))")
    public Object invoke(ProceedingJoinPoint call ) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();

        long totaltime = sw.getLastTaskTimeMillis();
        // print the time to the console
        logger.logInRedColor("Duration of " + call.getThis()+"->" + call.getSignature().getName()+" is: " +totaltime);

        return retVal;
    }
}
