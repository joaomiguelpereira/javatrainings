package eu.jpereira.trainings.jee6.ejb.async.bookstore.service.authors;

import java.util.List;

import javax.ejb.Local;

import eu.jpereira.trainings.jee6.ejb.async.bookstore.model.Author;

@Local
public interface AuthorService {
	public List<Author> getAllAuthors(); 
	
	public void addAuthor(Author author);
	
}
