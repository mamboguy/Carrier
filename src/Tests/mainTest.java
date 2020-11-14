import Controller.GameMaster.GameChitCups;
import Controller.GameMaster.GameSettings;
import Model.Forces.JapaneseForce;
import Model.Intelligence.IntelLevel;
import Model.Intelligence.Intelligence;
import Model.Intelligence.Other.Level0Model;
import Model.Intelligence.Other.Level4Model;
import Model.Ships.Ship;

import java.util.ArrayList;

class mainTest {

	public mainTest() {
		//Stress test the intel upgrade without replacement
		for (int i = 0; i < 10000; i++) {
			testIntelUpgrade(32, false);
		}

		//Stress test intel upgrade with replacement
		for (int i = 0; i < 100000; i++) {
			testIntelUpgrade(1, true);
		}
	}

	private static void testIntelUpgrade(int count, boolean replaceChits) {
		//Test to see if there are any die roll combos that pop up errors
		for (int i = 0; i < count; i++) {
			System.out.println("-------------------------------------");
			System.out.println("Test #" + i);
			System.out.println("-------------------------------------");
			testIntelUpgrade(replaceChits);
			GameSettings.instance().resetFactory();

			if (!replaceChits){
				GameChitCups.instance().resetChitCup();
			}
		}
	}

	private static void testShips() {
		int cvCount = 1;
		int cveCount = 1;
		int cvlCount = 1;
		int battleships = 2;
		int cruiserCA = 3;
		int cruiserCL = 3;
		int destroyers = 12;

		System.out.println();
		printShipNames(GameSettings.instance().getJapaneseShipFactory().giveCarrier(cvCount));
		printShipNames(GameSettings.instance().getJapaneseShipFactory().giveCarrier_Escort(cveCount));
		printShipNames(GameSettings.instance().getJapaneseShipFactory().giveCarrier_Light(cvlCount));
		printShipNames(GameSettings.instance().getJapaneseShipFactory().giveBattleship(battleships));
		printShipNames(GameSettings.instance().getJapaneseShipFactory().giveCruiser_CA(cruiserCA));
		printShipNames(GameSettings.instance().getJapaneseShipFactory().giveCruiser_CL(cruiserCL));
		printShipNames(GameSettings.instance().getJapaneseShipFactory().giveDestroyer(destroyers));
	}

	private static void printShipNames(ArrayList<Ship> shipList) {
		int size = shipList.size();
		System.out.println("Category: " + shipList.get(0).getShortTypeName());

		for (Ship item : shipList){
			System.out.println("  - " + item.getShipName());
		}
	}

	private static void testIntelUpgrade(boolean returnChit){
		Intelligence temp = new Intelligence(new JapaneseForce());

		while (true){

			if (temp.intelligenceLevel() == IntelLevel.Dummy){
				temp.setIntelModel(new Level0Model());
			}

			if (temp.intelligenceLevel() == IntelLevel.Level4){
				break;
			}

			temp.printSettings();
			temp.upgradeIntelligence();

			if (returnChit){
				GameChitCups.instance().returnLastDrawnChit();
			}
		}

		Level4Model full = ((Level4Model) temp.getIntelModel());

		full.generateShips();
		full.printSettings();
	}
}