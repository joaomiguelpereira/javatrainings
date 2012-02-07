package pt.training.jee6.bookstore.web.jsf;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import pt.training.jee6.bookstore.model.Author;
import pt.training.jee6.bookstore.service.authors.AuthorService;

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
