package Model.Airfield.AirfieldMove;

import Model.Airfield.AirfieldManagerModel.IAirfieldManager;
import Model.Plane.Plane;

/**
 Created on 13 Nov 2020

 @Author - Mambo */

public interface IAirfieldMove {

	boolean makeAirfieldManagerCheck(IAirfieldManager manager, Plane plane);

	void movementExecuted(IAirfieldManager manager);
}
