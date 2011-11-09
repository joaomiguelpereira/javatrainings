package eu.jpereira.trainings.jee6.ejb.singleton.bookstore.service.authors;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import eu.jpereira.trainings.jee6.ejb.singleton.bookstore.model.Author;
import eu.jpereira.trainings.jee6.ejb.singleton.bookstore.service.data.MemoryDataStoreBean;

@Stateless
public class AuthorServiceBean implements AuthorService {

	private @EJB
	MemoryDataStoreBean dataStore;

	@Override
	public List<Author> getAllAuthors() {
		return dataStore.findAuthors("none");
	}

	@Override
	public void addAuthor(Author author) {
		this.dataStore.addAuthor(author);

	}


}
