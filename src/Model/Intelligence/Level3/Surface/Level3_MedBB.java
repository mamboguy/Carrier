package Model.Intelligence.Level3.Surface;

import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level3.Level3;
import Model.Intelligence.Other.Level4Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_MedBB extends Level3 {


	@Override
	public int[] getShipCountsFromIntelUpgrade(int dieRoll) {
		int bbCount = 0;
		int clCount = 0;
		int caCount = 0;
		int ddCount;

		switch (dieRoll){

			case 1:
				//1 CA, 4 DD
				caCount = 1;
				ddCount = 4;
				break;
			case 2:
				//1 CA, 1 CL, 6 DD
				caCount = 1;
				clCount = 1;
				ddCount = 6;
				break;
			case 3:
				//2 CA, 6 DD
				caCount = 2;
				ddCount = 6;
				break;
			case 4:
				//1 BB, 3 DD
				bbCount = 1;
				ddCount = 3;
				break;
			case 5:
				//1 BB, 1 CA, 6 DD
				bbCount = 1;
				caCount = 1;
				ddCount = 6;
				break;
			case 6:
				//1 BB, 2 CA, 4 DD
				bbCount = 1;
				caCount = 2;
				ddCount = 4;
				break;
			case 7:
				//1 BB, 2 CA, 1 CL, 6 DD
				bbCount = 1;
				caCount = 2;
				clCount = 1;
				ddCount = 6;
				break;
			case 8:
				//2 BB, 1 CA, 3 DD
				bbCount = 2;
				caCount = 1;
				ddCount = 3;
				break;
			case 9:
				//2 BB, 1 CA, 4 DD
				bbCount = 2;
				caCount = 1;
				ddCount = 4;
				break;
			case 10:
				//2 BB, 2 CA, 5 DD
				bbCount = 2;
				caCount = 2;
				ddCount = 5;
				break;
			default:
				throw new UnsupportedOperationException();
		}

		return new int[]{0, 0, 0, bbCount, caCount, clCount, ddCount, 0};
	}

	@Override
	public String printSettings() {
		return "Level 3 - Medium BB";
	}
}
