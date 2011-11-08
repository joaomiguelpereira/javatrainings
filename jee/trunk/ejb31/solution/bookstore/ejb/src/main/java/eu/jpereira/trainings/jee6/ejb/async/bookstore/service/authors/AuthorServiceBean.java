package eu.jpereira.trainings.jee6.ejb.async.bookstore.service.authors;

import java.util.List;
import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import eu.jpereira.trainings.jee6.ejb.async.bookstore.model.Author;
import eu.jpereira.trainings.jee6.ejb.async.bookstore.service.data.MemoryDataStoreBean;
import eu.jpereira.trainings.jee6.ejb.async.bookstore.service.discovering.AuthorsParserService;
import eu.jpereira.trainings.jee6.ejb.async.bookstore.service.discovering.URLReaderService;


@Stateless
public class AuthorServiceBean implements AuthorService {

	private @EJB
	MemoryDataStoreBean dataStore;
	private @EJB
	URLReaderService readerService;
	private @EJB
	AuthorsParserService parserService;

	@Override
	public List<Author> getAllAuthors() {
		return dataStore.findAuthors("none");
	}

	@Override
	public void addAuthor(Author author) {
		this.dataStore.addAuthor(author);
	}

	@Override
	@Asynchronous
	public Future<List<Author>> discoverAuthorsFromURL(String url)
			throws Exception {
		List<Author> list;

		System.out.println("Runnig async");
		list = parserService.parseAuthors(readerService.getURLContents(url));
		for (Author author : list) {
			dataStore.addAuthor(author);
		}
		System.out.println("Returning async");
		return new AsyncResult<List<Author>>(list);
	}
}
