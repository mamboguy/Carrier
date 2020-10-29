package Model.Intelligence.Level3.Carrier;

import Controller.Die;
import Controller.GameMaster.GameSettings;
import Model.Forces.IForce;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level2.Level2_MedSurface;
import Model.Intelligence.Level2.Level2_SmSurface;
import Model.Intelligence.Other.Level4Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level3_1CV
		extends Level3_Carrier {

	public Level3_1CV() {
		generateScreen(new Level2_MedSurface());
	}

	@Override
	protected int[] upgradeMyIntel(int dieRoll) {

		int cvCount = 0;
		int cveCount = 0;
		int cvlCount = 0;

		switch (dieRoll) {

			case 1:
			case 2:
				cveCount = 1;
				break;
			case 3:
			case 4:
			case 5:
				cvlCount = 1;
				break;
			case 6:
			case 7:
			case 8:
				cvCount = 1;
				break;
			case 9:
				cveCount = 2;
				break;
			case 10:
				cvlCount = 2;
				break;
			case 11:
				cvCount = 2;
				break;
			default:
				throw new UnsupportedOperationException();
		}

		return new int[] {cvCount, cveCount, cvlCount};
	}

	@Override
	public String printSettings() {
		return "Level 3 - 1 CV";
	}
}
