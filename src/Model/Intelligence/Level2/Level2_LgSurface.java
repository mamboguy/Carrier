package Model.Intelligence.Level2;

import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level1.Level1_Large;
import Model.Intelligence.Level3.Surface.*;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level2_LgSurface
		extends Level2{

	@Override
	public IIntelligenceModel upgradeIntelligence(int dieRoll, IForce parent, boolean wasNaturalTen) {

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
	public IIntelligenceModel downgradeIntelligence() {
		return new Level1_Large();
	}

	@Override
	public String printSettings() {
		return "Level 2 - Large Surface";
	}
}
