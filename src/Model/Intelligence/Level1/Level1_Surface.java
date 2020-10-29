package Model.Intelligence.Level1;

import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level2.Level2_LgSurface;
import Model.Intelligence.Level2.Level2_MedSurface;
import Model.Intelligence.Level2.Level2_SmSurface;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level1_Surface extends Level1{

	@Override
	public IIntelligenceModel upgradeIntelligence(int dieRoll, IForce parent) {

		switch (dieRoll){
			case 1:
			case 2:
				return new Level2_SmSurface();
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				return new Level2_MedSurface();
			case 8:
			case 9:
				return new Level2_LgSurface();
			case 10:
				return new Level1_Carrier();
			default:
				throw new UnsupportedOperationException();
		}
	}

	@Override
	public String printSettings() {
		return "Level 1 - Surface";
	}
}
