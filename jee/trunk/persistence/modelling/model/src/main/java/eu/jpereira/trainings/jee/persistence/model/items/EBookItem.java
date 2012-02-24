package eu.jpereira.trainings.jee.persistence.model.items;

import javax.persistence.Entity;

@Entity
public class EBookItem extends DigitalItem{

	private String ISBN;

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	public static class Builder extends DigitalItem.Builder<EBookItem> {

		public Builder withISBN(String isbn) {
			this.instance.ISBN = isbn;
			return this;
		}
		@Override
		protected EBookItem createInstance() {
			return new EBookItem();
		}
		
	}
}
