package Model.Intelligence.Level3.Transport;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.Level3.Level3;
import Model.Intelligence.Other.Level4Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_TransportB
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
				// 6/6
				transportCount = 6;
				ddCount = 6;
				break;
			case 2:
			case 3:
				// 6/7
				transportCount = 6;
				ddCount = 7;
				break;
			case 4:
			case 5:
				// 7/7
				transportCount = 7;
				ddCount = 7;
				break;
			case 6:
			case 7:
				// 7/8
				transportCount = 7;
				ddCount = 8;
				break;
			case 8:
			case 9:
				// 8/8
				transportCount = 8;
				ddCount = 8;
				break;
			case 10:
				// 8/9
				transportCount = 8;
				ddCount = 9;
				break;
			default:
				throw new UnsupportedOperationException();
		}

		return new Level4Model(0, 0, 0, 0, 0, 0, ddCount, transportCount);
	}
}
