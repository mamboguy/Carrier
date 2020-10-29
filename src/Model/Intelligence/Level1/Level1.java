package Model.Intelligence.Level1;

import Controller.GameMaster.GameSettings;
import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.IntelLevel;
import Model.Intelligence.Other.Level0Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public abstract class Level1
		implements IIntelligenceModel {

	public Level1(){

	}

	@Override
	public IIntelligenceModel downgradeIntelligence() {
		return new Level0Model();
	}

	@Override
	public IntelLevel getIntelLevel() {
		return IntelLevel.Level1;
	}

	@Override
	public int upperChartNumber() {
		return 1;
	}

	@Override
	public int lowerChartNumber() {
		return 10;
	}

	@Override
	public int getModifiers(IForce force) {

		int modifier = 0;

		//-4 if Carrier Commit Index is within 5 or less of limit
		if (GameSettings.instance().getIndexes().isCarrierCommitWithinXOfLimit(5)){
			modifier -= 4;
		}

		if (force.hasAirValue()){
			//Generate modifier from revealed air strength
			int revealedAirStrength = force.getAirValue();

			if (revealedAirStrength <= 4){
				revealedAirStrength = 5;
			} else if (revealedAirStrength >= 14){
				revealedAirStrength = 14;
			}

			modifier += (revealedAirStrength - 9);
		} else {

			//-4 if force has secondary objective (doesn't apply if any air strength)
			if (force.getObjective() == GameSettings.instance().getJapaneseObjective().getSecondaryObjective()){
				modifier -= 4;
			}

		}

		return modifier;
	}
}
