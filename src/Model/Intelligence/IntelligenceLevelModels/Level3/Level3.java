package Model.Intelligence.IntelligenceLevelModels.Level3;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.Intelligence;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public abstract class Level3 extends Intelligence {

	@Override
	public int intelligenceLevel() {
		return 3;
	}

	//Level 3 intel chits don't downgrade
	@Override
	public IIntelligence downgradeIntelligence() {
		return this;
	}
}