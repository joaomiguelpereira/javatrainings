package pt.training.jee6.bookstore.service.authors;

import java.util.List;

import javax.ejb.Local;

import pt.training.jee6.bookstore.model.Author;
@Local
public interface AuthorService {
	public List<Author> getAllAuthors(); 
}
