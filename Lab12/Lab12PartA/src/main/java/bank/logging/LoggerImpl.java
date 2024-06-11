package bank.logging;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerImpl implements Logger{

	public void log(String logstring) {
		LoggerFactory.getLogger("BankLogger").info(logstring);
//		java.util.logging.Logger.getLogger("BankLogger").info(logstring);
	}

}
