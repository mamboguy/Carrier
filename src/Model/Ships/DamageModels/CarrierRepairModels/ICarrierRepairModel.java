package Model.Ships.DamageModels.CarrierRepairModels;

/**
 Created on 03 Aug 2020

 @Author - Mambo */

public interface ICarrierRepairModel {

	/**
	 @return Does the current repair model allow repairing HP damage
	 */
	boolean canRepairHPDamage();

	/**
	 @return Does the current repair model allow repairing Medium damage
	 */
	boolean canRepairMediumDamage();
}
