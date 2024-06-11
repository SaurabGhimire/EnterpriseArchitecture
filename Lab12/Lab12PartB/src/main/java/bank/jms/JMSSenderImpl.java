package bank.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class JMSSenderImpl implements JMSSender{
//	JmsTemplate jmsTemplate = new JmsTemplate();
	
	public void sendJMSMessage (String text){
		System.out.println("JMSSender: sending JMS message ="+text);
//		jmsTemplate.convertAndSend("taxService", text);
	}
}
