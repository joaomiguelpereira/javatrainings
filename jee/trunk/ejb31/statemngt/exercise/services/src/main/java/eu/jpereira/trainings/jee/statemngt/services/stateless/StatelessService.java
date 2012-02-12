package eu.jpereira.trainings.jee.statemngt.services.stateless;

import javax.ejb.Remote;

@Remote
public interface StatelessService {

	
	void configureIPAddress(String string);
	
	String getConfiguredIPAddress();
}
