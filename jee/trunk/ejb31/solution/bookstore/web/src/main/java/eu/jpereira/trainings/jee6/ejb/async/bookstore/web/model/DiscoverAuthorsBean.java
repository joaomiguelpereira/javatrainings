package eu.jpereira.trainings.jee6.ejb.async.bookstore.web.model;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Future;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;

import eu.jpereira.trainings.jee6.ejb.async.bookstore.model.Author;
import eu.jpereira.trainings.jee6.ejb.async.bookstore.service.authors.AuthorService;


public @Model @SessionScoped
class DiscoverAuthorsBean implements Serializable{

	private static final long serialVersionUID = 1679990288631003396L;

	private Future<List<Author>> result;
	private @EJB
	AuthorService authorService;
	private String url ="http://www.wikipedia.com";

	public String discover() throws Exception {
		this.result = authorService.discoverAuthorsFromURL(this.url);
		return "/authors/list";
	}
	

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public Future<List<Author>> getResult() {
		return result;
	}
}
