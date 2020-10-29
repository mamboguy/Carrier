package Model.Settings;

import Controller.Die;
import Model.Enums.ScenarioPeriod;

/**
 Created on 16 Oct 2020

 @Author - Mambo */

public class LandAirValues {

	private int rabaulAirValue;
	private int guadalcanalFuel;
	private int moresbyP39Count;
	private int moresbyMedBCount;
	private int guadalcanalF4FCount;
	private int guadalcanalSBDCount;
	private int guadalcanalTBFCount;
	private int guadalcanalP38Count;
	private int guadalcanalP39Count;

	//Internal debug use only
	private int moresbyMod;
	private int guadalMod;
	private int dieRollLand;
	private int dieRollRabaul;

	public LandAirValues(ScenarioPeriod period){

		Die die = new Die(10);
		die.rollDie();

		dieRollRabaul = die.getLastRoll();
		getRabaulAirValue(period, die.getLastRoll());

		die.rollDie();
		getUSLandAirValues(period, die);

		//printSettings();
	}

	private void printSettings(){
		System.out.println("\nRabaul Air Value: " + rabaulAirValue + "(" + dieRollRabaul + ")");
		System.out.println("Moresby roll: " + dieRollLand + "(" + moresbyMod + ")");
		System.out.println("Moresby P-39: " + moresbyP39Count);
		System.out.println("Moresby Med B: " + moresbyMedBCount);
		System.out.println("Guadalcanal roll: " + dieRollLand + "(" + guadalMod + ")");
		System.out.println("Guadalcanal F4F: " + guadalcanalF4FCount);
		System.out.println("Guadalcanal SBD: " + guadalcanalSBDCount);
		System.out.println("Guadalcanal TBF: " + guadalcanalTBFCount);
		System.out.println("Guadalcanal P38: " + guadalcanalP38Count);
		System.out.println("Guadalcanal P39: " + guadalcanalP39Count);
		System.out.println("Guadalcanal Fuel: " + guadalcanalFuel);
	}

	private void getUSLandAirValues(ScenarioPeriod period, Die die) {

		moresbyMod = 0;
		guadalMod = 0;

		switch (period) {
			case Jan_July_42:
				moresbyMod = -4;
				break;
			case Aug_Sept_42:
				break;
			case Oct_Dec_42:
			case Year_1943:
				moresbyMod = 3;
				guadalMod = 1;
				break;
		}

		die.rollDie();
		dieRollLand = die.getLastRoll();
		getMoresbyValue(die.getBoundedLastRoll(moresbyMod, 10, 1));
		getGuadalcanalValue(die.getBoundedLastRoll(guadalMod, 11, 1));
	}

	private void getMoresbyValue(int lastRoll) {
		int p39 = 0;
		int medB = 0;

		switch (lastRoll){
			case 1:
				p39 = 3;
				medB = 2;
				break;
			case 2:
				p39 = 4;
				medB = 2;
				break;
			case 3:
				p39 = 4;
				medB = 3;
				break;
			case 4:
				p39 = 6;
				medB = 3;
				break;
			case 5:
				p39 = 7;
				medB = 3;
				break;
			case 6:
				p39 = 7;
				medB = 4;
				break;
			case 7:
				p39 = 8;
				medB = 4;
				break;
			case 8:
				p39 = 9;
				medB = 4;
				break;
			case 9:
			case 10:
				p39 = 9;
				medB = 5;
				break;
		}

		moresbyMedBCount = medB;
		moresbyP39Count = p39;
	}

	private void getGuadalcanalValue(int lastRoll) {
		int f4f = 0;
		int sbd = 0;
		int tbf = 0;
		int p38 = 0;
		int p39 = 0;
		int fuel = 0;

		switch (lastRoll){
			case 1:
			case 2:
				f4f = 3;
				sbd = 3;
				fuel = 7;
				break;
			case 3:
				f4f = 5;
				sbd = 4;
				fuel = 10;
				break;
			case 4:
				f4f = 6;
				sbd = 6;
				fuel = 14;
				break;
			case 5:
				f4f = 6;
				sbd = 6;
				tbf = 1;
				fuel = 15;
				break;
			case 6:
				f4f = 7;
				sbd = 6;
				tbf = 1;
				fuel = 16;
				break;
			case 7:
			case 8:
				f4f = 7;
				sbd = 7;
				tbf = 1;
				fuel = 17;
				break;
			case 9:
				f4f = 7;
				sbd = 7;
				tbf = 2;
				fuel = 23;
				break;
			case 10:
				f4f = 9;
				sbd = 7;
				tbf = 2;
				p38 = 2;
				fuel = 30;
				break;
			case 11:
				f4f = 9;
				sbd = 7;
				tbf = 2;
				p38 = 4;
				p39 = 4;
				break;
		}

		guadalcanalF4FCount = f4f;
		guadalcanalP38Count = p38;
		guadalcanalP39Count = p39;
		guadalcanalSBDCount = sbd;
		guadalcanalTBFCount = tbf;
		guadalcanalFuel = fuel;
	}

	private void getRabaulAirValue(ScenarioPeriod period, int lastRoll) {
		switch (period) {
			case Jan_July_42:
				rabaulAirValue = janJuly(lastRoll);
				break;
			case Aug_Sept_42:
				rabaulAirValue = augSept(lastRoll);
				break;
			case Oct_Dec_42:
			case Year_1943:
				rabaulAirValue = octPlus(lastRoll);
				break;
		}
	}


	private int janJuly(int lastRoll) {
		switch (lastRoll){
			case 1:
				return 12;
			case 2:
				return 13;
			case 3:
			case 4:
			case 5:
				return 14;
			case 6:
			case 7:
			case 8:
				return 15;
			case 9:
				return 16;
			case 10:
				return 17;
		}

		return -1;
	}

	private int augSept(int lastRoll) {
		switch (lastRoll){
			case 1:
				return 9;
			case 2:
				return 10;
			case 3:
				return 11;
			case 4:
				return 12;
			case 5:
				return 13;
			case 6:
				return 14;
			case 7:
				return 15;
			case 8:
				return 16;
			case 9:
				return 17;
			case 10:
				return 18;
		}

		return -1;
	}

	private int octPlus(int lastRoll) {
		switch (lastRoll){
			case 1:
				return 12;
			case 2:
				return 13;
			case 3:
				return 14;
			case 4:
				return 15;
			case 5:
				return 16;
			case 6:
				return 17;
			case 7:
				return 18;
			case 8:
			case 9:
				return 19;
			case 10:
				return 20;
		}

		return -1;
	}

	public int getRabaulAirValue() {
		return rabaulAirValue;
	}

	public int getGuadalcanalFuel() {
		return guadalcanalFuel;
	}

	public int getMoresbyP39Count() {
		return moresbyP39Count;
	}

	public int getMoresbyMedBCount() {
		return moresbyMedBCount;
	}

	public int getGuadalcanalF4FCount() {
		return guadalcanalF4FCount;
	}

	public int getGuadalcanalSBDCount() {
		return guadalcanalSBDCount;
	}

	public int getGuadalcanalTBFCount() {
		return guadalcanalTBFCount;
	}

	public int getGuadalcanalP38Count() {
		return guadalcanalP38Count;
	}

	public int getGuadalcanalP39Count() {
		return guadalcanalP39Count;
	}
}
