package Model.Intelligence.IntelligenceLevelModels.Level3.Surface;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.IntelligenceLevelModels.Level3.Level3;
import Model.Intelligence.IntelligenceLevelModels.Other.Level4Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_SmCA extends Level3{

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
				//4 DD
				ddCount = 4;
				break;
			case 2:
				//5 DD
				ddCount = 5;
				break;
			case 3:
			case 4:
				//6 DD
				ddCount = 6;
				break;
			case 5:
				//1 CL, 5 DD
				clCount = 1;
				ddCount = 5;
				break;
			case 6:
				//1 CL, 6 DD
				clCount = 1;
				ddCount = 6;
				break;
			case 7:
			case 8:
				//1 CA, 6 DD
				caCount = 1;
				ddCount = 6;
				break;
			case 9:
			case 10:
				//1 CA, 1CL, 5 DD
				caCount = 1;
				clCount = 1;
				ddCount = 5;
				break;
			default:
				throw new UnsupportedOperationException();
		}

		return new Level4Model(0, 0, 0, bbCount, caCount, clCount, ddCount, 0);
	}
}
