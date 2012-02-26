package eu.jpereira.trainings.jee.persistence.model.items;


//TODO: The state of this object should be persisted in the same table as client objects. Make this class embeddable
public class ItemDimensions {

	private Integer weigth;
	private Integer width;
	private Integer height;

	public Integer getWeigth() {
		return weigth;
	}

	public void setWeigth(Integer weigth) {
		this.weigth = weigth;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public static class Builder {
		private ItemDimensions instance;

		public Builder() {
			this.instance = new ItemDimensions();
		}

		public Builder withWeigth(Integer weight) {
			this.instance.weigth = weight;
			return this;
		}

		public Builder withWidth(Integer width) {
			this.instance.width = width;
			return this;
		}

		public Builder withHeight(Integer height) {
			this.instance.height = height;
			return this;
		}

		public ItemDimensions buil() {
			ItemDimensions newDimensions = this.instance;
			this.instance = new ItemDimensions();
			return newDimensions;
		}
	}
}
