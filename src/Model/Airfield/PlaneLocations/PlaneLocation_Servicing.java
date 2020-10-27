package Model.Airfield.PlaneLocations;

import Model.Airfield.AirfieldMoveType;

/**
 Created on 23 Oct 2020

 @Author - Mambo */

public class PlaneLocation_Servicing
		extends PlaneLocation {

	public PlaneLocation_Servicing() {
		super(8);
	}

	@Override
	public AirfieldMoveType getMoveType(PlaneLocation location) {
		if (location instanceof PlaneLocation_Hangar){
			return AirfieldMoveType.Allow;
		} else if (location instanceof PlaneLocation_FltDeckReady){
			return AirfieldMoveType.Raise;
		}

		return AirfieldMoveType.Disallow;
	}
}
