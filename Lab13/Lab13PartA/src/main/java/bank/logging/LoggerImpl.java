package bank.logging;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerImpl implements Logger{
	@Autowired
	org.slf4j.Logger logger;

	public void log(String logstring) {
		logger.info(logstring);
		java.util.logging.Logger.getLogger("BankLogger").info(logstring);
	}

}
