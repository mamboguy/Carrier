package Model.Airfield.PlaneLocations;

import Model.Airfield.AirfieldMoveType;

/**
 Created on 24 Oct 2020

 @Author - Mambo */

public class PlaneLocation_LandingBox extends PlaneLocation{

	public PlaneLocation_LandingBox() {
		super(100);
	}

	@Override
	public AirfieldMoveType getMoveType(PlaneLocation location) {
		if (location instanceof PlaneLocation_FltDeckUnready){
			return AirfieldMoveType.Land;
		} else if (location instanceof PlaneLocation_AirStrike){
			//Allow the aircraft in the landing box to move to a strike so they can transfer if the ship sinks under them
			return AirfieldMoveType.Allow;
		}

		return AirfieldMoveType.Disallow;
	}
}
