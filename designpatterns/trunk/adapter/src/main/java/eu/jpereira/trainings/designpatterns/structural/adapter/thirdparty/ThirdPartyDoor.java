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
package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;



/**
 * @author jpereira
 *
 */
public class ThirdPartyDoor {

	public enum LockStatus {
		LOCKED, UNLOCKED;
	}
	public enum DoorState {
		OPEN, CLOSED;
	}
	public static final String DEFAULT_CODE ="AAAAHHHH";
	private String code = DEFAULT_CODE;
	private LockStatus lockStatus = LockStatus.LOCKED;
	private DoorState doorState = DoorState.CLOSED;

	
	/**
	 * Before you can use this instance, you unlock the door
	 * @param usedCode
	 */
	public void unlock(String code) throws CannotUnlockDoorException {
		if ( code.equals(this.code)) {
			lockStatus = LockStatus.UNLOCKED;
		} else {
			throw new CannotUnlockDoorException();
		}
	}


	/**
	 * @return
	 */
	public LockStatus getLockStatus() {
		
		return this.lockStatus;
	}


	/**
	 * @return
	 */
	public DoorState getState() {
		return this.doorState;
	}


	/**
	 * @param state
	 */
	public void setState(DoorState state) throws CannotChangeStateOfLockedDoor {
		if ( this.lockStatus.equals(LockStatus.LOCKED)) {
			throw new CannotChangeStateOfLockedDoor();
		}
		this.doorState = state;
		
	}


	/**
	 * 
	 */
	public void lock() {
		this.lockStatus = LockStatus.LOCKED;
		
	}


	/**
	 * @param newCode
	 * @throws CannotChangeCodeForUnlockedDoor 
	 */
	public void setNewLockCode(String newCode) throws CannotChangeCodeForUnlockedDoor {
		if (this.lockStatus.equals(LockStatus.LOCKED)) {
			throw new CannotChangeCodeForUnlockedDoor();
		}
		this.code = newCode;
		
	}
	
	
	
	
	
	
	
	

}
