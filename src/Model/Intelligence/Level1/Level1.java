package Model.Intelligence.Level1;

import Controller.GameMaster.GameSettings;
import Model.Intelligence.IIntelligence;
import Model.Intelligence.IntelLevel;
import Model.Intelligence.Intelligence;
import Model.Intelligence.Other.Level0Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public abstract class Level1
		extends Intelligence {

	@Override
	public IntelLevel intelligenceLevel() {
		return IntelLevel.Level1;
	}

	@Override
	public IIntelligence downgradeIntelligence() {
		return new Level0Model();
	}

	@Override
	protected int getModifiers() {

		int modifier = 0;

		//-4 if Carrier Commit Index is within 5 or less of limit
		if (GameSettings.instance().getIndexes().isCarrierCommitWithinXOfLimit(5)){
			modifier -= 4;
		}

		//-4 if force has secondary objective (doesn't apply if any air strength)


		//Generate modifier from revealed air strength
		//// TODO: 2020-10-18 Grab the air strength from the force
		int revealedAirStrength = 0;

		if (revealedAirStrength <= 4){
			revealedAirStrength = 5;
		} else if (revealedAirStrength >= 14){
			revealedAirStrength = 14;
		}

		return revealedAirStrength - 9;
	}
}
