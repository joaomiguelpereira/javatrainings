package eu.jpereira.trainings.jee.mdb.topics.service.orders;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

import eu.jpereira.trainings.jee.mdb.topics.model.orders.SellOrder;

@Stateless
public class SellOrderNotfier {

	//TODO: Inject the JMS Connection Factory using the JNDI name provided by JBoss 7
	//private @Resource(mappedName="java:/ConnectionFactory") ConnectionFactory jmsConnectionFactory;
	
	
	//TODO: You need to create the topic in jboss. Follow the steps:
	//  1 - Go  to {JBOSS_HOME_FOLDE}/bin and run jboss-admin.bat (sh)
	//  2 - Type: connect
	//  3 - Type: add-jms-topic --name=ordersTopic --entries=/topics/orders
	//TODO: Inject the destination object connected to the created topic
	//private @Resource(mappedName="java:/topics/orders") Destination topic;
	
	
	private Connection jmsConnection;
	private Session jmsSession;
	
	public void notifyNewSellOrder(SellOrder order) throws JMSException {
		//TODO: Create a message producer for the destination (topics/orders)
		//MessageProducer producer = this.jmsSession.createProducer(this.topic);
		
		//TODO: Create an object message and wrap the order argument
		//ObjectMessage message = this.jmsSession.createObjectMessage(order);
		
		//TODO: Use the message to set a property called type with value calculated by the domain object
		//message.setStringProperty("type", order.getType());
		
		//TODO: Use the producer to send the message
		//producer.send(message);
		
		//Force commit, otherwise will only be commited when session is closed
		this.jmsSession.commit();
		
		
	}
	
	/**
	 * This method will be called by container before after the EJB is ready to use. 
	 * We use this method to create any JMS resources
	 * @throws JMSException
	 */
	@SuppressWarnings("unused")
	@PostConstruct
	private void setupJMSResources() throws JMSException {
		//TODO: Use the JMS COnnectionFactory to get a JMS Connection
		//this.jmsConnection = jmsConnectionFactory.createConnection();
		
		//TODO: Use the createde JMS Connection to create a session
		//this.jmsSession = jmsConnection.createSession(true, Session.AUTO_ACKNOWLEDGE);
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
