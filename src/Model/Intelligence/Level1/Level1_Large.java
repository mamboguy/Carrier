package Model.Intelligence.Level1;

import Controller.Die;
import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level2.*;
import Model.Intelligence.Other.DummyModel;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level1_Large
		extends Level1{

	@Override
	public IIntelligenceModel upgradeIntelligence(int dieRoll, IForce parent) {

		switch (dieRoll){
			case 1:
				return new Level2_MedSurface();
			case 2:
			case 3:
			case 4:
			case 5:
				return new Level2_LgSurface();
			case 6:
				// TODO: 2020-10-11 Implement me
				return new Level2_LgTransport();
			case 7:
				return new Level2_2or3CV();
			case 8:
			case 9:
				return new Level2_3PlusCV();
			case 10:

				Die die = new Die(10);
				die.rollDie();
				dieRoll = die.getBoundedLastRoll(getModifiers(parent), upperChartNumber(), lowerChartNumber());

				switch (dieRoll){
					case 1:
						return new Level2_3PlusCV();
					case 2:
					case 3:
						return new Level2_MedSurface();
					default:
						return new DummyModel();
				}
			default:
				throw new UnsupportedOperationException();
		}
	}

	@Override
	public String printSettings() {
		return "Level 1 - Large";
	}
}
