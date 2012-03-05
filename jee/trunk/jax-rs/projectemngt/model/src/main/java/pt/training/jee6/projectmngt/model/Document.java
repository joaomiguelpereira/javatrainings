package pt.training.jee6.projectmngt.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;


/**
 * @author joaomiguel.pereira@gmail.com
 */
@Entity
@NamedQuery(name="Document.findForClient", query="select p.documents from Project p where p.id=?1")
public class Document extends ApplicationEntity {
	
	private String title;
	
	
	private String fileURL;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	public String getFileURL() {
		return fileURL;
	}
	
}
