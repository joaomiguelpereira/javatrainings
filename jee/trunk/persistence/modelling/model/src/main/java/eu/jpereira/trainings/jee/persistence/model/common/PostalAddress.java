package eu.jpereira.trainings.jee.persistence.model.common;


/**
 * Ambeddable PostalAddress
 * 
 * @author jee
 * 
 */

// TODO: This object is used to be embedded in other objects. Annotate with
// proper annotation
public class PostalAddress {

	private String street;
	private String city;
	private String postalCode;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public static class Builder {
		private PostalAddress object;

		public Builder() {
			this.object = new PostalAddress();
		}

		public Builder withStreet(String street) {
			this.object.street = street;
			return this;
		}

		public Builder withCity(String city) {
			this.object.city = city;
			return this;
		}

		public Builder withPostalCode(String postalCode) {
			this.object.postalCode = postalCode;
			return this;
		}

		public PostalAddress build() {
			PostalAddress postalAddress = this.object;
			this.object = new PostalAddress();
			return postalAddress;
		}

	}

}
