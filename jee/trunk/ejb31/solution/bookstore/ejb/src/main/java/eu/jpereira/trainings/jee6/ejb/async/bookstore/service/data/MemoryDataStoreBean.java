package eu.jpereira.trainings.jee6.ejb.async.bookstore.service.data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import eu.jpereira.trainings.jee6.ejb.async.bookstore.model.Author;


@Singleton
@Startup
@DependsOn(value = "PersistentDataStoreBean")
public class MemoryDataStoreBean {
	private List<Author> authorsList;

	private @EJB
	PersistentDataStoreBean persistenceDataStore;

	public void addAuthor(Author author) {
		this.authorsList.add(author);
	}

	@SuppressWarnings("unused")
	@PostConstruct
	private void init() {

		this.authorsList = new ArrayList<Author>();

		authorsList.add(new Author.Builder().withFirstName("Miguel")
				.withLastName("Esteves Cardoso").withCountry("Portugal")
				.build());
		authorsList.add(new Author.Builder().withFirstName("Jose")
				.withCountry("Portugal").withLastName("Saramago").build());
		authorsList.add(new Author.Builder().withFirstName("Ernest")
				.withLastName("Hemingway").build());
		authorsList.add(new Author.Builder().withFirstName("Winston")
				.withLastName("Churchill").build());
	}

	public List<Author> findAuthors(String query) {
		this.persistenceDataStore.getData();

		return this.authorsList;

	}
}
