package Model.Intelligence.Level3.Carrier;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.Level2.Level2_LgSurface;
import Model.Intelligence.Other.Level4Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_3CVL
		extends Level3_Carrier {

	public Level3_3CVL() {
		super();
		super.screenForce = new Level2_LgSurface();
		screenForce.upgradeIntelligence(super.getDieRoll());
	}

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {

		int cvCount = 0;
		int cveCount = 0;
		int cvlCount = 0;

		if (dieRoll < 1){
			dieRoll = 1;
		}

		if (dieRoll > 10){
			dieRoll = 11;
		}

		switch (dieRoll){

			case 1:
			case 2:
			case 7:
				cveCount = 3;
				break;
			case 3:
			case 4:
			case 5:
			case 6:
				cveCount = 2;
				cvlCount = 1;
				break;
			case 8:
				cvlCount = 2;
				cveCount = 1;
				break;
			case 9:
				cvCount = 2;
				cveCount = 1;
				break;
			case 10:
				cvCount = 2;
				cvlCount = 1;
				break;
			case 11:
				cvCount = 3;
				break;
			default:
				throw new UnsupportedOperationException();
		}

		return new Level4Model(cvCount, cveCount, cvlCount, 0, 0, 0, 0, 0);
	}
}
