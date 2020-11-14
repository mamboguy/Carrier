package Model.Airfield.PlaneLocations;

import Model.Airfield.AirfieldMove.AirfieldMove_Disallow;
import Model.Airfield.AirfieldMove.AirfieldMove_Lower;
import Model.Airfield.AirfieldMove.IAirfieldMove;

/**
 Created on 23 Oct 2020

 @Author - Mambo */

public class PlaneLocation_FltDeckUnready
		extends PlaneLocation {

	public PlaneLocation_FltDeckUnready() {
		super(50);
	}

	@Override
	public IAirfieldMove getMoveType(PlaneLocation location) {
		if (location instanceof PlaneLocation_Hangar){
			return new AirfieldMove_Lower();
		}

		return new AirfieldMove_Disallow();
	}
}
