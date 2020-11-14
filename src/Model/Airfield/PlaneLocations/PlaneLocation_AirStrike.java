package Model.Airfield.PlaneLocations;

import Model.Airfield.AirfieldMove.AirfieldMove_Allow;
import Model.Airfield.AirfieldMove.AirfieldMove_Disallow;
import Model.Airfield.AirfieldMove.IAirfieldMove;

/**
 Created on 24 Oct 2020

 @Author - Mambo */

// TODO: 2020-11-13 Remove from the PlaneLocation package and add to the AirStrike package

public class PlaneLocation_AirStrike extends PlaneLocation {

	public PlaneLocation_AirStrike(int maxCapacity) {
		super(100);
	}

	@Override
	public IAirfieldMove getMoveType(PlaneLocation location) {
		if (location instanceof PlaneLocation_LandingBox){
			return new AirfieldMove_Allow();
		}

		return new AirfieldMove_Disallow();
	}
}
