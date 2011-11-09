package eu.jpereira.trainings.jee6.ejb.singleton.bookstore.service.bookstore;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import eu.jpereira.trainings.jee6.ejb.singleton.bookstore.model.Author;
import eu.jpereira.trainings.jee6.ejb.singleton.bookstore.service.data.MemoryDataStoreBean;


@Stateless
public class BookstoreServiceBean implements BookstoreService {
	
	private @EJB MemoryDataStoreBean memoryDataStoreBean;

	@Override
	public List<Author> findAuthor(String query) {
		System.out.println("Finding author :"+(query!=null?query:"NO_QUERY"));
		return this.memoryDataStoreBean.findAuthors(query);
	}

	@Override
	public void addAuthor(Author author) {
		this.memoryDataStoreBean.addAuthor(author);
		
	}

}
