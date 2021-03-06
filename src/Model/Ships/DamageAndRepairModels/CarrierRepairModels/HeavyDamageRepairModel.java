package Model.Ships.DamageAndRepairModels.CarrierRepairModels;

/**
 Created on 03 Aug 2020

 @Author - Mambo */

public class HeavyDamageRepairModel
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
				return 0;
			case 2:
				return 1;
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				return 0;
			case 8:
			case 9:
			case 10:
			default:
				return -1;
		}
	}

	@Override
	boolean rollOnCriticalChart(int dieRoll) {
		return dieRoll == 1;
	}

	@Override
	boolean causedIrreparableHullDamage(int dieRoll) {
		return dieRoll == 1;
	}
}
