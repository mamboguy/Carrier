package Model.Intelligence.Other;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.Intelligence;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level0Model
		extends Intelligence {

	@Override
	public int intelligenceLevel() {
		return 0;
	}

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {
		// TODO: 2020-10-11 Add in the intelligence chit cup for drawing a force
		return null;
	}

	@Override
	//Level 0 intelligence will never downgrade, so it stays the same
	public IIntelligence downgradeIntelligence() {
		return this;
	}

	@Override
	protected int getModifiers() {
		return 0;
	}
}
