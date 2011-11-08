package eu.jpereira.trainings.jee6.ejb.async.bookstore.service.discovering;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import eu.jpereira.trainings.jee6.ejb.async.bookstore.model.Author;


@Stateless
public class AuthorsParserService {

	public List<Author> parseAuthors(String[] input) {
		List<Author> parsedAuthorsList = new ArrayList<Author>();
		for (String line : input) {
			String[] tokens = line.split(",");
			Author author = new Author();
			author.setFirstName(tokens[0]);
			author.setLastName(tokens[1]);
			author.setCountry(tokens[2]);
			author.setRegion(tokens[3]);
			parsedAuthorsList.add(author);
		}
		return parsedAuthorsList;
	}
}
