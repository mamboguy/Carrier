package Model.Airfield.AirfieldMove;

import Model.Airfield.AirfieldManagerModel.IAirfieldManager;
import Model.Plane.Plane;

/**
 Created on 13 Nov 2020

 @Author - Mambo */

public class AirfieldMove_Allow
		implements IAirfieldMove {

	@Override
	public boolean makeAirfieldManagerCheck(IAirfieldManager manager, Plane plane) {
		return true;
	}

	@Override
	public void movementExecuted(IAirfieldManager manager) {
		//Do nothing
	}
}
