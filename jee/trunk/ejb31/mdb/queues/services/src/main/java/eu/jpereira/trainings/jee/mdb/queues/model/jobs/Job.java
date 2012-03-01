package eu.jpereira.trainings.jee.mdb.queues.model.jobs;

import java.io.Serializable;

public abstract class Job implements Serializable {

	protected Long domainObjectId;

	public Long getDomainObjectId() {
		return this.domainObjectId;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2049236689597944593L;

	public static abstract class Builder<T extends Job> {

		protected T instance;

		protected abstract T createInstance();

		public Builder() {
			this.instance = createInstance();
		}

		public Builder<T> forDomainObjectId(Long id) {
			this.instance.domainObjectId = id;
			return this;
		}

		public T build() {
			T newInstance = this.instance;
			this.instance = createInstance();
			return newInstance;
		}

	}

}
