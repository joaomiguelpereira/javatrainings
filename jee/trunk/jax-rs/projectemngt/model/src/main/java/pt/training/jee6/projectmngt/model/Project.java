package pt.training.jee6.projectmngt.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author joaomiguel.pereira@gmail.com
 */
@Entity
@NamedQuery(name="Project.findAll", query="select p from Project p")

public class Project extends ApplicationEntity { 

	private String name;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private Long price;
	
	@ManyToMany(mappedBy="projects")
	private Collection<Employee> employees;
	
	@OneToMany
	private Collection<Document> documents = new ArrayList<Document>();
	
	@ManyToOne
	private Customer customer;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}
	public Collection<Employee> getEmployees() {
		return employees;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void addDocument(Document document) {
		this.documents.add(document);
		
	}
	public void setDocuments(Collection<Document> documents) {
		this.documents = documents;
	}
	public Collection<Document> getDocuments() {
		return documents;
	}
	
	
	
	
	

}
