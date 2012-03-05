package pt.training.jee6.projectmngt.service.beans;

import java.util.Collection;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.training.jee6.projectmngt.exception.ApplicationException;
import pt.training.jee6.projectmngt.model.Customer;
import pt.training.jee6.projectmngt.model.Document;
import pt.training.jee6.projectmngt.model.Employee;
import pt.training.jee6.projectmngt.model.Project;
import pt.training.jee6.projectmngt.service.ProjectService;

/**
 * @author joaomiguel.pereira@gmail.com
 */
@Stateless
@Local(value = ProjectService.class)
public class ProjectServiceBean implements ProjectService {

	@PersistenceContext(name = "projectmngtPU")
	EntityManager em;

	@Override
	public Project create(Project newInstance) throws ApplicationException {
		em.persist(newInstance);
		// is now managed
		return newInstance;
	}

	@Override
	public Project update(Project detachedInstance) throws ApplicationException {

		Project updatedProject = em.merge(detachedInstance);
		return updatedProject;
	}

	@Override
	public Project findById(Long id) throws ApplicationException {
		return em.find(Project.class, id);
	}

	@Override
	public void remove(Long id) throws ApplicationException {
		Project project = em.find(Project.class, id);
		if (project != null) {
			em.remove(project);
		} else {
			throw new ApplicationException("Could not find Project with id "
					+ id);
		}

	}

	@Override
	public Collection<Project> findAll() throws ApplicationException {
		return em.createNamedQuery("Project.findAll", Project.class)
				.getResultList();
	}

	@Override
	public Collection<Employee> getEmployees(Long projectId)
			throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeEmployee(Long projectId, Employee employee)
			throws ApplicationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEmployee(Long projectId, Employee employee)
			throws ApplicationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCustomer(Long projectId, Customer customer)
			throws ApplicationException {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer getCustomer(Long projectId) throws ApplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Document> getDocuments(Long projectId)
			throws ApplicationException {
		return em.createNamedQuery("Document.findForClient")
				.setParameter(1, projectId).getResultList();
	}

	@Override
	public Document findDocument(Long projectId, Long documentId)
			throws ApplicationException {
		Document document = em.find(Document.class, documentId);
		Project project = em.find(Project.class, projectId);

		if (document != null && project != null) {
			if (!project.getDocuments().contains(document)) {
				throw new ApplicationException("The Project " + projectId
						+ " does not contains a document with id: "
						+ documentId);
			}
		} else {
			throw new ApplicationException(
					document == null ? "The Document with ID " + documentId
							+ " was not found" : "The Project with id "
							+ projectId + " was not found");
		}

		return document;
	}

	@Override
	public void removeDocument(Long projectId, Long documentId)
			throws ApplicationException {
		// Find the document
		Document document = em.find(Document.class, documentId);
		Project project = em.find(Project.class, projectId);
		if (document != null && project != null) {
			if (project.getDocuments().contains(document)) {
				project.getDocuments().remove(document);
				em.remove(document);

			} else {
				throw new ApplicationException("The Project " + projectId
						+ " does not contains a document with id: "
						+ documentId);
			}
		} else {
			throw new ApplicationException(
					document == null ? "The Document with ID " + documentId
							+ " was not found" : "The Project with id "
							+ projectId + " was not found");
		}

	}

	@Override
	public Document createDocument(Long projectId, Document documentNewInstance)
			throws ApplicationException {

		// find the project
		Project project = em.find(Project.class, projectId);
		if (project != null) {
			em.persist(documentNewInstance);
			project.addDocument(documentNewInstance);
		} else {
			throw new ApplicationException("Could not find Project with ID: "
					+ projectId);
		}
		// Now is managed
		return documentNewInstance;

	}

	@Override
	public Document updateDocument(Long projectId,
			Document documentDetachedInstance) throws ApplicationException {
		// must verify if the document really belongs to the project
		Project project = em.find(Project.class, projectId);
		Document document = em.find(Document.class,
				documentDetachedInstance.getId());
		if (project != null && document != null) {
			if (project.getDocuments().contains(document)) {
				document = em.merge(documentDetachedInstance);
			} else {
				throw new ApplicationException("The Project " + projectId
						+ " does not contains a document with id: "
						+ documentDetachedInstance.getId());
			}

		} else {
			throw new ApplicationException(
					document == null ? "The Document with ID "
							+ documentDetachedInstance.getId()
							+ " was not found" : "The Project with id "
							+ projectId + " was not found");
		}

		return document;
	}

}
