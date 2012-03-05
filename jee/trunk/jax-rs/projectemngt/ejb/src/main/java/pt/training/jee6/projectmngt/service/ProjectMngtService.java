package pt.training.jee6.projectmngt.service;

import java.util.Collection;

import pt.training.jee6.projectmngt.exception.ApplicationException;
import pt.training.jee6.projectmngt.model.ApplicationEntity;

/**
 * @author joaomiguel.pereira@gmail.com
 */
public interface ProjectMngtService<T extends ApplicationEntity> {
	
	public T create(T newInstance) throws ApplicationException;
	public T update(T detachedInstance) throws ApplicationException;
	public T findById(Long id) throws ApplicationException;
	public void remove(Long id) throws ApplicationException;
	public Collection<T> findAll() throws ApplicationException;

}
