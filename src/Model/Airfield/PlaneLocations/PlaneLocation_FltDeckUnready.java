package Model.Airfield.PlaneLocations;

import Model.Airfield.AirfieldMoveType;

/**
 Created on 23 Oct 2020

 @Author - Mambo */

public class PlaneLocation_FltDeckUnready
		extends PlaneLocation {

	public PlaneLocation_FltDeckUnready() {
		super(50);
	}

	@Override
	public AirfieldMoveType getMoveType(PlaneLocation location) {
		if (location instanceof PlaneLocation_Hangar){
			return AirfieldMoveType.Lower;
		}

		return AirfieldMoveType.Disallow;
	}
}
