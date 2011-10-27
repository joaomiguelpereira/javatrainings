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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;

/**
 * @author jpereira
 * 
 */
public class FakeServletRequest implements ServletRequest {

	private Map<String, Object> attributes;
	private Map<String, String> parameters;
	private ServletInputStream inputStream;

	public FakeServletRequest() {
		attributes = new HashMap<String, Object>();
		this.parameters = new HashMap<String, String>();
		this.inputStream = createInputStream();
	}

	
	/**
	 * Factory method
	 * @return
	 */
	protected ServletInputStream createInputStream() {
	return new FakeServletInputStream();
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getInputStream()
	 */
	@Override
	public ServletInputStream getInputStream() throws IOException {
		return this.inputStream;
	
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getAttribute(java.lang.String)
	 */
	@Override
	public Object getAttribute(String name) {

		return this.attributes.get(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getAttributeNames()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Enumeration getAttributeNames() {
		return Collections.enumeration(this.attributes.keySet());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getCharacterEncoding()
	 */
	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#setCharacterEncoding(java.lang.String)
	 */
	@Override
	public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getContentLength()
	 */
	@Override
	public int getContentLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getContentType()
	 */
	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getParameter(java.lang.String)
	 */
	@Override
	public String getParameter(String name) {
		return this.parameters.get(name);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getParameterNames()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Enumeration getParameterNames() {
		return Collections.enumeration(this.parameters.keySet());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getParameterValues(java.lang.String)
	 */
	@Override
	public String[] getParameterValues(String name) {
		
		return this.parameters.keySet().toArray(new String[this.parameters.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getParameterMap()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Map getParameterMap() {
		
		return this.parameters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getProtocol()
	 */
	@Override
	public String getProtocol() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getScheme()
	 */
	@Override
	public String getScheme() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getServerName()
	 */
	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getServerPort()
	 */
	@Override
	public int getServerPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getReader()
	 */
	@Override
	public BufferedReader getReader() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getRemoteAddr()
	 */
	@Override
	public String getRemoteAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getRemoteHost()
	 */
	@Override
	public String getRemoteHost() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#setAttribute(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public void setAttribute(String name, Object o) {
		this.attributes.put(name, o);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#removeAttribute(java.lang.String)
	 */
	@Override
	public void removeAttribute(String name) {
		this.attributes.remove(name);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getLocale()
	 */
	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getLocales()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Enumeration getLocales() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#isSecure()
	 */
	@Override
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getRequestDispatcher(java.lang.String)
	 */
	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getRealPath(java.lang.String)
	 */
	@Override
	public String getRealPath(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getRemotePort()
	 */
	@Override
	public int getRemotePort() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getLocalName()
	 */
	@Override
	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getLocalAddr()
	 */
	@Override
	public String getLocalAddr() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletRequest#getLocalPort()
	 */
	@Override
	public int getLocalPort() {
		// TODO Auto-generated method stub
		return 0;
	}

}
