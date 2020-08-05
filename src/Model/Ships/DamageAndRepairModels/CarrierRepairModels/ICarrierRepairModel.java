package Model.Ships.DamageAndRepairModels.CarrierRepairModels;

/**
 Created on 03 Aug 2020

 @Author - Mambo */

public interface ICarrierRepairModel {

	/**
	 @return Does the current repair model allow repairing HP damage (light damage can never be repaired)
	 */
	boolean canRepairHPDamage();

}
