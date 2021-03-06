/**
 *  Catroid: An on-device visual programming system for Android devices
 *  Copyright (C) 2010-2013 The Catrobat Team
 *  (<http://developer.catrobat.org/credits>)
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation, either version 3 of the
 *  License, or (at your option) any later version.
 *  
 *  An additional term exception under section 7 of the GNU Affero
 *  General Public License, version 3, is available at
 *  http://developer.catrobat.org/license_additional_term
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Affero General Public License for more details.
 *  
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.catrobat.catroid.content.bricks;

import org.catrobat.catroid.formulaeditor.Formula;

public class LegoNxtMotorTurnAngleBrick extends BrickBaseType{
	private static final long serialVersionUID = 1L;

	private String motor;
	private Formula degrees;
	
	public LegoNxtMotorTurnAngleBrick() {
		super();
		motor = "";
		degrees = new Formula();
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public Formula getDegrees() {
		return degrees;
	}

	public void setDegrees(Formula degrees) {
		this.degrees = degrees;
	}

	public boolean equals(Object arg) {
		return ((arg instanceof LegoNxtMotorTurnAngleBrick) &&
				motor.equals(((LegoNxtMotorTurnAngleBrick)arg).motor) &&
				degrees.equals(((LegoNxtMotorTurnAngleBrick)arg).degrees));
	}
	
	public String toString() {
		return ("NXT turn motor \"" + motor + "\" to (" + degrees.toString() + ") degrees\r\n");
	}
}
