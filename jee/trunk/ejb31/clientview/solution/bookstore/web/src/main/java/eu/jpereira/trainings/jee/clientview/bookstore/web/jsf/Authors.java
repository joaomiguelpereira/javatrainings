package eu.jpereira.trainings.jee.clientview.bookstore.web.jsf;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;

import eu.jpereira.trainings.jee.clientview.bookstore.model.Author;
import eu.jpereira.trainings.jee.clientview.bookstore.service.authors.AuthorService;

/**
 * Authors JSF Managed beans
 * 
 * @author jee5
 * 
 */
public @Model
class Authors {
	
	private @EJB AuthorService authorService;	
	public List<Author> getAllAuthors() {
		return this.authorService.getAllAuthors();
	}

}
