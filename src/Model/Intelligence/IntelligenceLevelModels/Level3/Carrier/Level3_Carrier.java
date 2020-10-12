package Model.Intelligence.IntelligenceLevelModels.Level3.Carrier;

import Model.Intelligence.IntelligenceLevelModels.Level3.Level3;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public abstract class Level3_Carrier extends Level3 {

	@Override
	protected int getModifiers() {

		int modifier = 0;

		// TODO: 2020-10-11 Implement this when commit limits are made
		int carrierLimit = -1;
		int commitLimit = -1;
		int commitIndex = -1;

		if (carrierLimit == 20 || carrierLimit == 21){
			modifier += 1;
		} else if (carrierLimit >= 22 && carrierLimit <= 25){
			modifier += 2;
		} else if (carrierLimit == 26 || carrierLimit == 27){
			modifier += 3;
		} else if (carrierLimit >= 28){
			modifier += 4;
		}

		if (commitLimit - commitIndex <= 5){
			modifier -= 4;
		}

		return modifier;
	}
}
