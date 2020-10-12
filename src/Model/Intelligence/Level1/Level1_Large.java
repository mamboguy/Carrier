package Model.Intelligence.Level1;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.Level2.*;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level1_Large
		extends Level1{

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {
		if (dieRoll < 1){
			dieRoll = 1;
		} else if (dieRoll > 10){
			dieRoll = 10;
		}

		switch (dieRoll){
			case 1:
				return new Level2_MedSurface();
			case 2:
			case 3:
			case 4:
			case 5:
				return new Level2_LgSurface();
			case 6:
				// TODO: 2020-10-11 Implement me
				return new Level2_LgTransport();
			case 7:
				return new Level2_2or3CV();
			case 8:
			case 9:
				return new Level2_3PlusCV();
			case 10:
				checkRollAgain();
			default:
				throw new UnsupportedOperationException();
		}
	}

	private void checkRollAgain() {
		// TODO: 2020-10-11 Implement me
	}
}
