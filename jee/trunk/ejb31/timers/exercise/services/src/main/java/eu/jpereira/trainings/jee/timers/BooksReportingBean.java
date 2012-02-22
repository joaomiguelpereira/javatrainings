package eu.jpereira.trainings.jee.timers;

import javax.ejb.Stateless;
import javax.ejb.Timer;

/**
 * This class defines two timeout methods using annotations. One timeout will
 * run every minute, the other will run every 30 seconds
 */
@Stateless
public class BooksReportingBean {

	// this injection point is required because timeout methods are not allowed
	// to have interceptors. Usually, timeout methods don't run any business
	// logic, are like any other interface, they should delegate requests to
	// domain model.That's why the spec disallow interceptors in timeout
	// methods, to reinforce
	// this design.
	
	//TODO: Inject an EJB reference to this class using the annotation javax.ejb.EJB
	//private BooksReportingBean delegate;

	// TODO: Annotate this method with javax.ejb.Schedule and configure the timer to run
	// every minute. Configure the timer with persistence = false.
	//Example: @Schedule(minute = "*", hour = "*", info = "BooksReporting Bean", persistent = false)
	public void oneMinute(Timer timer) {
		//TODO: Delegate to an instance of this class but with ejb services
		//delegate.doJob();
	}

	//TODO: Annotate this method with @Schedule and configure the timer to run
	// every thirty seconds. Configure the timer with persistence = false.
	public void thirtySeconds(Timer timer) {
		//TODO: Delegate to an instance of this class but with ejb services
		//delegate.doJob();
	}

	//This is the method that will be intercepted by MethodInvocationIntercepto to count the number of times the method was invoked
	//TODO: Use the annotation javax.interceptor.Interceptors to specify the MethodInvocationInterceptor.class as an interceptor
	public void doJob() {
	}

}
