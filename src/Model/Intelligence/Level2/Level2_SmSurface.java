package Model.Intelligence.Level2;

import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level1.Level1_Small;
import Model.Intelligence.Level3.Surface.Level3_MedCA;
import Model.Intelligence.Level3.Surface.Level3_MedDD;
import Model.Intelligence.Level3.Surface.Level3_SmCA;
import Model.Intelligence.Level3.Surface.Level3_SmDD;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level2_SmSurface
		extends Level2{

	@Override
	public IIntelligenceModel upgradeIntelligence(int dieRoll, IForce parent, boolean wasNaturalTen) {

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
	public IIntelligenceModel downgradeIntelligence() {
		return new Level1_Small();
	}

	@Override
	public String printSettings() {
		return "Level 2 - Small Surface";
	}
}
