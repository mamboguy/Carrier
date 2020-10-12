package Model.Intelligence.IntelligenceLevelModels.Level1;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.Intelligence;
import Model.Intelligence.IntelligenceLevelModels.Other.Level0Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public abstract class Level1
		extends Intelligence {

	@Override
	public int intelligenceLevel() {
		return 1;
	}

	@Override
	public IIntelligence downgradeIntelligence() {
		return new Level0Model();
	}

	@Override
	protected int getModifiers() {
		// TODO: 2020-10-11 Implement me & fix return

		//-4 if Carrier Commit Index is within 5 or less of limit
		//-4 if force has secondary objective (doesn't apply if any air strength)

		int revealedAirStrength = 0;

		if (revealedAirStrength <= 4){
			revealedAirStrength = 5;
		} else if (revealedAirStrength >= 14){
			revealedAirStrength = 14;
		}

		return revealedAirStrength - 9;
	}
}
