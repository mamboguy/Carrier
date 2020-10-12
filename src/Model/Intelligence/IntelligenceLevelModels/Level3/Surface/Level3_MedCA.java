package Model.Intelligence.IntelligenceLevelModels.Level3.Surface;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.IntelligenceLevelModels.Level3.Level3;
import Model.Intelligence.IntelligenceLevelModels.Other.Level4Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_MedCA
		extends Level3 {

	@Override
	protected int getModifiers() {
		return 0;
	}

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {

		int bbCount = 0;
		int clCount = 0;
		int caCount = 0;
		int ddCount;

		switch (dieRoll){

			case 1:
				//1 CL, 5 DD
				clCount = 1;
				ddCount = 5;
				break;
			case 2:
				//2 CA, 4 DD
				caCount = 2;
				ddCount = 4;
				break;
			case 3:
				//3 CA, 2 DD
				caCount = 3;
				ddCount = 2;
				break;
			case 4:
			case 5:
				//3 CA, 3 DD
				caCount = 3;
				ddCount = 3;
				break;
			case 6:
				//3 CA, 4 DD
				caCount = 3;
				ddCount = 4;
				break;
			case 7:
				//4 CA, 2 DD
				caCount = 4;
				ddCount = 2;
				break;
			case 8:
				//4 CA, 3 DD
				caCount = 4;
				ddCount = 3;
				break;
			case 9:
				//4 CA, 4 DD
				caCount = 4;
				ddCount = 4;
				break;
			case 10:
				//5 CA, 1 CL, 1 DD
				caCount = 5;
				clCount = 1;
				ddCount = 1;
				break;
			default:
				throw new UnsupportedOperationException();
		}

		return new Level4Model(0, 0, 0, bbCount, caCount, clCount, ddCount, 0);
	}
}