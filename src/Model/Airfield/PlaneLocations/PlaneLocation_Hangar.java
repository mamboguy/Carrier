package Model.Airfield.PlaneLocations;

import Model.Airfield.AirfieldMove.AirfieldMove_Allow;
import Model.Airfield.AirfieldMove.AirfieldMove_Disallow;
import Model.Airfield.AirfieldMove.AirfieldMove_Raise;
import Model.Airfield.AirfieldMove.IAirfieldMove;

/**
 Created on 23 Oct 2020

 @Author - Mambo */

public class PlaneLocation_Hangar extends PlaneLocation {

	public PlaneLocation_Hangar(int maxCapacity) {
		super(maxCapacity);
	}

	@Override
	public IAirfieldMove getMoveType(PlaneLocation location) {
		if (location instanceof PlaneLocation_FltDeckUnready){
			return new AirfieldMove_Raise();
		} else if (location instanceof PlaneLocation_Servicing){

			//If the move is to servicing, check if it can accept more planes before allowing
			if (location.canAcceptMore()){
				return new AirfieldMove_Allow();
			}
		}

		return new AirfieldMove_Disallow();
	}
}
