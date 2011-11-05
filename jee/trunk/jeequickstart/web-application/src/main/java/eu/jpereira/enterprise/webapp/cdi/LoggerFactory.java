package eu.jpereira.enterprise.webapp.cdi;



import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;


/**
 * This Class acts as a CDI producer for instances of type of Logger
 * @author jee5
 *
 */
@ApplicationScoped
public class LoggerFactory {

	/**
	 * Produces a Logger instance 
	 * @param ip
	 * @return Logger instance
	 */
	@Produces @Log4JLogger
	public Logger createLogger(InjectionPoint ip) {
		return Logger.getLogger(ip.getMember().getDeclaringClass().getName());
	}
}
