package Model.Intelligence.IntelligenceLevelModels.Level2;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.IntelligenceLevelModels.Level1.Level1_Small;
import Model.Intelligence.IntelligenceLevelModels.Level3.Surface.Level3_MedCA;
import Model.Intelligence.IntelligenceLevelModels.Level3.Surface.Level3_MedDD;
import Model.Intelligence.IntelligenceLevelModels.Level3.Surface.Level3_SmCA;
import Model.Intelligence.IntelligenceLevelModels.Level3.Surface.Level3_SmDD;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level2_SmSurface
		extends Level2{

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {

		switch (dieRoll){
			case 1:
				return new Level2_1or2CV();
			case 2:
			case 3:
				return new Level3_SmDD();
			case 4:
			case 5:
			case 6:
			case 7:
				return new Level3_SmCA();
			case 8:
			case 9:
				return new Level3_MedDD();
			case 10:
				return new Level3_MedCA();
			default:
				throw new UnsupportedOperationException();
		}
	}

	@Override
	public IIntelligence downgradeIntelligence() {
		return new Level1_Small();
	}
}
