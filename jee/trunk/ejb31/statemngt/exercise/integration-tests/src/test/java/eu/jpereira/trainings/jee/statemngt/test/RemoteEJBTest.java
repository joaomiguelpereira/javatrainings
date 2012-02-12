package eu.jpereira.trainings.jee.statemngt.test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Ignore;

/**
 * This is an abstract class providing common behavior and state for unit tests
 * that requires access to remote Session Beans
 * 
 * @author joaomigue.pereira@gmail.com
 * 
 */
@Ignore
public abstract class RemoteEJBTest {

	/**
	 * Application name.
	 */
	protected static String appName = "enterprise-application-1.0-SNAPSHOT";

	/**
	 * Module name
	 */
	protected static String moduleName = "services-1.0-SNAPSHOT";

	/**
	 * Distinct name
	 */
	protected static String distinctName = "";

	/**
	 * Get a reference to a Stateless Remote Session Bean deployed on JBoss AS 7
	 * 
	 * @param viewClass
	 *            The {@link Class} of the java interface defining the Session
	 *            Bean remote view
	 * @param beanClass
	 *            The {@link Class} of the java class implementing the viewClass
	 * @return The result of a lookup
	 * @throws NamingException
	 */
	protected <T> T getStatelessSessionBeanReferenceFor(Class<?> viewClass,
			Class<?> beanClass) throws NamingException {
		return getSessionBeanReferenceFor(viewClass, beanClass, false);
	}


	/**
	 * Get a reference to a Stateful Remote Session Bean deployed on JBoss AS 7
	 * 
	 * @param viewClass
	 *            The {@link Class} of the java interface defining the Session
	 *            Bean remote view
	 * @param beanClass
	 *            The {@link Class} of the java class implementing the viewClass
	 * @return The result of a lookup
	 * @throws NamingException
	 */

	protected <T> T getSatefulSessionBeanReferenceFor(Class<?> viewClass,
			Class<?> beanClass) throws NamingException {
		return getSessionBeanReferenceFor(viewClass, beanClass, true);
	}

	@SuppressWarnings("unchecked")
	private <T> T getSessionBeanReferenceFor(Class<?> viewClass,
			Class<?> beanClass, boolean stateful) throws NamingException {
		Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");

		Context context = new InitialContext(jndiProperties);

		return (T) context.lookup("ejb:" + appName + "/" + moduleName + "/"
				+ distinctName + "/" + beanClass.getSimpleName() + "!"
				+ viewClass.getName() + (stateful ? "?stateful" : ""));

	}
}
