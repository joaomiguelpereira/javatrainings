package eu.jpereira.trainings.jee.persistence.model.items;


//TODO: This domain object should be mapped to the DB. Annotate with the proper annotation
public abstract class DigitalItem extends SellableItem {

	protected String downloadURL;

	public abstract static class Builder<T extends DigitalItem> extends
			SellableItem.Builder<T> {

		public Builder<T> withDownloadURL(String downloadUrl) {
			this.instance.downloadURL = downloadUrl;
			return this;
		}

	}

}
