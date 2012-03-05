package pt.training.jee6.projectmngt.rest.resource;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pt.training.jee6.projectmngt.model.Document;

/**
 * 
 * @author joaomiguel.pereira@gmail.com
 * 
 */

@XmlRootElement(name = "documents")
public class ProjectDocumentListing extends AbstractResource {

	private Collection<DocumentResource> documents;

	// must have a default constructor
	public ProjectDocumentListing() {
	}

	public ProjectDocumentListing(Collection<Document> documents) {
		// transform. CAn use something like dozer http://dozer.sourceforge.net/
		this.documents = new ArrayList<DocumentResource>();

		for (Document document : documents) {
			this.documents.add(new DocumentResource(document));
		}
	}

	@XmlElement(name = "document")
	public Collection<DocumentResource> getDocuments() {
		return documents;
	}

}
