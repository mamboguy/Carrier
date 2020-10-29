package Model.Intelligence.Level3.Transport;

import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level3.Level3;
import Model.Intelligence.Other.Level4Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_TransportC
		extends Level3 {

	@Override
	public int[] getShipCountsFromIntelUpgrade(int dieRoll) {
		int transportCount;
		int ddCount;

		switch (dieRoll){
			case 1:
			case 2:
				// 3/4
				transportCount = 3;
				ddCount = 4;
				break;
			case 3:
			case 4:
				// 4/4
				transportCount = 4;
				ddCount = 4;
				break;
			case 5:
			case 6:
				// 4/5
				transportCount = 4;
				ddCount = 5;
				break;
			case 7:
			case 8:
				// 5/5
				transportCount = 5;
				ddCount = 5;
				break;
			case 9:
			case 10:
				// 5/6
				transportCount = 5;
				ddCount = 6;
				break;
			default:
				throw new UnsupportedOperationException();
		}

		return new int[]{0, 0, 0, 0, 0, 0, ddCount, transportCount};
	}

	@Override
	public String printSettings() {
		return "Level 3 - Transport C";
	}
}
