package Model.Intelligence.Other;

import Controller.GameMaster.GameChitCups;
import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.IntelLevel;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level0Model
		implements IIntelligenceModel {

	public Level0Model(){

	}

	@Override
	public IntelLevel getIntelLevel() {
		return IntelLevel.Level0;
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
		return GameChitCups.instance().drawAndRemoveForceChitIntel();
	}

	@Override
	//Level 0 intelligence will never downgrade, so it stays the same
	public IIntelligenceModel downgradeIntelligence() {
		return this;
	}

	@Override
	public String printSettings() {
		return "Level 0";
	}
}
