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
package eu.jpereira.trainings.designpatterns.behavioral.state.mapper;

import eu.jpereira.trainings.designpatterns.behavioral.state.appliance.Appliance;
import eu.jpereira.trainings.designpatterns.behavioral.state.appliance.dao.ApplianceDAO;
import eu.jpereira.trainings.designpatterns.behavioral.state.event.ApplianceEvent;
import eu.jpereira.trainings.designpatterns.behavioral.state.event.EventData;

/**
 * This mapper just instantiate an {@link ApplianceEvent} with the correct
 * {@link Appliance}. Use this mapper before any that needs to know about the
 * source {@link Appliance}
 * 
 * @author jpereira
 * 
 */
public class ApplianceEventMapper implements EventMapper {

	private ApplianceDAO applianceDao = null;

	/**
	 * @param applianceDAO
	 */
	public ApplianceEventMapper(ApplianceDAO applianceDAO) {
		this.applianceDao = applianceDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.jpereira.trainings.designpatterns.behavioral.observer.mapper.EventMapper
	 * #doMap(eu.jpereira.trainings.designpatterns.behavioral.observer.event.
	 * EventData,
	 * eu.jpereira.trainings.designpatterns.behavioral.observer.event.
	 * ApplianceEvent,
	 * eu.jpereira.trainings.designpatterns.behavioral.observer.mapper
	 * .MapperChain)
	 */
	@Override
	public void doMap(EventData data, MapperChain chain) {
		
		
		//If event is null or event.sourceAppliance is null, create new one
		if ( data.getEvent() ==null) {

			data.setEvent( new ApplianceEvent(null));
		}
		if (data.getEvent().getSourceAppliance()==null) {
			//Find the right appliance in the DAO
			Appliance appliance = applianceDao.findByMacAddress(data.getProperty("applianceMacAddress"));
			data.getEvent().setSourceAppliance(appliance);
			
		}
		
		chain.doMap(data);

	}

}
