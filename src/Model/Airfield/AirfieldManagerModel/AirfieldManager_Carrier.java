package Model.Airfield.AirfieldManagerModel;

import Model.Airfield.IAirfield;
import Model.Plane.Plane;

/**
 Created on 19 Oct 2020

 @Author - Mambo */

public class AirfieldManager_Carrier
		extends AirfieldManager {

	private IAirfield parent;

	public AirfieldManager_Carrier(IAirfield airfield){
		this.parent = airfield;
	}

	@Override
	public boolean allowLanding(Plane plane) {

		//Do not allow landing if the carrier has launched this turn
		if (launchCount > 0){
			return false;
		}

		//Carriers can't land more than 8 steps in a turn
		if (landCount >= 8){
			return false;
		}

		//Carriers can't land if more than 12 steps occupy the flight deck
		if (parent.getFlightDeckCount() >= 12){
			return false;
		}

		//Carriers can't land and raise more than 12 steps in a single turn
		//Carriers can't land and lower more than 12 steps in a single turn
		//Both of these must simultaneously be true
		if (landCount + raiseCount >= 12 || landCount + lowerCount >= 12){
			return false;
		}

		//If none of these are true, allow landing
		return true;
	}

	@Override
	public boolean allowLaunch(Plane plane) {

		//Carriers can't launch the same turn as they land
		if (landCount > 0){
			return false;
		}

		//Carriers can't launch more than 8 steps in a turn
		if (launchCount >= 8){
			return false;
		}

		//Only combat ready planes may be launched
		if (!plane.isCombatReady()){
			return false;
		}

		//If the flight deck has more than 8 steps on it, launching is not possible due to too short of a runway
		if (parent.getFlightDeckCount() > 8){
			return false;
		}

		// TODO: 2020-10-19 Do not allow launching on night turns

		//Allow launching
		return true;
	}

	@Override
	public boolean allowRaising(Plane plane) {
		return false;
	}

	@Override
	public boolean allowLowering(Plane plane) {
		return false;
	}
}
