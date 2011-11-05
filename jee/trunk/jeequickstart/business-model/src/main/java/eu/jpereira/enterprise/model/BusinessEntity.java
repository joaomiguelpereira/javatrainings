/**
 * Copyright 2011 Joao Pereira - http://jpereira.eu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */   
package eu.jpereira.enterprise.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A Generic BusinessEntity. Mapped with JPA2.0
 * @author jpereira
 */
@Entity
public class BusinessEntity implements Serializable {

	private static final long serialVersionUID = 6380812072520100377L;

	/**
	 * The identifier of the entity
	 */
	@SuppressWarnings("unused")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * Name of the business entity
	 */
	private String name;

	/**
	 * Setter for name property
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for name property
	 * @return
	 */
	public String getName() {
		return name;
	}

}
