package pt.training.jee6.projectmngt.rest.resource;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pt.training.jee6.projectmngt.model.Project;

/**
 * @author joaomiguel.pereira@gmail.com
 */
@XmlRootElement(name = "project")
public class ProjectResource implements RestResource{

	private Long id;

	private String name;
	private Date startDate;
	private Date endDate;
	private Long price;

	// Must Have a default constructor
	public ProjectResource() {

	}

	public ProjectResource(Project project) {
		this.id = project.getId();
		this.name = project.getName();
		this.startDate = project.getStartDate();
		this.endDate = project.getEndDate();
		this.price = project.getPrice();
	}

	@XmlElement
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@XmlElement
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@XmlElement
	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement
	public Long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	public Project toProject() {
		Project project = new Project();
		project.setId(this.getId());
		project.setName(this.getName());
		project.setPrice(this.price);
		project.setStartDate(this.startDate);
		project.setEndDate(this.endDate);
		return project;
	}

}
