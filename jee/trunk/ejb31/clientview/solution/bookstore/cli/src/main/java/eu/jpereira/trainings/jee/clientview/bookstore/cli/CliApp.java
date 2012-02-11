package eu.jpereira.trainings.jee.clientview.bookstore.cli;

import java.security.Security;
import java.util.List;

import org.jboss.sasl.JBossSaslProvider;

import eu.jpereira.trainings.jee.clientview.bookstore.model.Author;
import eu.jpereira.trainings.jee.clientview.bookstore.service.store.BookstoreService;

/**
 * This is a sample JBoss 7 ejb remote client! 
 * 
 */
public class CliApp {
	
	// The EJB invocation happens via the JBoss Remoting project, which uses
	// SASL for
	// authentication for client-server authentication. There are various
	// different security algorithms that
	// SASL supports. In this example we use "anonymous" access to the server
	// and for that we register
	// the JBossSaslProvider which provides support for that algorithm.
	// Depending on how which algorithm
	// is used, this piece of code to register JBossSaslProvider, may or may not
	// be required
	static {
		Security.addProvider(new JBossSaslProvider());
	}

	public static void main(String[] args) throws Exception {
		// Invoke a stateless bean
		invokeStatelessBean();
	}

	
	/**
	 * invoke the test EJB
	 * @throws Exception
	 */
	private static void invokeStatelessBean() throws Exception {
		// Let's lookup the remote stateless BookstoreService
		BookstoreService booktoreService = ServiceLocator.instance
				.getBookstoreService();

		List<Author> authors = booktoreService.findAuthor("Dummy");
		for (Author author : authors) {
			System.out.println(author.getFullName());
		}

	}

}
