package Model.Airfield.PlaneLocations;

import Model.Airfield.AirfieldMove.AirfieldMove_Disallow;
import Model.Airfield.AirfieldMove.IAirfieldMove;

/**
 Created on 24 Oct 2020

 @Author - Mambo */

public class PlaneLocation_SearchTrack
		extends PlaneLocation{

	public PlaneLocation_SearchTrack(int maxCapacity) {
		super(100);
	}

	@Override
	public IAirfieldMove getMoveType(PlaneLocation location) {
		//Search track will automatically move the planes along
		return new AirfieldMove_Disallow();
	}
}
