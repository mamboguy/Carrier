package Model.Airfield.PlaneLocations;

import Model.Airfield.AirfieldMove.AirfieldMove_Disallow;
import Model.Airfield.AirfieldMove.AirfieldMove_Launch;
import Model.Airfield.AirfieldMove.AirfieldMove_Lower;
import Model.Airfield.AirfieldMove.IAirfieldMove;

/**
 Created on 23 Oct 2020

 @Author - Mambo */

public class PlaneLocation_FltDeckReady
		extends PlaneLocation {

	public PlaneLocation_FltDeckReady() {
		super(50);
	}

	@Override
	public IAirfieldMove getMoveType(PlaneLocation location) {
		if (location instanceof PlaneLocation_Hangar || location instanceof PlaneLocation_Servicing){
			return new AirfieldMove_Lower();
		} else if (location instanceof PlaneLocation_AirStrike || location instanceof PlaneLocation_SearchTrack || location instanceof PlaneLocation_CAP){
			return new AirfieldMove_Launch();
		}

		return new AirfieldMove_Disallow();
	}
}
