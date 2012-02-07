package pt.training.jee6.bookstore.service.bookstore;

import java.util.List;

import javax.ejb.Remote;

import pt.training.jee6.bookstore.model.Author;

@Remote
public interface BookstoreService {

	/**
	 * Find Author based on the query String
	 * @param query The query
	 * @return A list with all matched records
	 */
	public List<Author> findAuthor(String query);
}
