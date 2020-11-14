package Model.Airfield;

import Model.Airfield.AirfieldManagerModel.IAirfieldManager;
import Model.Airfield.PlaneLocations.PlaneLocation;
import Model.Plane.Plane;
import Model.Ships.Ship;

/**
 Created on 18 Oct 2020

 @Author - Mambo */

public interface IAirfield {

	int getFlightDeckCount();

	void setManager(IAirfieldManager airfieldManager);

	void moveAircraft(PlaneLocation initial, PlaneLocation desired, Plane plane);

	boolean canAcceptAircraft();

	void setParentShip(Ship parentShip);
}
