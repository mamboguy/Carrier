package Model.Ships;

import Model.Airfield.IAirfield;
import Model.Ships.DamageAndRepairModels.IDamageModel;

/**
 Created on 02 Aug 2020

 @Author - Mambo */

public class Ship {

	//Common variables across all ships
	private final Ship_Type type;
	private final String shipName;

	private int aaValue;
	private int bombardmentValue;
	private int airValue;

	//Specific behaviors for different ships
	private IDamageModel damageModel;
	private IAirfield airfieldModel;

	public Ship(Ship_Type type, int aaValue, int maximumHP, int bombardmentValue, String name) {
		this.type = type;
		this.aaValue = aaValue;
		this.bombardmentValue = bombardmentValue;
		this.shipName = name;
	}

	public void setDamageModel(IDamageModel damageModel){
		this.damageModel = damageModel;
	}

	public void setAirfieldModel(IAirfield airfieldModel) {
		this.airfieldModel = airfieldModel;
	}

	public IAirfield getAirfieldModel() {
		return airfieldModel;
	}

	public void setAirValue(int airValue){
		this.airValue = airValue;
	}

	public String getShipName() {
		return shipName;
	}

	// <editor-fold defaultstate="collapsed" desc="Ship Type Properties">
	public int getHeavyDamagePoints() {
		return type.getHeavyDmgPts();
	}

	public int getSunkDamagePoints() {
		return type.getSunkDmgPoints();
	}

	public int getPurchaseCost() {
		return type.getPurchaseCost();
	}

	public String getShipTypeName() {
		return type.getName();
	}

	public String getShortTypeName() {
		return type.getShortName();
	}

	public int getAirValue(){
		return this.airValue;
	}
	// </editor-fold>

	// <editor-fold defaultstate="collapsed" desc="Damage Modeling">

	public IDamageModel getDamageModel() {
		return damageModel;
	}

	/**
	 Applies damage to a ship

	 @param numberOfHits - The amount of hp to reduce the ship by
	 */
	public void applyDamage(int numberOfHits) {
		//A single hit will always reduce AA and Bombardment values by 1
		aaValue -= numberOfHits;
		bombardmentValue -= numberOfHits;

		//Ensure that aa and bombardment are never negative
		if (aaValue < 0) {
			aaValue = 0;
		}
		if (bombardmentValue < 0) {
			bombardmentValue = 0;
		}

		//Apply to the ship's damage model
		damageModel.applyDamage(numberOfHits);
	}

	public int currentHP() {
		return damageModel.getCurrentHP();
	}

	public boolean isHeavilyDamaged() {
		return damageModel.isHeavilyDamaged();
	}

	public boolean isLightlyDamaged() {
		return damageModel.isLightlyDamaged();
	}

	public boolean isMediumDamaged() {
		return damageModel.isMediumDamaged();
	}

	public boolean isDeadInWater() {
		return damageModel.isDeadInWater();
	}

	public boolean isSunk() {
		return damageModel.isSunk();
	}
	// </editor-fold>
}
