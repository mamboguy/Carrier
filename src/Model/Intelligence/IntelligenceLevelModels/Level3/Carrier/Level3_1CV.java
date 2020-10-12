package Model.Intelligence.IntelligenceLevelModels.Level3.Carrier;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.IntelligenceLevelModels.Other.Level4Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_1CV
		extends Level3_Carrier {

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {

		int cvCount = 0;
		int cveCount = 0;
		int cvlCount = 0;

		if (dieRoll < 1){
			dieRoll = 1;
		}

		if (dieRoll > 10){
			dieRoll = 11;
		}

		switch (dieRoll){

			case 1:
			case 2:
				cveCount = 1;
				break;
			case 3:
			case 4:
			case 5:
				cvlCount = 1;
				break;
			case 6:
			case 7:
			case 8:
				cvCount = 1;
				break;
			case 9:
				cveCount = 2;
				break;
			case 10:
				cvlCount = 2;
				break;
			case 11:
				cvCount = 2;
				break;
			default:
				throw new UnsupportedOperationException();
		}

		return new Level4Model(cvCount, cveCount, cvlCount, 0, 0, 0, 0, 0);
	}
}
