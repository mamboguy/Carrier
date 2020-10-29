package Model.Intelligence.Level3.Carrier;

import Model.Intelligence.Level2.Level2_MedSurface;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_1CV_1CVL
		extends Level3_Carrier {

	public Level3_1CV_1CVL() {
		generateScreen(new Level2_MedSurface());
	}

	@Override
	protected int[] upgradeMyIntel(int dieRoll) {
		int cvCount = 0;
		int cveCount = 0;
		int cvlCount = 0;

		switch (dieRoll){

			case 1:
				cveCount = 1;
				cvlCount = 1;
				break;
			case 2:
				cveCount = 2;
				break;
			case 3:
				cvlCount = 2;
				break;
			case 4:
			case 5:
			case 6:
				cvCount = 1;
				cveCount = 1;
				break;
			case 7:
			case 8:
			case 9:
				cvCount = 2;
				cvlCount = 1;
				break;
			case 10:
				cvCount = 2;
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
		return "Level 3 - 1 CV + 1 CVL";
	}
}
