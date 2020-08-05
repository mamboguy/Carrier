package Model.Ships.DamageModels.CarrierDamageModels;

/**
 Created on 03 Aug 2020

 @Author - Mambo */


/**
 Damage model represents the Enterprise, Hornet, and Yorktown
 */
public class CarrierSubModel_Type1
		implements ICarrierDamageModel {

	/**
	 8 HP total

	 8 - No Damage
	 6-7 - Light Damage
	 4-5 - Medium Damage
	 3 - Heavy Damage
	 1-2 - Dead in water
	 0 - Sunk
	 */

	@Override
	public boolean isLightlyDamaged(int currHP) {
		return currHP <= 7;
	}

	@Override
	public boolean isHeavilyDamaged(int currHP) {
		return currHP <= 3;
	}

	@Override
	public boolean isMediumDamaged(int currHP) {
		return currHP <= 5;
	}

	@Override
	public boolean isDeadInWater(int currHP) {
		return currHP <= 2;
	}

	@Override
	public boolean receiveINOPMarker(int currHP) {
		return isMediumDamaged(currHP);
	}

	@Override
	public int getDifferenceFromDeadInWaterDamage(int currHP) {
		//Dead in water damage is 2 for this model
		return (currHP - 2 < 0) ? 0 : currHP - 2;
	}
}
