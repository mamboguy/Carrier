package Model.Intelligence.Other;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.IntelLevel;
import Model.Intelligence.Intelligence;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class DummyModel
		extends Intelligence {

	//Dummy model is a way for force chits to be removed if a dummy intel chit is drawn

	@Override
	public IntelLevel intelligenceLevel() {
		return IntelLevel.Dummy;
	}

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {
		return null;
	}

	@Override
	public IIntelligence downgradeIntelligence() {
		return null;
	}

	@Override
	protected int getModifiers() {
		return 0;
	}
}
