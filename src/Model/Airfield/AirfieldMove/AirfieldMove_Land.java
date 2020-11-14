package Model.Airfield.AirfieldMove;

import Model.Airfield.AirfieldManagerModel.IAirfieldManager;
import Model.Plane.Plane;

/**
 Created on 13 Nov 2020

 @Author - Mambo */

public class AirfieldMove_Land
		implements IAirfieldMove{

	@Override
	public boolean makeAirfieldManagerCheck(IAirfieldManager manager, Plane plane) {
		return manager.allowLanding(plane);
	}

	@Override
	public void movementExecuted(IAirfieldManager manager) {
		manager.addLanding();
	}
}
