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
package eu.jpereira.trainings.designpatterns.behavioral.chain.fakes;

import java.io.IOException;
import java.util.Queue;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author jpereira
 *
 */
/**
 * @author jpereira
 * 
 */
public class FakeFilterChain implements FilterChain {

	// Internal list of filters
	private Queue<Filter> filterQueue;

	private Servlet targetServlet;

	public FakeFilterChain() {
		this.filterQueue = new SimpleQueue<Filter>();

	}

	public void setTargetResource(Servlet servlet) {
		this.targetServlet = servlet;
	}

	/**
	 * Add a filter to a list. The fisrt to be added, the first to run
	 * 
	 * @param filter
	 */
	public void addFilterToChain(Filter filter) {
		this.filterQueue.offer(filter);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.FilterChain#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
		if (this.filterQueue.peek()!=null) {
			Filter filter = this.filterQueue.poll();
			filter.doFilter(request, response, this);
		} else {
			targetServlet.service(request, response);
		}

	}

	/**
	 * Create a chainOfFilters
	 * 
	 * @param filters
	 *            array of filters to apply to
	 */
	public void setFilters(Filter... filters) {

		for (Filter filter : filters) {
			this.filterQueue.offer(filter);
		}

	}

	/**
	 * @param targetServlet
	 */
	public void setTargetServlet(Servlet targetServlet) {
		this.targetServlet = targetServlet;

	}

}
