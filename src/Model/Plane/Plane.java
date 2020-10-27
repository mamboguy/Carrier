package Model.Plane;

import Model.Plane.MovementModels.IPlaneMoveModel;
import Model.Plane.MovementModels.StandardMovement;

/**
 Created on 04 Aug 2020

 @Author - Mambo */

public class Plane {

	//Combat stats
	private boolean isCombatReady;
	private boolean willBeDestroyed;

	//Endurance stats
	private boolean isAloft;
	private int currentTimeAloft;

	//Movement stats
	private IPlaneMoveModel moveModel;

	//Attribute stats
	private PlaneType planeType;
	//private BasingType basingType; //Land vs Sea

	public Plane(PlaneType planeType/*, BasingType basingType*/) {
		this.isAloft = false;
		this.isCombatReady = false;
		this.willBeDestroyed = false;

		this.planeType = planeType;
		this.moveModel = new StandardMovement();
		//this.basingType = basingType;
	}

	public boolean allowCAP() {
		return planeType.allowCAP();
	}

	public double getCAPContribution() {
		return planeType.getCapContribution();
	}

	/*
	public boolean isBasingType(BasingType type) {
		return basingType == type;
	}
	 */
}
