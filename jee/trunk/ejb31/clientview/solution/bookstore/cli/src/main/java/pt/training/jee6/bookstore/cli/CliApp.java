package pt.training.jee6.bookstore.cli;

import java.util.List;

import pt.training.jee6.bookstore.model.Author;

/**
 * Hello world!
 * 
 */
public class CliApp {
	public static void main(String[] args){
		List<Author> list = null;
		try {
			list = ServiceLocator.instance.getBookstoreService().findAuthor("Some query");
		} catch (Exception e) {
			
			e.printStackTrace();
			System.exit(0);
		}
		
		for (Author author: list ) {
			System.out.println("Name: "+author.getFullName());
		}
		
	}
	
	
	
	
}

