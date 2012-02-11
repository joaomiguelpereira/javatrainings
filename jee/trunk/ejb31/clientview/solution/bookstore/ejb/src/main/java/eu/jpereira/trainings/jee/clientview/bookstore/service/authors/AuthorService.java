package eu.jpereira.trainings.jee.clientview.bookstore.service.authors;

import java.util.List;

import javax.ejb.Local;

import eu.jpereira.trainings.jee.clientview.bookstore.model.Author;

@Local
public interface AuthorService {
	public List<Author> getAllAuthors(); 
}
