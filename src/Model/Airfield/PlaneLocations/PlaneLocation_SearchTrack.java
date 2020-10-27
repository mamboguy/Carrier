package Model.Airfield.PlaneLocations;

import Model.Airfield.AirfieldMoveType;

/**
 Created on 24 Oct 2020

 @Author - Mambo */

public class PlaneLocation_SearchTrack
		extends PlaneLocation{

	public PlaneLocation_SearchTrack(int maxCapacity) {
		super(100);
	}

	@Override
	public AirfieldMoveType getMoveType(PlaneLocation location) {
		//Search track will automatically move the planes along
		return AirfieldMoveType.Disallow;
	}
}
