package Model.Intelligence.Level3.Surface;

import Model.Intelligence.Level3.Level3;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_SmDD extends Level3 {

	@Override
	public int[] getShipCountsFromIntelUpgrade(int dieRoll) {
		int bbCount = 0;
		int clCount = 0;
		int caCount = 0;
		int ddCount;

		dieRoll = checkBounds(dieRoll);

		switch (dieRoll){

			case 1:
			case 2:
			case 3:
				//2 DD
				ddCount = 2;
				break;
			case 4:
			case 5:
			case 6:
			case 7:
				//3 DD
				ddCount = 3;
				break;
			case 8:
				//4 DD
				ddCount = 4;
				break;
			case 9:
				//5 DD
				ddCount = 5;
				break;
			case 10:
				//1 CL, 4 DD
				clCount = 1;
				ddCount = 4;
				break;
			default:
				throw new UnsupportedOperationException();
		}

		return new int[]{0, 0, 0, bbCount, caCount, clCount, ddCount, 0};
	}

	@Override
	public String printSettings() {
		return "Level 3 - Small DD";
	}
}
