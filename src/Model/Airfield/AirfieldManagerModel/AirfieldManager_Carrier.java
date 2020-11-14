package Model.Airfield.AirfieldManagerModel;

import Model.Airfield.IAirfield;
import Model.Plane.Plane;

/**
 Created on 19 Oct 2020

 @Author - Mambo */

public class AirfieldManager_Carrier
		extends AirfieldManager {

	public AirfieldManager_Carrier(IAirfield airfield){
		super(airfield);
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

		//Both of these must simultaneously be true
		//Carriers can't land and lower more than 12 steps in a single turn
		if (landCount + raiseCount >= 12 || landCount + lowerCount >= 12){
			return false;
		}

		//Carriers can't have more planes on it than its hangar capacity
		if (!parent.canAcceptAircraft()){
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
		//Carriers can't raise more than 8 steps in a turn
		if (raiseCount >= 8){
			return false;
		}

		//Carriers can't raise and launch more than 8 steps in a turn
		if (raiseCount + launchCount >= 8){
			return false;
		}

		//Carriers can't raise and land more than 12 steps in a turn
		if (raiseCount + landCount >= 12){
			return false;
		}

		return true;
	}

	@Override
	public boolean allowLowering(Plane plane) {
		//Carriers can't lower more than 8 steps in a turn
		if (lowerCount >= 8){
			return false;
		}

		//Carriers can't lower and launch more than 8 steps in a turn
		if (lowerCount + launchCount >= 8){
			return false;
		}

		//Carriers can't lower and land more than 12 steps in a turn
		if (lowerCount + landCount >= 12){
			return false;
		}

		return true;
	}
}
