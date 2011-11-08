package eu.jpereira.trainings.jee6.ejb.async.bookstore.model;

import java.io.Serializable;

public class Author implements Serializable {

	private static final long serialVersionUID = 7247188073043578133L;
	
	///Model attributes
	private String firstName;
	private String lastName;
	private String country;
	private String region;

	
	///
	///Getters and setters
	///
	
	
	
	/**
	 * Generate the full name for the author. firstName+ +last name
	 * @return the full name of the author
	 */
	public String getFullName() {
		return (this.firstName != null ? this.firstName : "") + " "
				+ (this.lastName != null ? this.lastName : "");
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
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

	
	/**
	 * Builder
	 * @author jee5
	 *
	 */
	public static class Builder implements Serializable{
		
		private static final long serialVersionUID = 4976602460235464615L;
		private Author author = new Author();

		public Builder withFirstName(String firstName) {
			this.author.setFirstName(firstName);
			return this;
		}
		
		
		public Builder withRegion(String region) {
			this.author.region = region;
			return this;
		}
		public Builder withCountry(String country) {
			this.author.country = country;
			return this;
		}
		public Builder withLastName(String lastName) {
			this.author.setLastName(lastName);
			return this;
		}

		public Author build() {
			return this.author;
		}
	}

}
