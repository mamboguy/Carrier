package Model.Intelligence.IntelligenceLevelModels.Level2;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.IntelligenceLevelModels.Level1.Level1_Large;
import Model.Intelligence.IntelligenceLevelModels.Level3.Surface.*;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level2_LgSurface
		extends Level2{

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {

		switch (dieRoll){
			case 1:
				return new Level2_1or2CV();
			case 2:
				return new Level3_MedCA();
			case 3:
				return new Level3_MedBB();
			case 4:
			case 5:
				return new Level3_LgCA();
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				return new Level3_LgBB();
			default:
				throw new UnsupportedOperationException();
		}
	}

	@Override
	public IIntelligence downgradeIntelligence() {
		return new Level1_Large();
	}
}
