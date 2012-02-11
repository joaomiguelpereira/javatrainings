package eu.jpereira.trainings.jee.clientview.bookstore.model;

import java.io.Serializable;
import java.util.Date;

public class Author implements Serializable {

	private static final long serialVersionUID = 7247188073043578133L;
	
	///Model attributes
	private String firstName;
	private String lastName;
	private Date bornDate;
	private Date deathDate;
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

	

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
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
		
		public Builder withDeathDate(Date deathDate) {
			this.author.deathDate = deathDate;
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
		public Builder withBornDate(Date bornData) {
			this.author.bornDate = bornData;
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
