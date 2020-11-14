package Model.Airfield.PlaneLocations;

import Model.Airfield.AirfieldMove.AirfieldMove_Allow;
import Model.Airfield.AirfieldMove.AirfieldMove_Disallow;
import Model.Airfield.AirfieldMove.IAirfieldMove;

/**
 Created on 24 Oct 2020

 @Author - Mambo */

public class PlaneLocation_CAP
		extends PlaneLocation{

	public PlaneLocation_CAP(int maxCapacity) {
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
