package Model.Plane;

import Model.Plane.MovementModels.IPlaneMoveModel;
import Model.Plane.MovementModels.StandardMovement;

/**
 Created on 04 Aug 2020

 @Author - Mambo */

public class Plane {

	//Class variables
	private static int planeID = 0;
	private int ID;

	//Movement stats
	private IPlaneMoveModel moveModel;

	//Attribute stats
	private PlaneType planeType;
	private boolean combatReady;


	public Plane(PlaneType planeType) {
		this.ID = planeID++;
		this.planeType = planeType;
		this.moveModel = new StandardMovement();
		this.combatReady = false;
	}

	public void setCombatReady(){
		this.combatReady = true;
	}

	public void unsetCombatReady(){
		this.combatReady = false;
	}

	public boolean allowCAP() {
		return planeType.allowCAP();
	}

	public double getCAPContribution() {
		return planeType.getCapContribution();
	}

	public int getID() {
		return this.ID;
	}

	public boolean isCombatReady() {
		return combatReady;
	}
}
