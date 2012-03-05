package pt.training.jee6.projectmngt.service;

import java.util.Collection;

import pt.training.jee6.projectmngt.exception.ApplicationException;
import pt.training.jee6.projectmngt.model.Customer;
import pt.training.jee6.projectmngt.model.Document;
import pt.training.jee6.projectmngt.model.Employee;
import pt.training.jee6.projectmngt.model.Project;

/**
 * @author joaomiguel.pereira@gmail.com
 */
public interface ProjectService extends ProjectMngtService<Project>{

	
	public Collection<Employee> getEmployees(Long projectId) throws ApplicationException;
	public void removeEmployee(Long projectId, Employee employee) throws ApplicationException;
	public void addEmployee(Long projectId, Employee employee) throws ApplicationException;
	
	public void setCustomer(Long projectId, Customer customer) throws ApplicationException;
	public Customer getCustomer(Long projectId) throws ApplicationException;
	
	public Collection<Document> getDocuments( Long projectId) throws ApplicationException;
	public Document findDocument(Long projectId, Long documentId) throws ApplicationException;
	public void removeDocument(Long projectId, Long documentId) throws ApplicationException;
	public Document createDocument(Long projectId,Document documentNewInstance) throws ApplicationException;
	public Document updateDocument(Long projectId, Document documentDetachedInstance) throws ApplicationException;
	
	
	
	
	
}
