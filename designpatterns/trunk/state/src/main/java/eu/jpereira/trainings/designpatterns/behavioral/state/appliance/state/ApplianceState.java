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
package eu.jpereira.trainings.designpatterns.behavioral.state.appliance.state;

/**
 * @author jpereira
 * 
 * TODO Exercise: Complete the steps in this file
 */
public enum ApplianceState {
	
	
	//TODO: Comment the following definitions 
	OFF, ON, STOPPED, STARTED, UNKNOW;
	
	//TODO: Uncomment the following block of code
	/*
	
	
	OFF {
		public ApplianceStateBehavior getStateBehavior() {
			return new OffState();
		}
	},
	ON {
		public ApplianceStateBehavior getStateBehavior() {
			return new OnState();
		}
	},
	STOPPED {
		public ApplianceStateBehavior getStateBehavior() {
			return new StoppedState();
		}
	},
	STARTED {
		public ApplianceStateBehavior getStateBehavior() {
			return new StartedState();
		}
	},
	UNKNOW {
		public ApplianceStateBehavior getStateBehavior() {
			return new UnknowState();
		}
	};
   */
	/**
	 * Default
	 * @return
	 */
	public ApplianceStateBehavior getStateBehavior() {
		return null;
	}

}
