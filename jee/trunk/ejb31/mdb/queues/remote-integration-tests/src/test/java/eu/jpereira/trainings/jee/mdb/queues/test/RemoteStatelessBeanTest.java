package eu.jpereira.trainings.jee.mdb.queues.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.naming.NamingException;

import org.junit.Ignore;

@Ignore
public class RemoteStatelessBeanTest<V, B> extends RemoteEJBTest {

	protected V beanInstance() throws NamingException {
		Class<V> viewClass = getParameterizedViewClass();
		Class<B> beanClass = getParameterizedBeanClass();
		return getStatelessSessionBeanReferenceFor(viewClass, beanClass);

	}

	private Class getType(int index) {
		ParameterizedType pType = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		Type[] types = pType.getActualTypeArguments();
		Class type = (Class) types[index];
		return type;

	}

	private Class<B> getParameterizedBeanClass() {
		return (Class<B>) getType(1);

	}

	private Class<V> getParameterizedViewClass() {
		return (Class<V>) getType(0);
	}
}
