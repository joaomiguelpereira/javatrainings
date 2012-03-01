package eu.jpereira.trainings.jee.mdb.queues.producer;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

import eu.jpereira.trainings.jee.mdb.queues.model.jobs.Job;
import eu.jpereira.trainings.jee.mdb.queues.model.jobs.ProcessOrderJob;
import eu.jpereira.trainings.jee.mdb.queues.model.orders.Orders;
import eu.jpereira.trainings.jee.mdb.queues.model.orders.SellOrder;

/**
 * This class is responsible to trigger a scheduled job to process orders
 * 
 * @author jee
 * 
 */
@Stateless
public class ScheduledOrderJobCreator {

	private @EJB
	Orders ordersDao;

	// TODO: Inject a EJB of type JobsSumitter
	// private JobsSubmitter jobSubmitter;

	@SuppressWarnings("unused")
	@Schedule(second = "*/30", minute = "*", hour = "*", persistent = false)
	private void createJob() {
		System.out.println("Running ScheduleOrderJobCreator");
		SellOrder order = ordersDao.findOldestUnprocessedOrder();

		if (order != null) {

			Job job = new ProcessOrderJob.Builder().forDomainObjectId(
					order.getId()).build();

			// TODO: Use the stateless bean JobsSubmiter to submit the JOB
			/*
			 * try { jobSubmitter.submitJob(job); } catch (JMSException e) {
			 * //Handle the exception correctlty e.printStackTrace(); }
			 */
		}

	}

}
