package Model.Intelligence.IntelligenceLevelModels.Level2;

import Model.Intelligence.Intelligence;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public abstract class Level2 extends Intelligence {

	@Override
	public int intelligenceLevel() {
		return 2;
	}

	@Override
	protected int getModifiers() {
		return 0;
	}
}
