package Model.Airfield.PlaneLocations;

import Model.Airfield.AirfieldMoveType;

/**
 Created on 23 Oct 2020

 @Author - Mambo */

public class PlaneLocation_FltDeckReady
		extends PlaneLocation {

	public PlaneLocation_FltDeckReady() {
		super(50);
	}

	@Override
	public AirfieldMoveType getMoveType(PlaneLocation location) {
		if (location instanceof PlaneLocation_Hangar || location instanceof PlaneLocation_Servicing){
			return AirfieldMoveType.Lower;
		} else if (location instanceof PlaneLocation_AirStrike || location instanceof PlaneLocation_SearchTrack || location instanceof PlaneLocation_CAP){
			return AirfieldMoveType.Launch;
		}

		return AirfieldMoveType.Disallow;
	}
}
