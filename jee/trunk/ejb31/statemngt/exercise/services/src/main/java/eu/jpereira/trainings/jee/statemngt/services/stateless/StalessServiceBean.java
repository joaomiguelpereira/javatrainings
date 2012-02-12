package eu.jpereira.trainings.jee.statemngt.services.stateless;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class StalessServiceBean implements StatelessService {

	private String ipAddress;
	@Override
	public void configureIPAddress(String string) {
		this.ipAddress = string;		
	}

	@Override
	public String getConfiguredIPAddress() {
		return this.ipAddress;
	}

	@SuppressWarnings("unused")
	@PostConstruct
	private void onInstanceCreated() {
		System.out.println("Created new instance of "+this.getClass().getName());
	}
}
