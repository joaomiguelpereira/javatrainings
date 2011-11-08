package eu.jpereira.trainings.jee6.ejb.async.bookstore.service.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Singleton;

import eu.jpereira.trainings.jee6.ejb.async.bookstore.model.Author;



@Singleton
@DependsOn(value="CloudPersistenceDataStoreBean")
public class PersistentDataStoreBean {

	private @EJB CloudPersistenceDataStoreBean cloudStore;
	public List<Author> getData() {
		
		return this.cloudStore.getData();
	}

	@SuppressWarnings("unused")
	@PostConstruct
	private void init() {
		System.out.println("Initializing " + this.getClass().getName());
	}
}
