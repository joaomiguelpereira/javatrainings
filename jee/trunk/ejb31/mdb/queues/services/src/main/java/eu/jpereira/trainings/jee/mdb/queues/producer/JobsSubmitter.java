package eu.jpereira.trainings.jee.mdb.queues.producer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import eu.jpereira.trainings.jee.mdb.queues.model.jobs.Job;

@Stateless
public class JobsSubmitter {

	private @Resource(mappedName = "java:/ConnectionFactory")
	ConnectionFactory jmsConnectionFactory;

	private @Resource(mappedName = "java:/queues/orders")
	Destination queueDestination;

	private Connection connection;
	private Session session;

	public void submitJob(Job job) throws JMSException {
		System.err.println("Submitting JOB....");
		MessageProducer producer = this.session
				.createProducer(this.queueDestination);

		Message message = this.session.createObjectMessage(job);
		producer.send(message);
		producer.close();

		// Keep the connection open for other clients, but commit this one.
		// Commit will automatically occurs when closing the connection, but
		// since we're reusing the connection, we manually commit it
		this.session.commit();
	}

	@SuppressWarnings("unused")
	@PostConstruct
	private void setupJMSResources() throws JMSException {
		System.out.println("Setting up JMS resources");
		this.connection = jmsConnectionFactory.createConnection();
		this.session = this.connection.createSession(true,
				Session.AUTO_ACKNOWLEDGE);

	}

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
