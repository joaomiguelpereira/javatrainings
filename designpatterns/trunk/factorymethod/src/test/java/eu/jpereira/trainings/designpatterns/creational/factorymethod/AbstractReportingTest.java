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
package eu.jpereira.trainings.designpatterns.creational.factorymethod;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.junit.Ignore;

import eu.jpereira.trainings.designpatterns.creational.factorymethod.ReportData;

@Ignore
public abstract class AbstractReportingTest {

	
	private SecureRandom random = new SecureRandom();
	
	
	/**
	 * Create a dummy ReportData Object
	 * @return
	 */
	protected ReportData createDummyReportData() {
		ReportData dummyReportDate = new ReportData();
		dummyReportDate.setName("Dummy "+generateRandomString());
		return dummyReportDate;
	}
	
	/**
	 * Generate an random String
	 * @return
	 */
	private String generateRandomString() {
		return new BigInteger(132, random).toString(32);
	}
	
	

}
