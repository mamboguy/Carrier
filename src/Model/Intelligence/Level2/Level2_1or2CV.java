package Model.Intelligence.Level2;

import Model.Forces.IForce;
import Model.Intelligence.IIntelligence;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level1.Level1_Carrier;
import Model.Intelligence.Level3.Carrier.*;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level2_1or2CV
		extends Level2 {

	@Override
	public IIntelligenceModel upgradeIntelligence(int dieRoll, IForce parent) {

		if (parent.hasAirValue()){

			//If it has an air value, look up on appropriate table
			int revealedAirStrength = parent.getAirValue();

			if (revealedAirStrength <= 5){
				return lowestStrength(dieRoll);
			} else if (revealedAirStrength == 6 || revealedAirStrength == 7){
				return secondStrength(dieRoll);
			} else if (revealedAirStrength >= 8 && revealedAirStrength <= 10){
				return thirdStrength(dieRoll);
			} else {
				return biggestStrength(dieRoll);
			}
		} else {

			//Look up on second table if no air value
			return secondStrength(dieRoll);
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
				return new Level3_1CVL();
			case 9:
			case 10:
				return new Level3_2CVL();
			default:
				throw new UnsupportedOperationException();
		}
	}

	private IIntelligenceModel secondStrength(int dieRoll) {
		switch (dieRoll){
			case 1:
			case 2:
			case 3:
				return new Level3_1CVL();
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				return new Level3_2CVL();
			case 10:
				return new Level3_1CV();
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
			case 5:
			case 6:
			case 7:
				return new Level3_2CVL();
			case 8:
			case 9:
				return new Level3_1CV_1CVL();
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
				return new Level3_1CV_1CVL();
			case 3:
			case 4:
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

	@Override
	public IIntelligenceModel downgradeIntelligence() {
		return new Level1_Carrier();
	}

	@Override
	public String printSettings() {
		return "Level 2 - 1 or 2 CV";
	}
}
