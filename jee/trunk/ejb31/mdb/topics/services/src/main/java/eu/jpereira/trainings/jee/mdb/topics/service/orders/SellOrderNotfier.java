package eu.jpereira.trainings.jee.mdb.topics.service.orders;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import eu.jpereira.trainings.jee.mdb.topics.model.orders.SellOrder;

@Stateless
public class SellOrderNotfier {

	private @Resource(mappedName="java:/ConnectionFactory") ConnectionFactory jmsConnectionFactory;
	private @Resource(mappedName="java:/topics/orders") Destination topic;
	
	private Connection jmsConnection;
	private Session jmsSession;
	
	public void notifyNewSellOrder(SellOrder order) throws JMSException {
		System.out.println("Notifying new sell order...........................: "+order.getTotalPrice());
		MessageProducer producer = this.jmsSession.createProducer(this.topic);
		ObjectMessage message = this.jmsSession.createObjectMessage(order);
		message.setStringProperty("type", order.getType());
		producer.send(message);
		//Force commit, otherwise will only be commited when session is closed
		this.jmsSession.commit();
		
		
	}
	
	@SuppressWarnings("unused")
	@PostConstruct
	private void setupJMSResources() throws JMSException {
		this.jmsConnection = jmsConnectionFactory.createConnection();
		this.jmsSession = jmsConnection.createSession(true, Session.AUTO_ACKNOWLEDGE);
	}
	
	@SuppressWarnings("unused")
	@PreDestroy
	private void shutdownJMSResources() throws JMSException {
		if ( this.jmsSession != null ) {
			this.jmsSession.close();
		}
		if (this.jmsConnection != null ) {
			this.jmsConnection.close();
		}
	}
}
