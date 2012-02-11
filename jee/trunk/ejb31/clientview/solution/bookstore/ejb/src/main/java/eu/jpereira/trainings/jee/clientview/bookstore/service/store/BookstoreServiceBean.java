package eu.jpereira.trainings.jee.clientview.bookstore.service.store;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import eu.jpereira.trainings.jee.clientview.bookstore.model.Author;
import eu.jpereira.trainings.jee.clientview.bookstore.service.authors.AuthorService;


@Stateless
public class BookstoreServiceBean implements BookstoreService {
	
	private @EJB AuthorService authorService;

	@Override
	public List<Author> findAuthor(String query) {
		System.out.println("Finding author :"+(query!=null?query:"NO_QUERY"));
		return this.authorService.getAllAuthors();
	}

}
