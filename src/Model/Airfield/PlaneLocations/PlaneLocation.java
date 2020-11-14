package Model.Airfield.PlaneLocations;

import Model.Airfield.AirfieldMove.IAirfieldMove;
import Model.Plane.Plane;
import Model.Plane.PlaneList;

/**
 Created on 19 Oct 2020

 @Author - Mambo */

public abstract class PlaneLocation {

	private PlaneList planeList;
	private int maxCapacity;

	public PlaneLocation(int maxCapacity){
		planeList = new PlaneList();
		this.maxCapacity = maxCapacity;
	}

	public PlaneList getPlaneList() {
		return planeList;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public boolean canAcceptMore(){
		return planeList.size() < maxCapacity;
	}

	public int planeCount() {
		return planeList.size();
	}

	public void addPlane(Plane plane) {
		planeList.add(plane);
	}

	public void removePlane(Plane plane){
		planeList.remove(plane);
	}

	public abstract IAirfieldMove getMoveType(PlaneLocation location);
}
