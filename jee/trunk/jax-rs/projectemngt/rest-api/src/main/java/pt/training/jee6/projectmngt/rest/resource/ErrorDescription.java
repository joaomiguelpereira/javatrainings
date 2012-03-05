package pt.training.jee6.projectmngt.rest.resource;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author joaomiguel.pereira@gmail.com
 */
@XmlRootElement(name="error")
public class ErrorDescription implements RestResource {

	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	@XmlElement
	public String getMessage() {
		return message;
	}
	
}
