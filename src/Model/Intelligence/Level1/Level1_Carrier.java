package Model.Intelligence.Level1;

import Controller.Die;
import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level2.Level2_1or2CV;
import Model.Intelligence.Level2.Level2_2or3CV;
import Model.Intelligence.Level2.Level2_3PlusCV;
import Model.Intelligence.Other.DummyModel;

/**
 Created on 11 Oct 2020

 @Author - Mambo
 */

public class Level1_Carrier
		extends Level1 {


	@Override
	public IIntelligenceModel upgradeIntelligence(int dieRoll, IForce parent) {

		switch (dieRoll){
			case 1:
			case 2:
			case 3:
			case 4:
				return new Level2_1or2CV();
			case 5:
			case 6:
			case 7:
				return new Level2_2or3CV();
			case 8:
			case 9:
				return new Level2_3PlusCV();
			case 10:

				Die die = new Die(10);
				die.rollDie();
				dieRoll = die.getBoundedLastRoll(getModifiers(parent), upperChartNumber(), lowerChartNumber());

				if (!parent.hasAirValue()){
					//If the target has NO air value
					switch (dieRoll){
						case 1:
						case 2:
						case 3:
						case 4:
						case 5:
							return new Level1_Surface();
						default:
							return new DummyModel();
					}
				} else {
					//Target has air value, so keep upgrading intel until a non-10 is found
					return upgradeIntelligence(dieRoll, parent);
				}
			default:
				throw new UnsupportedOperationException();
		}
	}

	@Override
	public String printSettings() {
		return "Level 1 - Carrier";
	}
}
