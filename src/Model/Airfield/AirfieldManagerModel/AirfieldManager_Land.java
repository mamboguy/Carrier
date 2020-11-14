package Model.Airfield.AirfieldManagerModel;

import Model.Airfield.IAirfield;
import Model.Plane.Plane;

/**
 Created on 13 Nov 2020

 @Author - Mambo */

public class AirfieldManager_Land extends AirfieldManager{

	public AirfieldManager_Land(IAirfield airfield) {
		super(airfield);
	}

	@Override
	public boolean allowLanding(Plane plane) {

		//Land based airfields can't land and launch more than 8 steps in a turn
		if ((landCount + launchCount) >= 8){
			return false;
		}

		//Land based airfields can't land if more than 12 steps occupy the runway
		if (parent.getFlightDeckCount() >= 12){
			return false;
		}

		//If none of these are true, allow landing
		return true;
	}

	@Override
	public boolean allowLaunch(Plane plane) {

		//Land based airfields can't launch and land more than 8 steps in a turn
		if ((launchCount + landCount) >= 8){
			return false;
		}

		//Only combat ready planes may be launched
		if (!plane.isCombatReady()){
			return false;
		}

		//If the runway has more than 12 steps on it, launching is not possible
		if (parent.getFlightDeckCount() > 12){
			return false;
		}

		// TODO: 2020-10-19 Do not allow launching on night turns

		//Allow launching
		return true;
	}

	@Override
	public boolean allowRaising(Plane plane) {
		//Land based airfields can't raise more than 8 steps in a turn
		return  (raiseCount >= 8);
	}

	@Override
	public boolean allowLowering(Plane plane) {
		//Land based airfields can't lower more than 8 steps in a turn
		return  (lowerCount >= 8);
	}
}
