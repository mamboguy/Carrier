package Model.Intelligence.Level2;

import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level1.Level1_Carrier;
import Model.Intelligence.Level3.Carrier.*;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level2_2or3CV
		extends Level2 {

	@Override
	public IIntelligenceModel upgradeIntelligence(int dieRoll, IForce parent, boolean wasNaturalTen) {

		if (parent.hasAirValue()){

			int revealedAirStrength = parent.getAirValue();

			if (revealedAirStrength <= 7){
				return lowestStrength(dieRoll);
			} else if (revealedAirStrength >= 8 && revealedAirStrength <= 10){
				return secondStrength(dieRoll);
			} else if (revealedAirStrength >= 11 && revealedAirStrength <= 13){
				return thirdStrength(dieRoll);
			} else {
				return biggestStrength(dieRoll);
			}

		} else {
			//If no air value, look up on 3rd column
			return thirdStrength(dieRoll);
		}

	}

	private IIntelligenceModel lowestStrength(int dieRoll) {
		switch (dieRoll){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				return new Level3_2CVL();
			case 8:
			case 9:
			case 10:
				return new Level3_3CVL();
			default:
				throw new UnsupportedOperationException();
		}
	}

	private IIntelligenceModel secondStrength(int dieRoll) {
		switch (dieRoll){
			case 1:
			case 2:
				return new Level3_2CVL();
			case 3:
			case 4:
			case 5:
			case 6:
				return new Level3_3CVL();
			case 7:
			case 8:
			case 9:
			case 10:
				return new Level3_1CV_1CVL();
			default:
				throw new UnsupportedOperationException();
		}
	}

	private IIntelligenceModel thirdStrength(int dieRoll) {
		switch (dieRoll){
			case 1:
			case 2:
			case 3:
			case 4:
				return new Level3_1CV_1CVL();
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				return new Level3_2CV();
			default:
				throw new UnsupportedOperationException();
		}
	}

	private IIntelligenceModel biggestStrength(int dieRoll) {
		switch (dieRoll){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				return new Level3_2CV();
			case 9:
			case 10:
				return new Level3_2CV_1CVL();
			default:
				throw new UnsupportedOperationException();
		}
	}

	@Override
	public IIntelligenceModel downgradeIntelligence() {
		return new Level1_Carrier();
	}

	@Override
	public String printSettings() {
		return "Level 2 - 2 or 3 CV";
	}
}
