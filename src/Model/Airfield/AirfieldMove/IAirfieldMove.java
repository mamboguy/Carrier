package Model.Airfield.AirfieldMove;

import Model.Airfield.AirfieldManagerModel.IAirfieldManager;
import Model.Plane.Plane;

/**
 Created on 13 Nov 2020

 @Author - Mambo */

/**
 Command pattern interface for aircraft movement around the airfield
 */
public interface IAirfieldMove {

	/**
	 Determines if the airfield manager will allow the move to happen

	 @param manager - the manager to check with
	 @param plane - the plane that wants to move
	 @return - true if movement is allowed
	 */
	boolean makeAirfieldManagerCheck(IAirfieldManager manager, Plane plane);

	/**
	 Tell the airfield manager the movement was executed

	 @param manager - the manager to inform
	 */
	void movementExecuted(IAirfieldManager manager);
}
