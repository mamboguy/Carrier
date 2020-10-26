package Model.Intelligence.Level2;

import Model.Intelligence.IntelLevel;
import Model.Intelligence.Intelligence;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public abstract class Level2 extends Intelligence {

	@Override
	public IntelLevel intelligenceLevel() {
		return IntelLevel.Level2;
	}

	@Override
	protected int getModifiers() {
		return 0;
	}
}
