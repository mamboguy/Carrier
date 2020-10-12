package Model.Intelligence.IntelligenceLevelModels.Level1;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.IntelligenceLevelModels.Level2.Level2_2or3CV;
import Model.Intelligence.IntelligenceLevelModels.Level2.Level2_MedSurface;
import Model.Intelligence.IntelligenceLevelModels.Level2.Level2_MedTransport;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level1_Medium
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
			case 2:
			case 3:
			case 4:
			case 5:
				return new Level2_MedSurface();
			case 6:
				// TODO: 2020-10-11 Implement me
				return new Level2_MedTransport();
			case 7:
			case 8:
			case 9:
				return new Level2_2or3CV();
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
