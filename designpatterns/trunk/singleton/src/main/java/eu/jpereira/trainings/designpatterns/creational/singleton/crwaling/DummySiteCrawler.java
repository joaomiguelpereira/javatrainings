/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.creational.singleton.crwaling;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 * This class is used only to simulate a long call without using thread.sleep.
 * It will open a connection to a set of sites and dump the contents
 * 
 * @author Joao Pereira
 * 
 */
public class DummySiteCrawler implements SiteCrawler{

	private Map<String, StringBuffer> urlContents;

	public DummySiteCrawler() {
		this.urlContents = createNewSiteContens();
	}

	public DummySiteCrawler withURL(String url) {
		this.urlContents.put(url, new StringBuffer());
		return this;
	}

	private void crawl(String urlString, StringBuffer targetBuffer) throws CannotCrawlException{
		try {
			URL url = new URL(urlString);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					url.openStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				targetBuffer.append(line);
			}
			reader.close();

		} catch (Exception e) {
			throw new CannotCrawlException(e);

		} 

	}

	public SiteCrawler crawl() throws CannotCrawlException {
		for (String url : this.urlContents.keySet()) {
			crawl(url, this.urlContents.get(url));
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.creational.singleton.SiteCrawler#getSiteContents()
	 */
	@Override
	public Map<String, StringBuffer> packSiteContens() {
		//return the reference and reuit for other instance
		Map<String, StringBuffer> retunrContents = this.urlContents;
		this.urlContents = createNewSiteContens();
		return retunrContents;
	}

	/**
	 * can override
	 * @return
	 */
	protected Map<String, StringBuffer> createNewSiteContens() {
		
		return new HashMap<String, StringBuffer>();
	}
}
