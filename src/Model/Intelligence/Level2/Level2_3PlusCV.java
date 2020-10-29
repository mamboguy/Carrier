package Model.Intelligence.Level2;

import Model.Forces.IForce;
import Model.Intelligence.IIntelligence;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level1.Level1_Carrier;
import Model.Intelligence.Level3.Carrier.*;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level2_3PlusCV
		extends Level2 {

	@Override
	public IIntelligenceModel upgradeIntelligence(int dieRoll, IForce parent) {

		if (parent.hasAirValue()){
			int revealedAirStrength = parent.getAirValue();

			if (revealedAirStrength <= 12){
				return lowestStrength(dieRoll);
			} else if (revealedAirStrength == 13 || revealedAirStrength == 14){
				return secondStrength(dieRoll);
			} else if (revealedAirStrength == 15 || revealedAirStrength == 16){
				return thirdStrength(dieRoll);
			} else {
				return biggestStrength(dieRoll);
			}
		} else {
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
			case 3:
			case 4:
			case 5:
				return new Level3_3CVL();
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				return new Level3_2CV_1CVL();
			default:
				throw new UnsupportedOperationException();
		}
	}

	private IIntelligenceModel thirdStrength(int dieRoll) {
		switch (dieRoll){
			case 1:
				return new Level3_3CVL();
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				return new Level3_2CV_1CVL();
			case 9:
			case 10:
				return new Level3_2CV_2CVL();
			default:
				throw new UnsupportedOperationException();
		}
	}

	private IIntelligenceModel biggestStrength(int dieRoll) {
		switch (dieRoll){
			case 1:
				return new Level3_2CV_1CVL();
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				return new Level3_2CV_2CVL();
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
		return "Level 2 - 3+ CV";
	}
}
