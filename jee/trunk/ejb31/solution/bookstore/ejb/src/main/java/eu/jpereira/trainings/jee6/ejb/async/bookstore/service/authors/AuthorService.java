package eu.jpereira.trainings.jee6.ejb.async.bookstore.service.authors;

import java.util.List;
import java.util.concurrent.Future;

import javax.ejb.Local;

import eu.jpereira.trainings.jee6.ejb.async.bookstore.model.Author;


@Local
public interface AuthorService {
	public List<Author> getAllAuthors();

	public void addAuthor(Author author);

	public Future<List<Author>> discoverAuthorsFromURL(String url) throws Exception;

}
