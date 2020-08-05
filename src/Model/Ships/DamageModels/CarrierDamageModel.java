package Model.Ships.DamageModels;

import Controller.GameMaster.Die;
import Model.Ships.DamageModels.CarrierDamageModels.*;
import Model.Ships.DamageModels.CarrierRepairModels.*;

/**
 Created on 03 Aug 2020

 @Author - Mambo */

public class CarrierDamageModel
		extends BasicDamageModel
		implements IDamageModel {

	private ICarrierDamageModel damageModelType;
	private BasicDamageRepairModel repairModel;
	private boolean allowRaiseAndLowering;
	private boolean beenIrreparablyDamaged;

	public CarrierDamageModel(int maximumHP) {
		super(maximumHP);
	}

	public void generateType(String carrierName) {
		switch (carrierName) {
			case "Enterprise":
			case "Yorktown":
			case "Hornet":
				damageModelType = new CarrierSubModel_Type1();
				break;
			case "Lexington":
			case "Saratoga":
				damageModelType = new CarrierSubModel_Type2();
				break;
			case "Victorious":
				damageModelType = new CarrierSubModel_Type3();
				break;
			case "Wasp":
				damageModelType = new CarrierSubModel_Type4();
				break;
		}

		this.repairModel = new LightDamageRepairModel();
	}

	@Override
	public void applyDamage(int numberOfHits) {
		super.applyDamage(numberOfHits);

		adjustRepairModel();
	}

	/**
	 Adjust the current repair model based off ship's HP
	 */
	private void adjustRepairModel() {
		//Otherwise, apply the most appropriate model
		if (damageModelType.isHeavilyDamaged(super.currentHP)) {
			this.repairModel = new HeavyDamageRepairModel();
		} else if (damageModelType.isMediumDamaged(super.currentHP)) {
			this.repairModel = new MediumDamageRepairModel();
		} else if (damageModelType.isLightlyDamaged(super.currentHP)) {
			this.repairModel = new LightDamageRepairModel();
		}
	}

	@Override
	public boolean isLightlyDamaged() {
		return damageModelType.isLightlyDamaged(super.currentHP);
	}

	@Override
	public boolean isMediumDamaged() {
		return damageModelType.isMediumDamaged(super.currentHP);
	}

	@Override
	public boolean isHeavilyDamaged() {
		return damageModelType.isHeavilyDamaged(super.currentHP);
	}

	@Override
	public boolean isDeadInWater() {
		return damageModelType.isDeadInWater(super.currentHP);
	}

	@Override
	public boolean canLaunchPlanes() {
		//As long as the carrier isn't dead in the water and it has no inop markers, then it is allowed
		//to launch planes from the damage model's perspective
		return (!damageModelType.isDeadInWater(super.currentHP) || !isFlightDeckINOP());
	}

	@Override
	public boolean receiveINOPMarkers(int currHP) {
		return damageModelType.receiveINOPMarker(currHP);
	}

	@Override
	public boolean isFlightDeckINOP() {
		return super.inopMarkers > 0;
	}

	public int getFlightDeckCounters() {
		return super.inopMarkers;
	}

	@Override
	public void repair() {
		//Create and roll a die
		Die repairDie = new Die(10);
		repairDie.rollDie();

		RepairResults repairResults = repairModel.getRepairResult(repairDie.getLastRoll(), damageModelType,
																  super.currentHP);

		//Toggle raising and lowering allowed
		allowRaiseAndLowering = repairResults.isAllowRaisingAndLowering();

		//If the result caused irreparable hull damage, update the irreparably damaged flag
		if (repairResults.isCausedIrreparableHullDamage()) {
			beenIrreparablyDamaged = true;
		}

		if (repairResults.getRepairResult() <= 0) {

			//Repair the hp
			repairHP(repairResults.getRepairResult());

			//Remove the same number of inop markers as damage repaired
			inopMarkers -= repairResults.getRepairResult();

		} else {

			//Apply damage as required since damage was caused by the repair party
			applyDamage(repairResults.getRepairResult());

		}

	}

	private void repairHP(int amountToRepair) {
		//Amount to repair is assumed to be negative since it was checked above

		for (int i = amountToRepair; i < 0; i++) {

			//Check to see if HP repairing is allowed
			if (repairModel.canRepairHPDamage()) {

				//If the ship is heavily damaged, all models allow repair for all heavy damage
				if (damageModelType.isHeavilyDamaged(super.currentHP)) {

					super.currentHP++;

					//If the ship is medium damaged and the model allows, repair damage
				} else if (repairModel.canRepairMediumDamage() && damageModelType.isMediumDamaged(super.currentHP)) {

					super.currentHP++;

				} else {
					//Repairing not allowed
				}
			}
		}
	}
}
