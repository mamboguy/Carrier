package Model.Ships;

import Model.Ships.DamageAndRepairModels.BasicDamageModel;
import Model.Ships.DamageAndRepairModels.CarrierDamageModel;
import Model.Ships.DamageAndRepairModels.NonCarrierDamageModel;

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
	private BasicDamageModel damageModel;

	public Ship(Ship_Type type, int aaValue, int maximumHP, int bombardmentValue, String name) {
		this.type = type;
		this.aaValue = aaValue;
		this.bombardmentValue = bombardmentValue;
		this.shipName = name;

		//Apply the appropriate models to the ship
		switch (type) {
			case Carrier:
				//If its a carrier, assign it a carrier model
				damageModel = new CarrierDamageModel(maximumHP);

				//Apply the appropriate sub-type based on the name
				((CarrierDamageModel) damageModel).generateType(name);

				break;
			//All other types get the non-carrier version
			case Battleship:
			case Cruiser_CA:
			case Cruiser_CL:
			case Cruiser_CLAA:
			case Destroyer:
			case Transport:
			default:
				damageModel = new NonCarrierDamageModel(maximumHP);
		}
	}

	//
	public Ship(Ship_Type type, int airValue, int aaValue, int hpValue, int bombardmentValue, String name) {
		this.type = type;
		this.shipName = name;
		this.aaValue = aaValue;
		this.bombardmentValue = bombardmentValue;
		this.damageModel = new NonCarrierDamageModel(hpValue);
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
