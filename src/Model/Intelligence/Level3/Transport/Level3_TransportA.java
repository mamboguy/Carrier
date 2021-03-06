package Model.Intelligence.Level3.Transport;

import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level3.Level3;
import Model.Intelligence.Other.Level4Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_TransportA extends Level3 {

	@Override
	public int[] getShipCountsFromIntelUpgrade(int dieRoll) {
		int clCount = 0;
		int transportCount;
		int ddCount;

		switch (dieRoll){
			case 1:
				// 9/9
				transportCount = 9;
				ddCount = 9;
				break;
			case 2:
				// 9/10
				transportCount = 9;
				ddCount = 10;
				break;
			case 3:
				// 10/10
				transportCount = 10;
				ddCount = 10;
				break;
			case 4:
				// 10/10/1
				transportCount = 10;
				ddCount = 10;
				clCount = 1;
				break;
			case 5:
			case 6:
				// 10/11/1
				transportCount = 10;
				ddCount = 11;
				clCount = 1;
				break;
			case 7:
				// 11/11/1
				transportCount = 11;
				ddCount = 11;
				clCount = 1;
				break;
			case 8:
				// 12/11/1
				transportCount = 12;
				ddCount = 11;
				clCount = 1;
				break;
			case 9:
				// 13/11/1
				transportCount = 13;
				ddCount = 11;
				clCount = 1;
				break;
			case 10:
				// 14/11/1
				transportCount = 14;
				ddCount = 11;
				clCount = 1;
				break;
			default:
				throw new UnsupportedOperationException();
		}

		return new int[]{0, 0, 0, 0, 0, clCount, ddCount, transportCount};
	}

	@Override
	public String printSettings() {
		return "Level 3 - Transport A";
	}
}
