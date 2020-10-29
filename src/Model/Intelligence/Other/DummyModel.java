package Model.Intelligence.Other;

import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.IntelLevel;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class DummyModel
		implements IIntelligenceModel {

	public DummyModel() {

	}

	//Dummy model is a way for force chits to be removed if a dummy intel chit is drawn

	@Override
	public IntelLevel getIntelLevel() {
		return IntelLevel.Dummy;
	}

	@Override
	public int upperChartNumber() {
		return 0;
	}

	@Override
	public int lowerChartNumber() {
		return 0;
	}

	@Override
	public int getModifiers(IForce force) {
		return 0;
	}

	@Override
	public IIntelligenceModel upgradeIntelligence(int dieRoll, IForce parent) {
		return this;
	}

	@Override
	public IIntelligenceModel downgradeIntelligence() {
		return this;
	}

	@Override
	public String printSettings() {
		return "Dummy Model";
	}
}
