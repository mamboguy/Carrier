package Model.Airfield;

import Model.Airfield.AirfieldManagerModel.IAirfieldManager;
import Model.Airfield.PlaneLocations.PlaneLocation;
import Model.Plane.Plane;
import Model.Ships.Ship;

/**
 Created on 18 Oct 2020

 @Author - Mambo */

/**
 Airfield interface that any airfields must implement to be valid
 */
public interface IAirfield {

	/**
	 Gets the number of airplanes on the airfield's flight deck or runway
	 @return - Airplane count on runway/flight deck
	 */
	int getFlightDeckCount();

	/**
	 Sets the manager for this airfield
	 @param airfieldManager - the manager for the airfield to ask
	 */
	void setManager(IAirfieldManager airfieldManager);

	/**
	 The base call to determine if an aircraft move is both legal and to execute it
	 @param initial - The plane's starting location
	 @param desired - The plane's desired end location
	 @param plane - The plane to move
	 */
	void moveAircraft(PlaneLocation initial, PlaneLocation desired, Plane plane);

	/**
	 Determines whether or not the airfield is able to accept more aircraft onto the field
	 @return - True if aircraft are allowed
	 */
	boolean canAcceptAircraft();

	/**
	 Sets the airfield's parent ship if there is one (default is null/false)
	 @param parentShip - The parent ship of the airfield
	 */
	void setParentShip(Ship parentShip);
}
