package eu.jpereira.trainings.jee6.ejb.async.bookstore.service.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import eu.jpereira.trainings.jee6.ejb.async.bookstore.model.Author;


@Singleton
public class CloudPersistenceDataStoreBean {
	public List<Author> getData() {
		return null;
	}

	@SuppressWarnings("unused")
	@PostConstruct
	private void init() {
		System.out.println("Initializing " + this.getClass().getName());
	}
}
