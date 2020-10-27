package Model.Airfield.PlaneLocations;

import Model.Airfield.AirfieldMoveType;

/**
 Created on 23 Oct 2020

 @Author - Mambo */

public class PlaneLocation_Hangar extends PlaneLocation {

	public PlaneLocation_Hangar(int maxCapacity) {
		super(maxCapacity);
	}

	@Override
	public AirfieldMoveType getMoveType(PlaneLocation location) {
		if (location instanceof PlaneLocation_FltDeckUnready){
			return AirfieldMoveType.Raise;
		} else if (location instanceof PlaneLocation_Servicing){
			return AirfieldMoveType.Allow;
		}

		return AirfieldMoveType.Disallow;
	}
}
