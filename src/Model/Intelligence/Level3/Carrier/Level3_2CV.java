package Model.Intelligence.Level3.Carrier;

import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level2.Level2_LgSurface;
import Model.Intelligence.Level2.Level2_MedSurface;
import Model.Intelligence.Other.Level4Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_2CV
		extends Level3_Carrier {

	public Level3_2CV() {
		generateScreen(new Level2_LgSurface());
	}

	@Override
	protected int[] upgradeMyIntel(int dieRoll) {
		int cvCount = 0;
		int cveCount = 0;
		int cvlCount = 0;

		switch (dieRoll){

			case 1:
				cveCount = 2;
				break;
			case 2:
				cvlCount = 2;
				break;
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				cvCount = 2;
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

		return new int[] {cvCount, cveCount, cvlCount};
	}

	@Override
	public String printSettings() {
		return "Level 3 - 2 CV";
	}
}
