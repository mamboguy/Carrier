package Model.Airfield.AirfieldManagerModel;

import Model.Plane.Plane;

/**
 Created on 19 Oct 2020

 @Author - Mambo */

/**
 An airfield manager must grant permission for all aircraft movement to happen around the airfield before
 the airfield can execute the movement
 */
public interface IAirfieldManager {

	/**
	 Determines if a single landing will be allowed
	 @param plane - The plane that wishes to land
	 @return - True if this plane can land
	 */
	boolean allowLanding(Plane plane);

	/**
	 Determines if a single takeoff will be allowed
	 @param plane - The plane that wishes to take off
	 @return - True if this plane can takeoff
	 */
	boolean allowLaunch(Plane plane);

	/**
	 Determines if a single raising will be allowed
	 @param plane - The plane that wishes to be raised
	 @return - True if this plane can be raised
	 */
	boolean allowRaising(Plane plane);

	/**
	 Determines if a single lowering will be allowed
	 @param plane - The plane that wishes to be lowered
	 @return - True if the plane can be lowered
	 */
	boolean allowLowering(Plane plane);

	/**
	 Adds a landing to the manager's count
	 */
	void addLanding();

	/**
	 Adds a takeoff to the manager's count
	 */
	void addLaunch();

	/**
	 Adds a raising to the manager's count
	 */
	void addRaise();

	/**
	 Adds a lowering to the manager's count
	 */
	void addLower();
}
