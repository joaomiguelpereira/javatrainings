package eu.jpereira.trainings.jee6.ejb.async.bookstore.web.model;


import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.validation.constraints.NotNull;

import eu.jpereira.trainings.jee6.ejb.async.bookstore.model.Author;
import eu.jpereira.trainings.jee6.ejb.async.bookstore.service.authors.AuthorService;

public @Model
class AuthorBean {

	// /Model attributes
	private String firstName;
	private String lastName;	
	private String country;
	private String region;
	
	
	//Injection Point for AuthorService
	private @EJB
	AuthorService authorService;

	public String save() {
		System.out.println("Saving user...:"+this.firstName);
		authorService.addAuthor(new Author.Builder()
				.withCountry(this.country)
				.withFirstName(this.firstName).withLastName(this.lastName)
				.withRegion(this.region).build());
		return "/authors/list";
	}

	@NotNull
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		System.out.println("Seeting first name+"+firstName);
		this.firstName = firstName;
	}

	@NotNull
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	@NotNull
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

}
