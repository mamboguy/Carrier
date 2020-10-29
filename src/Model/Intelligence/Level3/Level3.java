package Model.Intelligence.Level3;

import Controller.Die;
import Controller.GameMaster.GameSettings;
import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.IntelLevel;
import Model.Intelligence.Other.Level0Model;
import Model.Intelligence.Other.Level4Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public abstract class Level3 implements IIntelligenceModel {

	public Level3(){

	}

	@Override
	public int upperChartNumber() {
		return 10;
	}

	@Override
	public int lowerChartNumber() {
		return 1;
	}

	@Override
	public int getModifiers(IForce force) {
		return 0;
	}

	@Override
	public IIntelligenceModel upgradeIntelligence(int dieRoll, IForce parent) {

		//Initialize as impossible to draw that many ships
		int[] results = new int[] {99,99,99,99,99,99,99,99};

		//Keep attempting an upgrade until the game can handle giving that many ships out
		while (!GameSettings.instance().getJapaneseShipFactory().hasEnoughShips(results[0], results[1], results[2], results[3], results[4], results[5], results[6])){
			results = getShipCountsFromIntelUpgrade(dieRoll);
			Die d = new Die(10);
			dieRoll = d.getBoundedLastRoll(getModifiers(parent), upperChartNumber(), lowerChartNumber());
		}

		//Return a new level 4 with all the ship counts
		return new Level4Model(results[0], results[1], results[2], results[3], results[4], results[5], results[6], results[7]);
	}

	public abstract int[] getShipCountsFromIntelUpgrade(int dieRoll);

	//Level 3 intel chits don't downgrade in intelligence
	@Override
	public IIntelligenceModel downgradeIntelligence() {
		return this;
	}

	@Override
	public IntelLevel getIntelLevel() {
		return IntelLevel.Level3;
	}

	protected boolean hasEnoughShips(int cvCount, int cveCount, int cvlCount, int bbCount, int caCount, int clCount, int ddCount){
		return GameSettings.instance().getJapaneseShipFactory().hasEnoughShips(cvCount, cveCount, cvlCount, bbCount, caCount, clCount, ddCount);
	}
}
