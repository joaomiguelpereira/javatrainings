package eu.jpereira.trainings.jee.mdb.queues.producer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

import eu.jpereira.trainings.jee.mdb.queues.model.jobs.Job;

@Stateless
public class JobsSubmitter {

	// TODO: Get a JMS Connection Factory from JNDI name
	// private @Resource(mappedName = "java:/ConnectionFactory")
	// ConnectionFactory jmsConnectionFactory;

	// TODO: We want to put messages in a queue. The queue is not created in
	// JBOSS 7. and you must create it. To create a queue in JBOSS 7 use the
	// following steps
	// 1 -Go to ${JOBOSS_HOME}/bin and run jboss-admin.bat (sh)
	// 2 - type: connect
	// 3 - type: add-jms-queue --name=ordersQueue --entries=queues/orders

	// TODO: Get the destination of the message.
	// private @Resource(mappedName = "java:/queues/orders") Destination
	// queueDestination;

	private Connection connection;
	private Session session;

	public void submitJob(Job job) throws JMSException {
		// TODO: Create a message producer for the destination (queues/orders)
		// MessageProducer producer =
		// this.session.createProducer(this.queueDestination);

		// TODO: Create a new ObjectMessage and wrap the job within it
		// Message message = this.session.createObjectMessage(job);

		// TODO: Use the producer to send the message
		// producer.send(message);

		// TODO: Close the producer.
		// producer.close();

		// Keep the connection open for other clients, but commit this one.
		// Commit will automatically occurs when closing the connection, but
		// since we're reusing the connection, we manually commit it
		// TODO: Commit the session
		// this.session.commit();
	}

	/**
	 * This method will run when the stateless bean instantiate. We're using it
	 * to create a jms Connection adn jms Session
	 * 
	 * @throws JMSException
	 */
	@SuppressWarnings("unused")
	@PostConstruct
	private void setupJMSResources() throws JMSException {

		// TODO: Use the Connection Factory to create a connection
		// this.connection = jmsConnectionFactory.createConnection();

		// TODO: User the previous created Connection to create a session
		// this.session =
		// this.connection.createSession(true,Session.AUTO_ACKNOWLEDGE);

	}

	/**
	 * This method will run when the container no longer need the bean, so it's
	 * a good place to release any resources
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@PreDestroy
	private void shutdownJMSResources() throws Exception {
		if (this.session != null) {
			this.session.close();
		}
		if (this.connection != null) {
			this.connection.close();
		}
	}
}
