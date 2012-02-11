package eu.jpereira.trainings.jee.clientview.bookstore.service.store;

import java.util.List;

import javax.ejb.Remote;

import eu.jpereira.trainings.jee.clientview.bookstore.model.Author;


@Remote
public interface BookstoreService {

	/**
	 * Find Author based on the query String
	 * @param query The query
	 * @return A list with all matched records
	 */
	public List<Author> findAuthor(String query);
}
