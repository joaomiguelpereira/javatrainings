package eu.jpereira.trainings.designpatterns.creational.builder;

import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;

public class HTMLReportBody implements ReportBody {

	private StringBuffer delegate = new StringBuffer();

	@Override
	public Object getAsString() {
		return this.delegate .toString();
	}

	public void putContent(Object content) {
		this.delegate.append(content);
		
	}

}
