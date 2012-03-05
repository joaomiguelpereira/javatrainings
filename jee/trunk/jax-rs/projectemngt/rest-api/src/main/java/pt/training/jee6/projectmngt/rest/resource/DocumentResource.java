package pt.training.jee6.projectmngt.rest.resource;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pt.training.jee6.projectmngt.model.Document;

/**
 * @author joaomiguel.pereira@gmail.com
 */
@XmlRootElement(name="document")
public class DocumentResource extends AbstractResource{

	private Long id;
	
	private String title;
	
	private String fileURL;

	public DocumentResource() {
		
	}
	public DocumentResource(Document document) {
		this.title = document.getTitle();
		this.id = document.getId();
		//Now is the time to build some url to the file
		this.fileURL = document.getFileURL();
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	@XmlElement
	public String getFileURL() {
		return fileURL;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Document toDocument() {
		
		Document document = new Document();
		document.setId(this.getId());
		document.setTitle(this.getTitle());
		document.setFileURL(this.getFileURL());
		return document;
	}
	
	
	
}
