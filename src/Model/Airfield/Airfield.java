package Model.Airfield;

import Model.Airfield.AirfieldManagerModel.IAirfieldManager;
import Model.Airfield.AirfieldMove.IAirfieldMove;
import Model.Airfield.PlaneLocations.*;
import Model.Plane.Plane;
import Model.Ships.Ship;

/**
 Created on 18 Oct 2020

 @Author - Mambo */

public class Airfield implements IAirfield{

	private PlaneLocation hangar;
	private PlaneLocation servicing;
	private PlaneLocation flightDeckUnready;
	private PlaneLocation flightDeckReady;
	private PlaneLocation landingBox;

	private Ship parentShip;
	private IAirfieldManager manager;

	public Airfield(int hangarCapacity){
		hangar = new PlaneLocation_Hangar(hangarCapacity);
		servicing = new PlaneLocation_Servicing();
		flightDeckUnready = new PlaneLocation_FltDeckUnready();
		flightDeckReady = new PlaneLocation_FltDeckReady();
		landingBox = new PlaneLocation_LandingBox();
	}

	@Override
	public void setParentShip(Ship parent){
		this.parentShip = parent;
	}

	public void setManager(IAirfieldManager manager){
		this.manager = manager;
	}

	public int getFlightDeckCount() {
		return flightDeckReady.planeCount() + flightDeckUnready.planeCount();
	}

	@Override
	public void moveAircraft(PlaneLocation initial, PlaneLocation desired, Plane plane){
		//Ask the current location to generate the movement type
		IAirfieldMove moveType = initial.getMoveType(desired);

		//Ask the movement type to make the appropriate IAirfieldManager check
		if (moveType.makeAirfieldManagerCheck(manager, plane)){

			//If the movement was allowed by the airfield manager, execute it
			moveType.movementExecuted(manager);

			//Move the plane to its new location, removing from the old
			initial.removePlane(plane);
			desired.addPlane(plane);
		}
	}

	@Override
	public boolean canAcceptAircraft() {
		//If the airfield is at capacity, do not accept more
		if ((getFlightDeckCount() + servicing.planeCount() + hangar.planeCount()) < hangar.getMaxCapacity()){
			return false;
		}

		//If no parent ship, it can't accept aircraft
		//If it has a parent ship, return whether or not the damage model allows landing or launching right now
		return (parentShip != null && !parentShip.getDamageModel().canLaunchOrLandPlanes());
	}
}
