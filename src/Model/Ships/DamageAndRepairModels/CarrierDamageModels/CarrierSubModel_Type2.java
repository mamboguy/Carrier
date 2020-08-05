package Model.Ships.DamageAndRepairModels.CarrierDamageModels;

/**
 Created on 03 Aug 2020

 @Author - Mambo */

/**
 Damage Model for the Lexington and Saratoga
 */
public class CarrierSubModel_Type2
		implements ICarrierDamageModel {

	/**
	 9 HP total

	 9 - No Damage
	 7-8 - Light Damage
	 4-6 - Medium Damage
	 3 - Heavy Damage
	 1-2 - Dead in water
	 0 - Sunk
	 */

	@Override
	public boolean isHeavilyDamaged(int currHP) {
		return currHP <= 3;
	}

	@Override
	public boolean isMediumDamaged(int currHP) {
		return currHP <= 6;
	}

	@Override
	public boolean isLightlyDamaged(int currHP) {
		return currHP <= 8;
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
