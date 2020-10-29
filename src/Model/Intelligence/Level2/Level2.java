package Model.Intelligence.Level2;

import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.IntelLevel;
import Model.Intelligence.Intelligence;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public abstract class Level2 implements IIntelligenceModel {

	public Level2(){

	}

	@Override
	public int upperChartNumber() {
		return 10;
	}

	@Override
	public int lowerChartNumber() {
		return 1;
	}

	@Override
	public int getModifiers(IForce force) {
		return 0;
	}

	@Override
	public IntelLevel getIntelLevel() {
		return IntelLevel.Level2;
	}
}
