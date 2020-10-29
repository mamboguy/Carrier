package Model.Intelligence.Level3.Transport;

import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level3.Level3;
import Model.Intelligence.Other.Level4Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_TransportD
		extends Level3 {

	@Override
	public int[] getShipCountsFromIntelUpgrade(int dieRoll) {
		int transportCount;
		int ddCount;

		switch (dieRoll){
			case 1:
				// 1/1
				transportCount = 1;
				ddCount = 1;
				break;
			case 2:
				// 2/1
				transportCount = 2;
				ddCount = 1;
				break;
			case 3:
			case 4:
				// 2/2
				transportCount = 2;
				ddCount = 2;
				break;
			case 5:
			case 6:
			case 7:
				// 3/2
				transportCount = 3;
				ddCount = 2;
				break;
			case 8:
			case 9:
			case 10:
				// 3/3
				transportCount = 3;
				ddCount = 3;
				break;
			default:
				throw new UnsupportedOperationException();
		}

		return new int[]{0, 0, 0, 0, 0, 0, ddCount, transportCount};
	}

	@Override
	public String printSettings() {
		return "Level 3 - Transport D";
	}
}
