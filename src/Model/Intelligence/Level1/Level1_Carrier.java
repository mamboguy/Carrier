package Model.Intelligence.Level1;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.Level2.Level2_1or2CV;
import Model.Intelligence.Level2.Level2_2or3CV;
import Model.Intelligence.Level2.Level2_3PlusCV;

/**
 Created on 11 Oct 2020

 @Author - Mambo
 */

public class Level1_Carrier
		extends Level1 {

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {

		if (dieRoll < 1){
			dieRoll = 1;
		} else if (dieRoll > 10){
			dieRoll = 10;
		}

		switch (dieRoll){
			case 1:
			case 2:
			case 3:
			case 4:
				return new Level2_1or2CV();
			case 5:
			case 6:
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
