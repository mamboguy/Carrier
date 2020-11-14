package Model.Airfield.AirfieldManagerModel;

import Model.Airfield.IAirfield;

/**
 Created on 19 Oct 2020

 @Author - Mambo */

public abstract class AirfieldManager implements IAirfieldManager{

	protected int launchCount;
	protected int landCount;
	protected int raiseCount;
	protected int lowerCount;

	protected IAirfield parent;

	public AirfieldManager(IAirfield airfield){
		this.parent = airfield;
	}

	public void addLanding() {
		landCount++;
	}

	public void addLaunch() {
		launchCount++;
	}

	public void addRaise() {
		raiseCount++;
	}

	public void addLower() {
		lowerCount++;
	}
}
