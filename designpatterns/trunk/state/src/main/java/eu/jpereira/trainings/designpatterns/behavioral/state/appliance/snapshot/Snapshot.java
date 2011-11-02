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
package eu.jpereira.trainings.designpatterns.behavioral.state.appliance.snapshot;

/**
 * This Snapshot interface marks an object as a Snapshot. Create specialized
 * snapshots inside the package of Originator. Only the Originator can have
 * access to it's memento, so make every of a specialized {@link Snapshot}
 * method visible only to the package
 * 
 * @author jpereira
 * 
 */
public interface Snapshot {

}
