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
package eu.jpereira.trainings.designpatterns.behavioral.chain;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.junit.Test;

import eu.jpereira.trainings.designpatterns.behavioral.chain.fakes.FakeFilterChain;
import eu.jpereira.trainings.designpatterns.behavioral.chain.fakes.FakeServlet;
import eu.jpereira.trainings.designpatterns.behavioral.chain.fakes.FakeServletOutputStream;
import eu.jpereira.trainings.designpatterns.behavioral.chain.fakes.FakeServletRequest;
import eu.jpereira.trainings.designpatterns.behavioral.chain.fakes.FakeServletResponse;

/**
 * @author jpereira
 * 
 */
public class IntegrationTest {

	@Test
	public void testNoFilters() throws IOException, ServletException {

		// Create a FilterChain
		FakeFilterChain filterChain = createFilterChain();

		// Target servlet
		Servlet targetServlet = createTargetServlet();
		filterChain.setTargetResource(targetServlet);

		// Just for demonstration, add an parameter to the request and read the
		// parameter in the response that should be a concatenation of the value
		// in first parameter with string hello
		ServletRequest request = createServletRequest();
		ServletResponse response = createServletResponse();

		request.setAttribute("name", "Joao");

		// Start the chain of filters. In this case will ony deliver the message
		// to the servlet
		filterChain.doFilter(request, response);

		FakeServletOutputStream fakeOut = (FakeServletOutputStream) response.getOutputStream();

		assertEquals("Hello Joao", fakeOut.getStringBuilder().toString());

	}

	@Test
	public void testLogging() throws IOException, ServletException {

		// Create a FilterChain
		FakeFilterChain filterChain = createFilterChain();

		// Target servlet
		Servlet targetServlet = createTargetServlet();
		filterChain.setTargetResource(targetServlet);

		// Add filters. The first added is the last to run
		filterChain.setFilters(createLogginFilter());
		filterChain.setTargetServlet(targetServlet);

		// Just for demonstration, add an parameter to the request and read the
		// parameter in the response that should be a concatenation of the value
		// in first parameter with string hello
		ServletRequest request = createServletRequest();
		ServletResponse response = createServletResponse();

		request.setAttribute("name", "Joao");

		// Start the chain of filters
		filterChain.doFilter(request, response);

		FakeServletOutputStream fakeOut = (FakeServletOutputStream) response.getOutputStream();
		//TODO: you must override the method doFilter in FakeLoggingFilter
		assertEquals("Logging: Hello Joao", fakeOut.getStringBuilder().toString());

	}

	@Test
	public void testAuthorization() throws IOException, ServletException {

		// Create a FilterChain
		FakeFilterChain filterChain = createFilterChain();

		// Target servlet
		Servlet targetServlet = createTargetServlet();
		filterChain.setTargetResource(targetServlet);

		// Add filters. The first added is the last to run
		filterChain.setFilters(createAuthorizationFilter());
		filterChain.setTargetServlet(targetServlet);

		// Just for demonstration, add an parameter to the request and read the
		// parameter in the response that should be a concatenation of the value
		// in first parameter with string hello
		ServletRequest request = createServletRequest();
		ServletResponse response = createServletResponse();

		request.setAttribute("name", "Joao");

		// Start the chain of filters
		filterChain.doFilter(request, response);

		FakeServletOutputStream fakeOut = (FakeServletOutputStream) response.getOutputStream();
		//TODO: you must override the method doFilter in FakeAuthorizationFilter
		assertEquals("Authorized: Hello Joao", fakeOut.getStringBuilder().toString());

	}

	@Test
	public void testAll() throws IOException, ServletException {

		// Create a FilterChain
		FakeFilterChain filterChain = createFilterChain();

		// Target servlet
		Servlet targetServlet = createTargetServlet();
		filterChain.setTargetResource(targetServlet);

		// Add filters. The first added is the last to run
		filterChain.setFilters(createFormatFilter());
		filterChain.setTargetServlet(targetServlet);

		// Just for demonstration, add an parameter to the request and read the
		// parameter in the response that should be a concatenation of the value
		// in first parameter with string hello
		ServletRequest request = createServletRequest();
		ServletResponse response = createServletResponse();

		request.setAttribute("name", "Joao");

		// Start the chain of filters
		filterChain.doFilter(request, response);

		FakeServletOutputStream fakeOut = (FakeServletOutputStream) response.getOutputStream();

		
		//TODO: you must override the method doFilter in FakeFormatFilter
		assertEquals("Hello Joao :Formated", fakeOut.getStringBuilder().toString());
	}

	@Test
	public void testFormat() throws IOException, ServletException {

		// Create a FilterChain
		FakeFilterChain filterChain = createFilterChain();

		// Target servlet
		Servlet targetServlet = createTargetServlet();
		filterChain.setTargetResource(targetServlet);

		// Add filters. The first added is the last to run
		filterChain.setFilters(createLogginFilter(), createAuthorizationFilter(), createFormatFilter());
		filterChain.setTargetServlet(targetServlet);

		// Just for demonstration, add an parameter to the request and read the
		// parameter in the response that should be a concatenation of the value
		// in first parameter with string hello
		ServletRequest request = createServletRequest();
		ServletResponse response = createServletResponse();

		request.setAttribute("name", "Joao");

		// Start the chain of filters
		filterChain.doFilter(request, response);

		FakeServletOutputStream fakeOut = (FakeServletOutputStream) response.getOutputStream();

		assertEquals("Logging: Authorized: Hello Joao :Formated", fakeOut.getStringBuilder().toString());
	}

	/**
	 * @return
	 */
	private ServletResponse createServletResponse() {
		return new FakeServletResponse();
	}

	/**
	 * @return
	 */
	private ServletRequest createServletRequest() {

		return new FakeServletRequest();
	}

	/**
	 * @return
	 */
	private Filter createAuthorizationFilter() {
		return null;
		// TODO: Implement FakeAuthorizationFilter that extends from
		// AbstractFilter and return a new instance of that type.
		// Uncomment the following line and create the filter.

		// return new FakeAuthorizationFilter();
	}

	/**
	 * @return
	 */
	private Filter createFormatFilter() {
		return null;
		// TODO: Implement FakeFormatFilter that extends from AbstractFilter and
		// return a new instance of that type.
		// Uncomment the following line and create the filter.
		// return new FakeFormatFilter();
	}

	/**
	 * @return
	 */
	private Filter createLogginFilter() {
		return null;
		// TODO: Implement FakeLoggingFilter that extends from AbstractFilter
		// and return a new instance of that type.
		// Uncomment the following line and create the filter.
		// return new FakeLoggingFilter();
	}

	/**
	 * @return
	 */
	private Servlet createTargetServlet() {

		return new FakeServlet();
	}

	/**
	 * @return
	 */
	private FakeFilterChain createFilterChain() {
		return new FakeFilterChain();
	}

}
