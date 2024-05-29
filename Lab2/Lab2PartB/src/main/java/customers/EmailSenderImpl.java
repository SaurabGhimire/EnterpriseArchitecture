package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderImpl implements EmailSender {
	@Value("${outgoing.mail.server}")
	String outgoingMailServer;

	private Logger logger;

	@Autowired
	EmailSenderImpl(Logger logger){
		this.logger = logger;
	}

	public String getOutgoingMailServer() {
		return outgoingMailServer;
	}

	public void sendEmail (String email, String message){
		System.out.println("EmailSender: sending '"+message+"' to "+email );
		logger.log("Email is sent: message= "+message +" , emailaddress ="+ email  );
	}

	public void setOutgoingMailServer(String outgoingMailServer){
		this.outgoingMailServer = outgoingMailServer;
	}


}
