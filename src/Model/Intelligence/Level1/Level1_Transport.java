package Model.Intelligence.Level1;

import Controller.Die;
import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level2.*;
import Model.Intelligence.Other.DummyModel;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level1_Transport extends Level1 {

	@Override
	public IIntelligenceModel upgradeIntelligence(int dieRoll, IForce parent, boolean wasNaturalTen) {

		switch (dieRoll){
			case 1:
			case 2:
				return new Level2_SmTransport();
			case 3:
			case 4:
				return new Level2_MedTransport();
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				return new Level2_LgTransport();
			case 10:
				Die die = new Die(10);
				die.rollDie();
				dieRoll = die.getBoundedLastRoll(getModifiers(parent), upperChartNumber(), lowerChartNumber());

				switch (dieRoll){
					case 1:
						return new Level1_Carrier();
					case 2:
						return new Level1_Surface();
					default:
						return new DummyModel();
				}
			default:
				throw new UnsupportedOperationException();
		}
	}

	@Override
	public String printSettings() {
		return "Level 1 - Transport";
	}
}
