package Model.Intelligence.IntelligenceLevelModels.Level3.Surface;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.IntelligenceLevelModels.Level3.Level3;
import Model.Intelligence.IntelligenceLevelModels.Other.Level4Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_MedDD
		extends Level3{

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
			case 2:
				//4 DD
				ddCount = 4;
				break;
			case 3:
			case 4:
			case 5:
				//5 DD
				ddCount = 5;
				break;
			case 6:
			case 7:
				//6 DD
				ddCount = 6;
				break;
			case 8:
				//1 CL, 7 DD
				clCount = 1;
				ddCount = 7;
				break;
			case 9:
				//1 CL, 8 DD
				clCount = 1;
				ddCount = 8;
				break;
			case 10:
				//1 CL, 10 DD
				clCount = 1;
				ddCount = 10;
				break;
			default:
				throw new UnsupportedOperationException();
		}

		return new Level4Model(0, 0, 0, bbCount, caCount, clCount, ddCount, 0);
	}
}
