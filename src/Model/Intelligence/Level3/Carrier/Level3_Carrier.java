package Model.Intelligence.Level3.Carrier;

import Controller.Die;
import Controller.GameMaster.GameSettings;
import Model.Forces.IForce;
import Model.Intelligence.IIntelligence;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level2.Level2;
import Model.Intelligence.Level2.Level2_LgSurface;
import Model.Intelligence.Level3.Level3;
import Model.Intelligence.Other.Level4Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public abstract class Level3_Carrier extends Level3 {

	protected IIntelligenceModel screenForce = null;

	@Override
	public int upperChartNumber() {
		return 11;
	}

	@Override
	public int[] getShipCountsFromIntelUpgrade(int dieRoll) {
		int[] results = new int[8];

		//Screen force will always be level 3 here
		results = ((Level3)screenForce).getShipCountsFromIntelUpgrade(dieRoll);

		return addNumbers(results, this.upgradeMyIntel(dieRoll));
	}

	private int[] addNumbers(int[] results, int[] additions){
		return new int[] {additions[0], additions[1], additions[2], results[3], results[4], results[5], results[6], results[7]};
	}

	//Third level of abstraction for getting the carrier values separate from the screen values
	protected abstract int[] upgradeMyIntel(int dieRoll);

	@Override
	public int getModifiers(IForce parent) {

		int modifier = 0;
		int commitLimit = GameSettings.instance().getCommitments().getJapaneseCarrierLimit();

		if (commitLimit == 20 || commitLimit == 21) {
			modifier += 1;
		} else if (commitLimit >= 22 && commitLimit <= 25) {
			modifier += 2;
		} else if (commitLimit == 26 || commitLimit == 27) {
			modifier += 3;
		} else if (commitLimit >= 28) {
			modifier += 4;
		}

		if (GameSettings.instance().getIndexes().isCarrierCommitWithinXOfLimit(5)) {
			modifier -= 4;
		}

		return modifier;
	}

	protected void generateScreen(IIntelligenceModel screenModel) {

		Die die = new Die(10);
		die.rollDie();

		int dieRoll = die.getLastRoll();

		System.out.println("Screen - " + screenModel.printSettings());

		//1 is a carrier result on all Level 2 surface tables
		while (dieRoll == 1){
			dieRoll = die.getBoundedLastRoll(0, 10, 1);
		}

		//Level 2 models don't use IForce parameter, so no need to pass
		screenForce = screenModel.upgradeIntelligence(dieRoll, null);
		System.out.println("(" + dieRoll + ")" + screenForce.printSettings());
	}

	public IIntelligenceModel getScreenForce(){
		return screenForce;
	}
}
