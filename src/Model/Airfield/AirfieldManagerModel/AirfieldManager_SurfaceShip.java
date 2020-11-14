package Model.Airfield.AirfieldManagerModel;

import Model.Plane.Plane;

/**
 Created on 13 Nov 2020

 @Author - Mambo */

/**
 Null pattern object that allows all ships to "act" as if they have an airfield manager, but only carriers will do anything
 */
public class AirfieldManager_SurfaceShip implements IAirfieldManager{

	@Override
	public boolean allowLanding(Plane plane) {
		return false;
	}

	@Override
	public boolean allowLaunch(Plane plane) {
		return false;
	}

	@Override
	public boolean allowRaising(Plane plane) {
		return false;
	}

	@Override
	public boolean allowLowering(Plane plane) {
		return false;
	}

	@Override
	public void addLanding() {
		//Do nothing
	}

	@Override
	public void addLaunch() {
		//Do nothing
	}

	@Override
	public void addRaise() {
		//Do nothing
	}

	@Override
	public void addLower() {
		//Do nothing
	}
}
