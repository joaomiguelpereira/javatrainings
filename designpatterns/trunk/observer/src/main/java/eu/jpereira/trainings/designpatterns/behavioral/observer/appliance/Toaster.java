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
package eu.jpereira.trainings.designpatterns.behavioral.observer.appliance;

import eu.jpereira.trainings.designpatterns.behavioral.observer.appliance.snapshot.Snapshot;

/**
 * @author jpereira
 *
 */
public class Toaster extends AbstractAppliance {

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.observer.appliance.snapshot.Snapshotable#takeSnapshot()
	 */
	@Override
	public Snapshot takeSnapshot() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.observer.appliance.snapshot.Snapshotable#restoreFromSnapshot(eu.jpereira.trainings.designpatterns.behavioral.observer.appliance.snapshot.Snapshot)
	 */
	@Override
	public void restoreFromSnapshot(Snapshot snapshot) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.observer.appliance.Appliance#turnOn()
	 */
	@Override
	public void turnOn() throws ApplianceCommunicationException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.observer.appliance.Appliance#turnOff()
	 */
	@Override
	public void turnOff() throws ApplianceCommunicationException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.observer.appliance.Appliance#start()
	 */
	@Override
	public void start() throws ApplianceCommunicationException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see eu.jpereira.trainings.designpatterns.behavioral.observer.appliance.Appliance#stop()
	 */
	@Override
	public void stop() throws ApplianceCommunicationException {
		// TODO Auto-generated method stub

	}



}
