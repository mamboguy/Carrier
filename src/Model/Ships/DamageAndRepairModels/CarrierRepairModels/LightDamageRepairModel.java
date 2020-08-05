package Model.Ships.DamageAndRepairModels.CarrierRepairModels;

/**
 Created on 03 Aug 2020

 @Author - Mambo */

public class LightDamageRepairModel
		extends BasicDamageRepairModel
		implements ICarrierRepairModel {

	@Override
	public boolean canRepairHPDamage() {
		return false;
	}

	@Override
	int getChartResult(int dieRoll) {
		switch (dieRoll) {
			case 1:
			case 2:
			case 3:
			case 4:
				return 0;
			case 5:
			case 6:
			case 7:
			case 8:
				return -1;
			case 9:
			case 10:
			default:
				return -2;
		}
	}

	@Override
	boolean rollOnCriticalChart(int dieRoll) {
		//Light repair table doesn't have critical failures
		return false;
	}

	@Override
	boolean causedIrreparableHullDamage(int dieRoll) {
		//Light repair table can't cause irreparable hull damage
		return false;
	}
}
