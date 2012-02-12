package eu.jpereira.trainings.jee.statemngt.test.stateless;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import eu.jpereira.trainings.jee.statemngt.services.stateless.StalessServiceBean;
import eu.jpereira.trainings.jee.statemngt.services.stateless.StatelessService;
import eu.jpereira.trainings.jee.statemngt.test.RemoteEJBTest;

/**
 * Tests for business methods
 * 
 * @author jee
 * 
 */
public class SatelessSessionBeanTest extends RemoteEJBTest {

	/**
	 * Configuration matches the deployed Session Beans in JBoss 7 Override it
	 * here
	 */
	@BeforeClass
	public static void setConfiguration() {
		appName = "enterprise-application-1.0-SNAPSHOT";
		moduleName = "services-1.0-SNAPSHOT";
		distinctName = "";
	}

	/**
	 * Test that references to a Stateless Session Bean are the same
	 * 
	 * @throws NamingException
	 */
	@Test
	public void testStatelessSameReference() throws NamingException {
		String ip = "127.0.0.1";
		// get one reference to a Stateless session bean
		StatelessService serviceUnderTest = getStatelessSessionBeanReferenceFor(
				StatelessService.class, StalessServiceBean.class);

		// Modify some state on the Bean
		serviceUnderTest.configureIPAddress(ip);

		// Assert configuration was set
		assertEquals(ip, serviceUnderTest.getConfiguredIPAddress());

		// get another reference to a Stateless session bean of same type
		StatelessService otherServiceReference = getStatelessSessionBeanReferenceFor(
				StatelessService.class, StalessServiceBean.class);

		// The returned reference should hold the same instance of the Bean
		// class previously looked up, since Stateless session bean instances
		// are pooled
		assertEquals(ip, otherServiceReference.getConfiguredIPAddress());
		assertEquals(otherServiceReference, serviceUnderTest);
	}

	/**
	 * Check the results in relation to memory consumption when using multiple references to the same stateless session bean
	 * Use jconsole to monitor memory consumption of JBoss 7
	 * @throws NamingException
	 */
	@Test
	public void testMultipleStatelessReferences() throws NamingException {
		// Number of references to lookup
		int numberOfReferences = 10000;
		// Collection to hold a reference to the looked up references. Prevents
		// GC
		List<StatelessService> instances = new ArrayList<StatelessService>();
		System.out.println("Getting references...");
		for (int i = 0; i < numberOfReferences; i++) {
			StatelessService service = getStatelessSessionBeanReferenceFor(
					StatelessService.class, StalessServiceBean.class);
			// Make a call to the session bean to make sure a bean class is
			// intantiated.
			service.configureIPAddress("127.0.0.1");
			// Get this reference to the service away from GC
			instances.add(service);

		}
		System.out
				.println("Check memory consumption in jconsole, then press any key to terminate test...");

		Scanner in = new Scanner(System.in);
		in.nextLine();
	}
}
