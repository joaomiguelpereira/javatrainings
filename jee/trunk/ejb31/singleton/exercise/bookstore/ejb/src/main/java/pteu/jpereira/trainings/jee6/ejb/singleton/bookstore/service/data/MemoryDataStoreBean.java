package pteu.jpereira.trainings.jee6.ejb.singleton.bookstore.service.data;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import eu.jpereira.trainings.jee6.ejb.singleton.bookstore.model.Author;


@Singleton
public class MemoryDataStoreBean {
	private List<Author> authorsList;

	public void addAuthor(Author author) {
		this.authorsList.add(author);
	}

	@SuppressWarnings("unused")
	@PostConstruct
	private void init() {
		System.out.println("Initializing " + this.getClass().getName());
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
		return this.authorsList;

	}
}
