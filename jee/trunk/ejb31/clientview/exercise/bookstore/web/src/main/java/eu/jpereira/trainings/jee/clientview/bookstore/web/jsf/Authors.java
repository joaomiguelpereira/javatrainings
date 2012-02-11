package eu.jpereira.trainings.jee.clientview.bookstore.web.jsf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.inject.Model;

import eu.jpereira.trainings.jee.clientview.bookstore.model.Author;


/**
 * Authors JSF Managed beans
 * 
 * @author jee5
 * 
 */
public @Model
class Authors {

	@SuppressWarnings("serial")
	public List<Author> getAllAuthors() {
		return new ArrayList<Author>() {
			{
				add(new Author.Builder().withFirstName("Miguel")
						.withLastName("Esteves Cardoso")
						.withBornDate(new Date()).withCountry("Portugal")
						.build());
				add(new Author.Builder().withFirstName("Jose")
						.withBornDate(new Date()).withCountry("Portugal")
						.withLastName("Saramago").build());
				add(new Author.Builder().withFirstName("Ernest")
						.withLastName("Hemingway").build());
				add(new Author.Builder().withFirstName("Winston")
						.withLastName("Churchill").build());

			}

		};
	}

}
