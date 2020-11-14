package Model.Intelligence.Level3.Surface;

import Model.Intelligence.Level3.Level3;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_LgCA extends Level3 {

	@Override
	public int[] getShipCountsFromIntelUpgrade(int dieRoll) {
		int bbCount = 0;
		int clCount = 0;
		int caCount;
		int ddCount;

		dieRoll = checkBounds(dieRoll);

		switch (dieRoll){

			case 1:
				//3 CA, 2 DD
				caCount = 3;
				ddCount = 2;
				break;
			case 2:
				//4 CA, 3 DD
				caCount = 4;
				ddCount = 3;
				break;
			case 3:
				//5 CA, 1 DD
				caCount = 5;
				ddCount = 1;
				break;
			case 4:
				//5 CA, 2 DD
				caCount = 5;
				ddCount = 2;
				break;
			case 5:
				//5 CA, 5 DD
				caCount = 5;
				ddCount = 5;
				break;
			case 6:
				//5 CA, 1 CL, 1 DD
				caCount = 5;
				ddCount = 1;
				clCount = 1;
				break;
			case 7:
				//6 CA, 3 DD
				caCount = 6;
				ddCount = 3;
				break;
			case 8:
				//6 CA, 4 DD
				caCount = 6;
				ddCount = 4;
				break;
			case 9:
				//6 CA, 1 CL, 2 DD
				caCount = 6;
				clCount = 1;
				ddCount = 2;
				break;
			case 10:
				//6 CA, 1 CL, 5 DD
				caCount = 6;
				clCount = 1;
				ddCount = 5;
				break;
			default:
				throw new UnsupportedOperationException();
		}

		return new int[]{0, 0, 0, bbCount, caCount, clCount, ddCount, 0};
	}

	@Override
	public String printSettings() {
		return "Level 3 - Large CA";
	}
}
