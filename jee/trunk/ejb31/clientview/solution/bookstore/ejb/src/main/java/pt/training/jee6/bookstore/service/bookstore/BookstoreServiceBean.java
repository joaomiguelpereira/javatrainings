package pt.training.jee6.bookstore.service.bookstore;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import pt.training.jee6.bookstore.model.Author;
import pt.training.jee6.bookstore.service.authors.AuthorService;

@Stateless
public class BookstoreServiceBean implements BookstoreService {
	
	private @EJB AuthorService authorService;

	@Override
	public List<Author> findAuthor(String query) {
		System.out.println("Finding author :"+(query!=null?query:"NO_QUERY"));
		return this.authorService.getAllAuthors();
	}

}
