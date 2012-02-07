package pt.training.jee6.bookstore.cli;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;

import pt.training.jee6.bookstore.service.bookstore.BookstoreService;

public class ServiceLocator {

	private static final String BOOKSTORE_SERVICE_JNDI = "bookstore/BookstoreServiceBean/remote";
	public static ServiceLocator instance = new ServiceLocator();
	private Map<Class<?>, Object> statelessServices;
	private Context ctx;

	private ServiceLocator() {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

	}

	private void init() throws Exception {
		this.statelessServices = new HashMap<Class<?>, Object>();
		this.ctx = new InitialContext();
	}

	public BookstoreService getBookstoreService() throws Exception {
		BookstoreService ref = (BookstoreService) this.statelessServices
				.get(BookstoreService.class);
		if (ref == null) {
			ref = (BookstoreService) this.ctx.lookup(BOOKSTORE_SERVICE_JNDI);
			this.statelessServices.put(BookstoreService.class, ref);
		}
		return ref;
	}
}
