package eu.jpereira.trainings.jee6.ejb.async.bookstore.web.model;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.inject.Named;

import eu.jpereira.trainings.jee6.ejb.async.bookstore.model.Author;
import eu.jpereira.trainings.jee6.ejb.async.bookstore.service.authors.AuthorService;


/**
 * Authors JSF Managed beans
 * 
 * @author jee5
 * 
 */
public @Model
@Named(value = "authors")
class AuthorsBean {

	private @EJB
	AuthorService authorService;

	public List<Author> getAllAuthors() {

		
		return this.authorService.getAllAuthors();
	}

}
