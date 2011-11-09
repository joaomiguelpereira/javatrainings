package eu.jpereira.trainings.jee6.ejb.singleton.bookstore.web.model;


import javax.ejb.EJB;
import javax.enterprise.inject.Model;

import eu.jpereira.trainings.jee6.ejb.singleton.bookstore.model.Author;
import eu.jpereira.trainings.jee6.ejb.singleton.bookstore.service.authors.AuthorService;

public @Model
class AuthorBean {

	// /Model attributes
	private String firstName;
	private String lastName;
	
	private String country;
	private String region;
	private @EJB
	AuthorService service;

	public String save() {
		System.out.println("Saving user...:"+this.firstName);
		service.addAuthor(new Author.Builder()
				.withCountry(this.country)
				.withFirstName(this.firstName).withLastName(this.lastName)
				.withRegion(this.region).build());
		return "/authors/list";
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		System.out.println("Seeting first name+"+firstName);
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
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
