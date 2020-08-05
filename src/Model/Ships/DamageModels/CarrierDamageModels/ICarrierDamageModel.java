package Model.Ships.DamageModels.CarrierDamageModels;

/**
 Created on 03 Aug 2020

 @Author - Mambo */

public interface ICarrierDamageModel {

	boolean isHeavilyDamaged(int currHP);

	boolean isMediumDamaged(int currHP);

	boolean isLightlyDamaged(int currHP);

	boolean isDeadInWater(int currHP);

	boolean receiveINOPMarker(int currHP);

	int getDifferenceFromDeadInWaterDamage(int currHP);
}
