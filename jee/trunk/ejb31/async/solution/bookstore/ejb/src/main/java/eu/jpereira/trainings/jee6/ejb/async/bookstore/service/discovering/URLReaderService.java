package eu.jpereira.trainings.jee6.ejb.async.bookstore.service.discovering;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class URLReaderService {

	public String[] getURLContents(String location) throws Exception {
		//This four calls are only used to simulate a long method call
		getURLContents(new URL(location));
		getURLContents(new URL(location));
		getURLContents(new URL(location));
		getURLContents(new URL(location));
		//This call will get a txt file that we will parse
		return getURLContents(new URL(
				"http://jpereira.eu/wp-content/uploads/2011/06/authorslist.txt"));

	}

	private String[] getURLContents(URL url) throws Exception {
		List<String> tmpList = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			tmpList.add(inputLine);
			System.out.println(inputLine);
		}
			
		in.close();
		return tmpList.toArray(new String[tmpList.size()]);
	}
}
