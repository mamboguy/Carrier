package Model.Airfield;

import Model.Airfield.AirfieldManagerModel.IAirfieldManager;
import Model.Airfield.PlaneLocations.*;

/**
 Created on 18 Oct 2020

 @Author - Mambo */

public class Airfield implements IAirfield{

	private PlaneLocation hangar;
	private PlaneLocation servicing;
	private PlaneLocation flightDeckUnready;
	private PlaneLocation flightDeckReady;
	private PlaneLocation landingBox;

	private IAirfieldManager manager;

	public Airfield(int hangarCapacity){
		hangar = new PlaneLocation_Hangar(hangarCapacity);
		servicing = new PlaneLocation_Servicing();
		flightDeckUnready = new PlaneLocation_FltDeckUnready();
		flightDeckReady = new PlaneLocation_FltDeckReady();
		landingBox = new PlaneLocation_LandingBox();
	}

	public void setManager(IAirfieldManager manager){
		this.manager = manager;
	}

	public int getFlightDeckCount() {
		return flightDeckReady.planeCount() + flightDeckUnready.planeCount();
	}
}
