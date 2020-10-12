package Model.Intelligence.Level1;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.Level2.Level2_LgSurface;
import Model.Intelligence.Level2.Level2_MedSurface;
import Model.Intelligence.Level2.Level2_SmSurface;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level1_Surface extends Level1{

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {

		if (dieRoll < 1){
			dieRoll = 1;
		} else if (dieRoll > 10){
			dieRoll = 10;
		}

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
}
