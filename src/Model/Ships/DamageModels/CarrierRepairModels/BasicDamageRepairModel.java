package Model.Ships.DamageModels.CarrierRepairModels;

import Controller.GameMaster.Die;
import Controller.GameMaster.GameSettings;
import Model.Ships.DamageModels.CarrierDamageModels.ICarrierDamageModel;

/**
 Created on 03 Aug 2020

 @Author - Mambo */

public abstract class BasicDamageRepairModel
		implements ICarrierRepairModel {

	private static final int NO_RAISE_OR_LOWER = -1;

	public BasicDamageRepairModel() {
	}

	abstract int getChartResult(int dieRoll);

	abstract boolean rollOnCriticalChart(int dieRoll);

	abstract boolean causedIrreparableHullDamage(int dieRoll);

	public RepairResults getRepairResult(int lastRoll, ICarrierDamageModel currModel, int currentHP) {

		Die damageRoll = new Die(10);
		damageRoll.rollDie();

		int modifiers = getModifiers(currModel, currentHP);
		int chartResult = 0;
		boolean causedIrreparableHullDamage = false;
		boolean wasCriticalDamageRoll = false;
		boolean allowRaiseAndLowering = true;

		//Determine if it was a critical failure repair and if it caused irreparable hull damage
		if (rollOnCriticalChart(damageRoll.getLastRoll())) {
			wasCriticalDamageRoll = true;
			causedIrreparableHullDamage = causedIrreparableHullDamage(damageRoll.getLastRoll());

			//Consult the chart to get the result of the repair (medium model will roll on critical and add 1)
			chartResult = getChartResult(damageRoll.getBoundedLastRoll(modifiers, 1, 10));

			//Reroll the die and consult the critical damage table
			damageRoll.rollDie();
			chartResult += getCriticalResult(damageRoll.getLastRoll() + modifiers);

			//Check if the result was that no raising or lowering is allowed
			if (chartResult == NO_RAISE_OR_LOWER) {
				allowRaiseAndLowering = false;
				chartResult = 0;
			}

		} else {
			//If not a critical result, get the basic chart result
			chartResult = getChartResult(damageRoll.getBoundedLastRoll(modifiers, 1, 10));
		}

		return new RepairResults(chartResult, causedIrreparableHullDamage, wasCriticalDamageRoll,
								 allowRaiseAndLowering);
	}

	private int getCriticalResult(int dieRoll) {
		switch (dieRoll) {
			case 1:
				return 4;
			case 2:
				return 2;
			case 3:
			case 4:
				return 1;
			case 5:
			case 6:
			case 7:
				return NO_RAISE_OR_LOWER;
			case 8:
			case 9:
			case 10:
			default:
				return 0;
		}
	}

	private int getModifiers(ICarrierDamageModel currModel, int currentHP) {
		int modifier = 0;

		modifier += currModel.getDifferenceFromDeadInWaterDamage(currentHP);
		modifier += GameSettings.instance().getScenarioPeriod().getRepairModifier();

		return modifier;
	}
}
