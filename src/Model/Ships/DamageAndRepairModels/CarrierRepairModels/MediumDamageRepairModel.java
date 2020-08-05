package Model.Ships.DamageAndRepairModels.CarrierRepairModels;

/**
 Created on 03 Aug 2020

 @Author - Mambo */

public class MediumDamageRepairModel
		extends BasicDamageRepairModel
		implements ICarrierRepairModel {

	@Override
	public boolean canRepairHPDamage() {
		return true;
	}

	@Override
	int getChartResult(int dieRoll) {
		switch (dieRoll) {
			case 1:
			case 2:
				return 1;
			case 3:
			case 4:
			case 5:
				return 0;
			case 6:
			case 7:
			case 8:
			case 9:
				return -1;
			case 10:
			default:
				return -2;
		}
	}

	@Override
	boolean rollOnCriticalChart(int dieRoll) {
		return dieRoll == 1;
	}

	@Override
	boolean causedIrreparableHullDamage(int dieRoll) {
		//Medium table doesn't allow irreparable hull damage
		return false;
	}
}
