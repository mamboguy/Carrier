package Model.Intelligence.IntelligenceLevelModels.Level3.Transport;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.IntelligenceLevelModels.Level3.Level3;
import Model.Intelligence.IntelligenceLevelModels.Other.Level4Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_TransportD
		extends Level3 {

	@Override
	protected int getModifiers() {
		return 0;
	}

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {

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

		return new Level4Model(0, 0, 0, 0, 0, 0, ddCount, transportCount);
	}
}
