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
package eu.jpereira.trainings.designpatterns.behavioral.strategy.appliance.state;

import eu.jpereira.trainings.designpatterns.behavioral.strategy.appliance.communication.CommunicationStrategy;

/**
 * @author jpereira
 * 
 * 
 */
public enum ApplianceState {
	
	
	
	
	OFF {
		public ApplianceStateBehavior getStateBehavior(CommunicationStrategy strategy) {
			return new OffState(strategy);
		}
	},
	ON {
		public ApplianceStateBehavior getStateBehavior(CommunicationStrategy strategy) {
			return new OnState(strategy);
		}
	},
	STOPPED {
		public ApplianceStateBehavior getStateBehavior(CommunicationStrategy strategy) {
			return new StoppedState(strategy);
		}
	},
	STARTED {
		public ApplianceStateBehavior getStateBehavior(CommunicationStrategy strategy) {
			return new StartedState(strategy);
		}
	},
	UNKNOW {
		public ApplianceStateBehavior getStateBehavior(CommunicationStrategy strategy) {
			return new UnknowState(strategy);
		}
	};
	/**
	 * Default
	 * @return
	 */
	public ApplianceStateBehavior getStateBehavior(CommunicationStrategy strategy) {
		return null;
	}

}
