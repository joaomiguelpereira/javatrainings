package eu.jpereira.trainings.jee.clientview.bookstore.cli;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import eu.jpereira.trainings.jee.clientview.bookstore.service.store.BookstoreService;
import eu.jpereira.trainings.jee.clientview.bookstore.service.store.BookstoreServiceBean;

/**
 * Simple Service Locator.
 * 
 * 
 * @author joaomiguel.pereira@gmail.com
 * 
 */
public class ServiceLocator {

	public static ServiceLocator instance = new ServiceLocator();
	private Map<Class<?>, Object> statelessServices;

	private ServiceLocator() {
		this.statelessServices = new HashMap<Class<?>, Object>();
	}

	public BookstoreService getBookstoreService() throws Exception {
		BookstoreService ref = (BookstoreService) this.statelessServices
				.get(BookstoreService.class);

		if (ref == null) {

			ref = lookupBookstoreService();
			this.statelessServices.put(BookstoreService.class, ref);
		}
		return ref;
	}

	private static BookstoreService lookupBookstoreService()
			throws NamingException {

		Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.URL_PKG_PREFIXES,
				"org.jboss.ejb.client.naming");

		Context context = new InitialContext(jndiProperties);
		// The app name is the application name of the deployed EJBs. This is
		// typically the ear name
		// without the .ear suffix. However, the application name could be
		// overridden in the application.xml of the
		// EJB deployment on the server.
		// Since we have deployed the application as a .ear, the app name for
		// us will be the name of the ear.
		String appName = "ear-1.0-FINAL";
		// This is the module name of the deployed EJBs on the server. This is
		// typically the jar name of the
		// EJB deployment, without the .jar suffix, but can be overridden via
		// the ejb-jar.xml
		String moduleName = "ejb-1.0-FINAL";
		// AS7 allows each deployment to have an (optional) distinct name. We
		// haven't specified a distinct name for
		// our EJB deployment, so this is an empty string
		String distinctName = "";
		// The EJB name which by default is the simple class name of the bean
		// implementation class
		String beanName = BookstoreServiceBean.class.getSimpleName();
		// the remote view fully qualified class name
		String viewClassName = BookstoreService.class.getName();
		// let's do the lookup and return the reference to our service

		return (BookstoreService) context.lookup("ejb:" + appName + "/"
				+ moduleName + "/" + distinctName + "/" + beanName + "!"
				+ viewClassName);

	}

}
