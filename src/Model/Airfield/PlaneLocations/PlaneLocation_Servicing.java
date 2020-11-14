package Model.Airfield.PlaneLocations;

import Model.Airfield.AirfieldMove.AirfieldMove_Allow;
import Model.Airfield.AirfieldMove.AirfieldMove_Disallow;
import Model.Airfield.AirfieldMove.AirfieldMove_Raise;
import Model.Airfield.AirfieldMove.IAirfieldMove;

/**
 Created on 23 Oct 2020

 @Author - Mambo */

public class PlaneLocation_Servicing
		extends PlaneLocation {

	public PlaneLocation_Servicing() {
		super(8);
	}

	@Override
	public IAirfieldMove getMoveType(PlaneLocation location) {
		if (location instanceof PlaneLocation_Hangar){
			return new AirfieldMove_Allow();
		} else if (location instanceof PlaneLocation_FltDeckReady){
			return new AirfieldMove_Raise();
		}

		return new AirfieldMove_Disallow();
	}
}
