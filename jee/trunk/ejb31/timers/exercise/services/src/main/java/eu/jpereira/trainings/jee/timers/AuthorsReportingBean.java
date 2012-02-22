package eu.jpereira.trainings.jee.timers;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.Timer;
import javax.interceptor.Interceptors;

import eu.jpereira.trainings.jee.timers.framework.interceptors.MethodInvocationInterceptor;

/**
 * This is a stateless bean because of the EJB Interceptors. EJB Interceptors
 * apply only for Session Beans business interfaces and Message driven beans.
 * The workaround is to inject one instance of this class into instances of
 * itself, and delegate the timeout method for a business method to the injected instance
 * 
 * @author jee
 * 
 */
@Stateless
public class AuthorsReportingBean {

	// this injection point is required because timeout methods are not allowed
	// to have interceptors. Usually, timeout methods don't run any business
	// logic, are like any other interface, they should delegate requests to
	// domain model.That's why the spec disallow interceptors in timeout
	// methods, to reinforce
	// this design.
	private @EJB
	AuthorsReportingBean delegate;

	/**
	 * TODO: This is the timeout method that you should configure in
	 * src/main/resources/META-INF/ejb-jar.xml.
	 * 
	 * 1 - Open file src/main/resources/META-INF/ejb-jar.xml and follow the
	 * steps
	 * 
	 * @param timer
	 */
	public void runReport(Timer timer) {
		// This is the point where a delegation to domain model should occur
		// In this exercise, we're just delegating to a session bean of the same
		// type as this. In good design, you should avoid this
		delegate.doJobFromTimer(timer);
	}

	@Interceptors(MethodInvocationInterceptor.class)
	public void doJobFromTimer(Timer timer) {
	}

}
