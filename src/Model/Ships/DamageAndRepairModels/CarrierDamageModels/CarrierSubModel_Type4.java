package Model.Ships.DamageAndRepairModels.CarrierDamageModels;

/**
 Created on 03 Aug 2020

 @Author - Mambo */

/**
 Damage model for the Wasp
 */
public class CarrierSubModel_Type4
		implements ICarrierDamageModel {

	/**
	 7 HP total

	 7 - No Damage
	 5-6 - Light Damage
	 3-4 - Medium Damage
	 2 - Heavy Damage
	 1 - Dead in water
	 0 - Sunk
	 */

	@Override
	public boolean isHeavilyDamaged(int currHP) {
		return currHP <= 2;
	}

	@Override
	public boolean isMediumDamaged(int currHP) {
		return currHP <= 4;
	}

	@Override
	public boolean isLightlyDamaged(int currHP) {
		return currHP <= 6;
	}

	@Override
	public boolean isDeadInWater(int currHP) {
		return currHP == 1;
	}

	@Override
	public boolean receiveINOPMarker(int currHP) {
		return isMediumDamaged(currHP);
	}

	@Override
	public int getDifferenceFromDeadInWaterDamage(int currHP) {
		//Dead in water damage is 1 for this model
		return (currHP - 1 < 0) ? 0 : currHP - 1;
	}
}
