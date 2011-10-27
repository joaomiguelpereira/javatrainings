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
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

/**
 * 
 * Just care about the propertie
 * 
 * @author jpereira
 * 
 */
public class FakeServletResponse implements ServletResponse {

	private PrintWriter currentPrinterWriter;
	private ServletOutputStream currentOutputStream;

	public FakeServletResponse() {
		this.currentPrinterWriter = createPrinterWriter();
		this.currentOutputStream = createServletOutputStream();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletResponse#getOutputStream()
	 */
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		//Return some fake
		return this.currentOutputStream;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletResponse#getCharacterEncoding()
	 */
	@Override
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletResponse#getContentType()
	 */
	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletResponse#getWriter()
	 */
	@Override
	public PrintWriter getWriter() throws IOException {

		return this.currentPrinterWriter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletResponse#setCharacterEncoding(java.lang.String)
	 */
	@Override
	public void setCharacterEncoding(String charset) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletResponse#setContentLength(int)
	 */
	@Override
	public void setContentLength(int len) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletResponse#setContentType(java.lang.String)
	 */
	@Override
	public void setContentType(String type) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletResponse#setBufferSize(int)
	 */
	@Override
	public void setBufferSize(int size) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletResponse#getBufferSize()
	 */
	@Override
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletResponse#flushBuffer()
	 */
	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletResponse#resetBuffer()
	 */
	@Override
	public void resetBuffer() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletResponse#isCommitted()
	 */
	@Override
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletResponse#reset()
	 */
	@Override
	public void reset() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletResponse#setLocale(java.util.Locale)
	 */
	@Override
	public void setLocale(Locale loc) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletResponse#getLocale()
	 */
	@Override
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return
	 */
	private ServletOutputStream createServletOutputStream() {

		return new FakeServletOutputStream();
	}

	/**
	 * Factory method for Printer Writer
	 * 
	 * @return
	 */
	protected PrintWriter createPrinterWriter() {
		return new PrintWriter(System.out);
	}

}
