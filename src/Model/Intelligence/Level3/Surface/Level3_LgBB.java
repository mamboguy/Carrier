package Model.Intelligence.Level3.Surface;

import Model.Forces.IForce;
import Model.Intelligence.Level3.Level3;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_LgBB
		extends Level3 {

	@Override
	public int getModifiers(IForce force) {
		return 0;
	}

	@Override
	public int[] getShipCountsFromIntelUpgrade(int dieRoll) {
		int bbCount = 0;
		int clCount = 0;
		int caCount;
		int ddCount;

		dieRoll = checkBounds(dieRoll);

		switch (dieRoll){
			case 1:
				//2 CA, 6 DD
				caCount = 2;
				ddCount = 6;
				break;
			case 2:
				//4 CA, 4 DD
				caCount = 4;
				ddCount = 4;
				break;
			case 3:
			case 4:
				//2 BB, 3 CA, 6 DD
				bbCount = 2;
				caCount = 3;
				ddCount = 6;
				break;
			case 5:
			case 6:
				//2 BB, 4 CA, 4 DD
				bbCount = 2;
				caCount = 4;
				ddCount = 4;
				break;
			case 7:
				//2 BB, 4 CA, 1 CL, 6 DD
				bbCount = 2;
				caCount = 4;
				clCount = 1;
				ddCount = 6;
				break;
			case 8:
				//3 BB, 1 CA, 2 DD
				bbCount = 3;
				caCount = 1;
				ddCount = 2;
				break;
			case 9:
				//3 BB, 2 CA, 3 DD
				bbCount = 3;
				caCount = 2;
				ddCount = 3;
				break;
			case 10:
				//4 BB, 2 CA, 3 DD
				bbCount = 4;
				caCount = 2;
				ddCount = 3;
				break;
			default:
				throw new UnsupportedOperationException();
		}

		return new int[] {0, 0, 0, bbCount, caCount, clCount, ddCount, 0};
	}

	@Override
	public String printSettings() {
		return "Level 3 - Large BB";
	}
}
