package Model.Airfield.AirfieldManagerModel;

import Model.Plane.Plane;

/**
 Created on 19 Oct 2020

 @Author - Mambo */

public interface IAirfieldManager {

	boolean allowLanding(Plane plane);

	boolean allowLaunch(Plane plane);

	boolean allowRaising(Plane plane);

	boolean allowLowering(Plane plane);

	void addLanding();

	void addLaunch();

	void addRaise();

	void addLower();
}
