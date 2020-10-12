package Model.Intelligence.Level2;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.Level1.Level1_Carrier;
import Model.Intelligence.Level3.Carrier.*;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level2_1or2CV
		extends Level2 {

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {

		int revealedAirStrength = -1;

		if (revealedAirStrength <= 5){
			return lowestStrength(dieRoll);
		} else if (revealedAirStrength == 6 || revealedAirStrength == 7){
			return secondStrength(dieRoll);
		} else if (revealedAirStrength >= 8 && revealedAirStrength <= 10){
			return thirdStrength(dieRoll);
		} else {
			return biggestStrength(dieRoll);
		}
	}

	private IIntelligence lowestStrength(int dieRoll) {
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

	private IIntelligence secondStrength(int dieRoll) {
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

	private IIntelligence thirdStrength(int dieRoll) {
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

	private IIntelligence biggestStrength(int dieRoll) {
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
	public IIntelligence downgradeIntelligence() {
		return new Level1_Carrier();
	}
}
