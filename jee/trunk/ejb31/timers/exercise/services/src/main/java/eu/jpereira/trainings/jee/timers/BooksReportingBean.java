package eu.jpereira.trainings.jee.timers;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timer;
import javax.interceptor.Interceptors;

import eu.jpereira.trainings.jee.timers.framework.interceptors.MethodInvocationInterceptor;

/**
 * This class defines a two timeout methods using annotations. One timeout will
 * run every two minutes, the other will run every three minutes
 */
@Stateless
public class BooksReportingBean {

	// this injection point is required because timeout methods are not allowed
	// to have interceptors. Usually, timeout methods don't run any business
	// logic, are like any other interface, they should delegate requests to
	// domain model.That's why the spec disallow interceptors in timeout
	// methods, to reinforce
	// this design.
	private @EJB
	BooksReportingBean delegate;

	// TODO: Annotate this method with @Schedule and configure the timer to run
	// every two minutes. Configure the timer with persistence = false.
	@Schedule(minute = "*/2", hour = "*", info = "BooksReporting Bean", persistent = false)
	public void twoMinutes(Timer timer) {
		delegate.doJob();
	}

	//TODO: Annotate this method with @Schedule and configure the timer to run
	// every three minutes. Configure the timer with persistence = false.
	@Schedule(minute = "*/3", hour = "*", info = "BooksReporting Bean", persistent = false)
	public void threeMinutes(Timer timer) {
		delegate.doJob();
	}

	@Interceptors(MethodInvocationInterceptor.class)
	public void doJob() {
	}

}
