package Model.Intelligence.Level1;

import Controller.Die;
import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level2.*;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level1_Small
		extends Level1{

	@Override
	public IIntelligenceModel upgradeIntelligence(int dieRoll, IForce parent, boolean wasNaturalTen) {

		dieRoll = checkIfNaturalTen(dieRoll, wasNaturalTen, parent);

		switch (dieRoll){
			case 1:
			case 2:
			case 3:
			case 4:
				return new Level2_SmSurface();
			case 5:
				// TODO: 2020-10-11 Implement me
				return new Level2_SmTransport();
			case 6:
			case 7:
			case 8:
			case 9:
				return new Level2_1or2CV();
			case 10:
				Die die = new Die(10);
				die.rollDie();
				dieRoll = die.getBoundedLastRoll(getModifiers(parent), upperChartNumber(), lowerChartNumber());

				switch (dieRoll){
					case 1:
						return new Level2_1or2CV();
					case 2:
					case 3:
					case 4:
						return new Level2_MedSurface();
					default:
						//TODO 10/29/2020 - Implement me
						return new Level2_MedTransport();
				}
			default:
				throw new UnsupportedOperationException();
		}
	}

	@Override
	public String printSettings() {
		return "Level 1 - Small";
	}
}
