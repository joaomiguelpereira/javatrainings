package pt.training.jee6.projectmngt.rest.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import pt.training.jee6.projectmngt.service.ProjectService;

/**
 * @author joaomiguel.pereira@gmail.com
 */
public class ServiceLocator {

	private Map<Class<?>, String> jndiNames = new HashMap<Class<?>, String>();
	private Map<Class<?>, Object> serviceInstance = new HashMap<Class<?>, Object>();
	private Context ctx;
	private static ServiceLocator instance = null;

	public static ServiceLocator getInstance() {
		if (instance == null) {
			instance = new ServiceLocator();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public <T> T getService(Class<T> clazz) {
		// try to find it in the cache

		T service = (T) serviceInstance.get(clazz);
		if (service == null) {
			try {
				service = (T) ctx.lookup(jndiNames.get(clazz));
			} catch (NamingException e) {

				e.printStackTrace();
				throw new RuntimeException(e);
			}
			serviceInstance.put(clazz, service);

		}
		return service;

	}

	private ServiceLocator() {
		init();
		jndiNames.put(ProjectService.class,
				"projectmngt/ProjectServiceBean/local");
	}

	private void init() throws RuntimeException {
		Properties props = new Properties();
		props.put("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");

		props.put("java.naming.factory.url.pkgs",
				"org.jboss.naming:org.jnp.interfaces");

		props.put("org.jboss.naming:org.jnp.interfaces", "localhost:1099");

		try {
			ctx = new InitialContext(props);
		} catch (NamingException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
