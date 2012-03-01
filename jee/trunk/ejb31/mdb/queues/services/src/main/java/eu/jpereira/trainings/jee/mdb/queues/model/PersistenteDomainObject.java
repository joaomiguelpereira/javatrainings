package eu.jpereira.trainings.jee.mdb.queues.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PersistenteDomainObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2114795376964311840L;
	private @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	public Long getId() {
		return id;
	}

	public abstract static class Builder<T> {

		protected T instance;

		protected Builder() {
			this.instance = createInstance();
		}

		protected abstract T createInstance();

		public T build() {
			T newInstance = instance;
			instance = createInstance();
			return newInstance;
		}

	}

}
