package Model.Airfield.PlaneLocations;

import Model.Airfield.AirfieldMoveType;

/**
 Created on 24 Oct 2020

 @Author - Mambo */

public class PlaneLocation_CAP
		extends PlaneLocation{

	public PlaneLocation_CAP(int maxCapacity) {
		super(100);
	}

	@Override
	public AirfieldMoveType getMoveType(PlaneLocation location) {
		if (location instanceof PlaneLocation_LandingBox){
			return AirfieldMoveType.Allow;
		}

		return AirfieldMoveType.Disallow;
	}
}
