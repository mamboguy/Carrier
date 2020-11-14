package Model.Intelligence.Level2;

import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level1.Level1_Medium;
import Model.Intelligence.Level3.Surface.*;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level2_MedSurface extends Level2{

	@Override
	public IIntelligenceModel upgradeIntelligence(int dieRoll, IForce parent, boolean wasNaturalTen) {

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
	public IIntelligenceModel downgradeIntelligence() {
		return new Level1_Medium();
	}

	@Override
	public String printSettings() {
		return "Level 2 - Medium Surface";
	}
}
