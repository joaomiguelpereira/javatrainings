package eu.jpereira.trainings.jee.clientview.bookstore.service.authors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import eu.jpereira.trainings.jee.clientview.bookstore.model.Author;


@Stateless
public class AuthorServiceBean implements AuthorService {

	@Override
	public List<Author> getAllAuthors() {
		System.out.println("Getting all authors");
		List<Author> authorsList = new ArrayList<Author>();
		authorsList.add(new Author.Builder().withFirstName("Miguel")
				.withLastName("Esteves Cardoso").withBornDate(new Date())
				.withCountry("Portugal").build());
		authorsList.add(new Author.Builder().withFirstName("Jose")
				.withBornDate(new Date()).withCountry("Portugal")
				.withLastName("Saramago").build());
		authorsList.add(new Author.Builder().withFirstName("Ernest")
				.withLastName("Hemingway").build());
		authorsList.add(new Author.Builder().withFirstName("Winston")
				.withLastName("Churchill").build());
		return authorsList;
	}

}
