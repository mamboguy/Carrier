package Model.Intelligence.IntelligenceLevelModels.Level2;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.IntelligenceLevelModels.Level1.Level1_Medium;
import Model.Intelligence.IntelligenceLevelModels.Level3.Surface.*;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level2_MedSurface extends Level2{

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {

		switch (dieRoll){
			case 1:
				return new Level2_1or2CV();
			case 2:
			case 3:
			case 4:
				return new Level3_MedDD();
			case 5:
			case 6:
			case 7:
				return new Level3_MedCA();
			case 8:
				return new Level3_MedBB();
			case 9:
				return new Level3_LgCA();
			case 10:
				return new Level3_LgBB();
			default:
				throw new UnsupportedOperationException();
		}
	}

	@Override
	public IIntelligence downgradeIntelligence() {
		return new Level1_Medium();
	}
}
