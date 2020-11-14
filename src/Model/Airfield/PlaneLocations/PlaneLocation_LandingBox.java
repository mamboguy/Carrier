package Model.Airfield.PlaneLocations;

import Model.Airfield.AirfieldMove.AirfieldMove_Allow;
import Model.Airfield.AirfieldMove.AirfieldMove_Disallow;
import Model.Airfield.AirfieldMove.AirfieldMove_Land;
import Model.Airfield.AirfieldMove.IAirfieldMove;

/**
 Created on 24 Oct 2020

 @Author - Mambo */

public class PlaneLocation_LandingBox extends PlaneLocation{

	public PlaneLocation_LandingBox() {
		super(100);
	}

	@Override
	public IAirfieldMove getMoveType(PlaneLocation location) {
		if (location instanceof PlaneLocation_FltDeckUnready){
			return new AirfieldMove_Land();
		} else if (location instanceof PlaneLocation_AirStrike){
			//Allow the aircraft in the landing box to move to a strike so they can transfer if the ship sinks under them
			return new AirfieldMove_Allow();
		}

		return new AirfieldMove_Disallow();
	}
}
