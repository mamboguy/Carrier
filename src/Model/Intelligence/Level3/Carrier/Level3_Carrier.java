package Model.Intelligence.Level3.Carrier;

import Controller.GameMaster.GameSettings;
import Model.Intelligence.IIntelligence;
import Model.Intelligence.Level3.Level3;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public abstract class Level3_Carrier extends Level3 {

	protected IIntelligence screenForce = null;

	@Override
	protected int getModifiers() {

		int modifier = 0;
		int commitLimit = GameSettings.instance().getCommitments().getJapaneseCarrierLimit();
		int commitIndex = GameSettings.instance().getIndexes().getCarrierIndex();

		if (commitLimit == 20 || commitLimit == 21){
			modifier += 1;
		} else if (commitLimit >= 22 && commitLimit <= 25){
			modifier += 2;
		} else if (commitLimit == 26 || commitLimit == 27){
			modifier += 3;
		} else if (commitLimit >= 28){
			modifier += 4;
		}

		if (GameSettings.instance().getIndexes().isCarrierCommitWithinXOfLimit(5)){
			modifier -= 4;
		}

		return modifier;
	}

	public IIntelligence getScreenForce(){
		return screenForce;
	}
}
