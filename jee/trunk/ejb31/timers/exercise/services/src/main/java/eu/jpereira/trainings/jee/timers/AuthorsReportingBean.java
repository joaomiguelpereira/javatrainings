package eu.jpereira.trainings.jee.timers;

import javax.ejb.EJB;
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
public class AuthorsReportingBean {

	// this injection point is required because timeout methods are not allowed
	// to have interceptors. Usually, timeout methods don't run any business
	// logic, are like any other interface, they should delegate requests to
	// domain model or service layer. That's why the spec disallow interceptors in timeout
	// methods, to reinforce this design.
	private @EJB
	AuthorsReportingBean delegate;

	/**
	 * TODO: This is the timeout method that you should configure in
	 * src/main/resources/META-INF/ejb-jar.xml.
	 * 
	 * 1 - Open file src/main/resources/META-INF/ejb-jar.xml and configure the timer to call this method. 
	 * See the end of this file for hints
	 * 
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

/* Use the following configuration in your ejb-jar.xml
<enterprise-beans>
<session>

	<!-- Give a name to the Bean -->
	<ejb-name>AuthorsReportingBean</ejb-name>

	<!-- Indicates is a local bean -->
	<local-bean />
	<!-- Specify the class implementing the bean -->

	<ejb-class>eu.jpereira.trainings.jee.timers.AuthorsReportingBean</ejb-class>

	<!-- Specify the type of component in regards to state management -->
	<session-type>Stateless</session-type>


	<!-- Configure the timer -->

	<timer>
		<!-- Create a schedule for the timer. Should run every 10 seconds -->
		<schedule>
			<second>* / 10</second> <!--The space between * an / and 10 should be removed-->
			<minute>*</minute>
			<hour>*</hour>
		</schedule>

		<!-- Specify the method to be called when the timer expires -->
		<timeout-method>
			<method-name>runReport</method-name>
		</timeout-method>

		<!-- Is this a persistent timer? Persistent timers will live between 
			server crashes -->
		<persistent>false</persistent>
		<!-- Some info for the timer -->
		<info>Timer created with ejb deployment descriptor</info>
	</timer>
</session>

</enterprise-beans>
*/