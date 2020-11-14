package Model.Factories;

import Model.Airfield.Airfield;
import Model.Airfield.AirfieldManagerModel.AirfieldManager_Carrier;
import Model.Airfield.AirfieldManagerModel.AirfieldManager_SurfaceShip;
import Model.Airfield.IAirfield;
import Model.Ships.DamageAndRepairModels.CarrierDamageModel;
import Model.Ships.DamageAndRepairModels.IDamageModel;
import Model.Ships.DamageAndRepairModels.NonCarrierDamageModel;
import Model.Ships.Ship;
import Model.Ships.Ship_Type;

/**
 Created on 13 Nov 2020

 @Author - Mambo */

/**
 Creates objects from the Japanese and US Ship Indexes, adding in the appropriate models for what was called
 */
public class ShipObjectFactory {

	public static Ship createJapaneseShip(Ship_Type type, JapaneseShipIndex chosenShip) {
		Ship japaneseShip = new Ship(type, chosenShip.getAaValue(), chosenShip.getMaxHP(), chosenShip.getBombardmentValue(), chosenShip.getName());

		// TODO: 2020-11-13 Probably create a new airfield type or class for the air value?
		japaneseShip.setAirValue(chosenShip.getAirValue());

		japaneseShip.setDamageModel(new NonCarrierDamageModel(chosenShip.getMaxHP()));

		return japaneseShip;
	}

	public static Ship createUSCarrier(Ship_Type ship_type, USShipIndex chosenShip){

		Ship carrier = new Ship(ship_type, chosenShip.getAaValue(), chosenShip.getMaxHP(), chosenShip.getBombardment(), chosenShip.getName());

		//If its a carrier, assign it a carrier model
		carrier.setDamageModel(new CarrierDamageModel(chosenShip.getMaxHP()));

		//Apply the appropriate sub-type based on the name
		IDamageModel damageModel = carrier.getDamageModel();

		if (damageModel instanceof CarrierDamageModel){
			((CarrierDamageModel) damageModel).generateType(chosenShip.getName());
		}

		IAirfield airfieldModel = new Airfield(chosenShip.getMaxHangar());
		airfieldModel.setManager(new AirfieldManager_Carrier(airfieldModel));
		airfieldModel.setParentShip(carrier);

		carrier.setAirfieldModel(airfieldModel);

		return carrier;
	}

	public static Ship createUSSurfaceShip(Ship_Type ship_type, USShipIndex chosenShip){
		Ship surfaceShip = new Ship(ship_type, chosenShip.getAaValue(), chosenShip.getMaxHP(), chosenShip.getBombardment(), chosenShip.getName());

		//Assign it a surface ship model
		surfaceShip.setDamageModel(new NonCarrierDamageModel(chosenShip.getMaxHP()));

		return surfaceShip;
	}

	private static IAirfield getSurfaceAirfield(){
		IAirfield airfield = new Airfield(0);

		airfield.setManager(new AirfieldManager_SurfaceShip());
		airfield.setParentShip(null);

		return airfield;
	}

	private static IAirfield getCarrierAirfield(int hangarCapacity, Ship carrier){
		IAirfield airfield = new Airfield(hangarCapacity);

		airfield.setManager(new AirfieldManager_Carrier(airfield));
		airfield.setParentShip(carrier);

		return airfield;
	}
}
