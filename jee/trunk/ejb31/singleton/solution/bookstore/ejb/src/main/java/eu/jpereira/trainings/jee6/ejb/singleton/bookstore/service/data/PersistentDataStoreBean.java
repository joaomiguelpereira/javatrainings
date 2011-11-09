package eu.jpereira.trainings.jee6.ejb.singleton.bookstore.service.data;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;

@Singleton
@DependsOn(value="CloudDataStoreBean")
public class PersistentDataStoreBean {

	@SuppressWarnings("unused")
	@PostConstruct
	private void init() {
		System.out.println("Initializing " + this.getClass().getName());
	}
	
	@PreDestroy
	private void remove() {
		System.out.println("Removing " + this.getClass().getName());
	}
}
