package eu.jpereira.trainings.jee6.ejb.singleton.bookstore.service.data;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

@Singleton
public class CloudDataStoreBean {
	
	@SuppressWarnings("unused")
	@PostConstruct
	private void init() {
		System.out.println("Initializing " + this.getClass().getName());
	}
	
	@SuppressWarnings("unused")
	@PreDestroy
	private void remove() {
		System.out.println("Removing " + this.getClass().getName());
	}

}
