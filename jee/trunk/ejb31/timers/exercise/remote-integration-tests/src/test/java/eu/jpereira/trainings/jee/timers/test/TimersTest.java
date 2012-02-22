package eu.jpereira.trainings.jee.timers.test;

import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import eu.jpereira.trainings.jee.timers.AuthorsReportingBean;
import eu.jpereira.trainings.jee.timers.BookSellingReportingBean;
import eu.jpereira.trainings.jee.timers.BooksReportingBean;
import eu.jpereira.trainings.jee.timers.ReadersReportingBean;
import eu.jpereira.trainings.jee.timers.service.TimeoutCounterFacade;
import eu.jpereira.trainings.jee.timers.service.DefaultTimeoutCounterFacade;

public class TimersTest extends RemoteEJBTest {

	
	private static final long POLL_INTERVAL =  5000;
	/**
	 * Configuration matches the deployed Session Beans in JBoss 7 Override it
	 * here
	 */
	@BeforeClass
	public static void setConfiguration() {
		appName = ""; //We're deploying the EJB jar only
		moduleName = "services-1.0-SNAPSHOT";
		distinctName = "";
	}

	@Test(timeout=600000) //wait 10 minutes before failing
	public void test() throws NamingException, InterruptedException {

		
		TimeoutCounterFacade facade = getStatelessSessionBeanReferenceFor(
				TimeoutCounterFacade.class, DefaultTimeoutCounterFacade.class);

		// this will count the number of hits in a timer. A hit is measured
		// calling the TimeoutCounterFacade.getTimeoutCountFor(Class<?>) and
		// check if return is greater than 0
		Map<Class<?>, Integer> counter = new HashMap<Class<?>, Integer>();

		counter.put(AuthorsReportingBean.class, Integer.valueOf(0));
		counter.put(BookSellingReportingBean.class, Integer.valueOf(0));
		counter.put(BooksReportingBean.class, Integer.valueOf(0));
		counter.put(ReadersReportingBean.class, Integer.valueOf(0));

		boolean done = false;
		
		while (!done) {

			boolean hit = true;
			
			for (Class<?> targetClass : counter.keySet()) {

				Integer numberOfHits = facade.getTimeoutCountFor(targetClass);
				System.err.println("Hit for " + targetClass + " --> "
						+ numberOfHits);
				hit = hit & (numberOfHits > 0);
			}
			done = hit;
			
			//Wait
			Thread.sleep(POLL_INTERVAL);

		}

	}

}
