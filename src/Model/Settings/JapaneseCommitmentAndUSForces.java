package Model.Settings;

import Controller.Die;
import Model.Enums.ScenarioPeriod;

import javax.swing.*;

/**
 Created on 12 Oct 2020

 @Author - Mambo */

public class JapaneseCommitmentAndUSForces {

	private int japaneseCarrierLimit;
	private int japaneseSurfaceLimit;
	private int japaneseTransportLimit;
	private int japaneseRetirementLimit;
	private int usCarrierCount;
	private int usSurfacePoints;
	private boolean strategicSurprise;

	private ScenarioPeriod scenarioPeriod;

	public JapaneseCommitmentAndUSForces(ScenarioPeriod scenario, boolean hasSecondary){

		Die die = new Die(10);
		die.rollDie();

		int[] values = null;

		this.scenarioPeriod = scenario;

		switch (scenario){
			case Jan_July_42:
				if (hasSecondary){
					values = janJul42_TwoObjective(die.getLastRoll());
				} else {
					values = janJul42_OneObjective(die.getLastRoll());
				}
				break;
			case Aug_Sept_42:
			case Oct_Dec_42:
				if (hasSecondary){
					values = augDec42_TwoObjective(die.getLastRoll());
				} else {
					values = augDec42_OneObjective(die.getLastRoll());
				}
				break;
			case Year_1943:
				values = year1943(die.getLastRoll());
				break;
		}

		//Assign all the limits and US points
		japaneseCarrierLimit = values[0];
		japaneseSurfaceLimit = values[1];
		japaneseTransportLimit = values[2];
		japaneseRetirementLimit = values[3];
		usCarrierCount = values[4];
		usSurfacePoints = values[5];
		strategicSurprise = (values[6] == 1);

		//printSettings(die.getLastRoll());
	}

	private int[] janJul42_OneObjective(int lastRoll) {
		switch (lastRoll){
			case 1:
				return new int[]{10, 9, 3, 23, 2, 24, 0};
			case 2:
				return new int[]{11, 10, 3, 26, 2, 26, 0};
			case 3:
				return new int[]{12, 11, 3, 27, 2, 27, 0};
			case 4:
				return new int[]{12, 11, 4, 28, 2, 28, 0};
			case 5:
				return new int[]{12, 11, 4, 29, 2, 29, 0};
			case 6:
				return new int[]{13, 12, 4, 30, 2, 29, 0};
			case 7:
				return new int[]{14, 12, 5, 31, 2, 30, 0};
			case 8:
				return new int[]{14, 12, 5, 32, 2, 31, 0};
			case 9:
				return new int[]{26, 25, 7, 60, 3, 40, 1};
			case 10:
				return new int[]{28, 25, 7, 66, 3, 42, 1};
		}
		throw new UnsupportedOperationException();
	}

	private int[] janJul42_TwoObjective(int lastRoll) {
		switch (lastRoll){
			case 1:
				return new int[]{12, 11, 4, 28, 2, 29, 0};
			case 2:
				return new int[]{14, 12, 5, 30, 2, 30, 0};
			case 3:
				return new int[]{14, 13, 5, 31, 2, 31, 0};
			case 4:
				return new int[]{17, 15, 6, 37, 3, 41, 0};
			case 5:
				return new int[]{18, 17, 6, 40, 3, 42, 0};
			case 6:
				return new int[]{19, 18, 7, 42, 3, 42, 0};
			case 7:
				return new int[]{21, 19, 7, 46, 3, 42, 0};
			case 8:
				return askUserForOption(21, 20, 7, 48, 3, 42, 0, 2, 28, 1);
			case 9:
				return new int[]{26, 25, 8, 60, 3, 44, 1};
			case 10:
				return new int[]{28, 25, 8, 66, 3, 46, 1};
		}
		throw new UnsupportedOperationException();
	}

	private int[] augDec42_OneObjective(int lastRoll) {
		switch (lastRoll){
			case 1:
				return new int[]{11, 17, 3, 26, 2, 27, 0};
			case 2:
				return new int[]{12, 18, 4, 28, 2, 28, 0};
			case 3:
				return new int[]{13, 19, 4, 30, 2, 30, 0};
			case 4:
				return new int[]{14, 20, 4, 33, 2, 31, 0};
			case 5:
				return new int[]{14, 21, 4, 34, 2, 32, 0};
			case 6:
				return new int[]{15, 22, 5, 34, 2, 36, 0};
			case 7:
				return new int[]{15, 23, 5, 35, 2, 40, 0};
			case 8:
				return new int[]{19, 25, 5, 42, 3, 40, 0};
			case 9:
				return new int[]{20, 27, 5, 45, 3, 42, 0};
			case 10:
				return askUserForOption(21, 28, 5, 49, 3, 44, 0, 2, 28, 1);
		}
		throw new UnsupportedOperationException();
	}

	private int[] augDec42_TwoObjective(int lastRoll) {
		switch (lastRoll){
			case 1:
				return new int[]{14, 21, 5, 32, 2, 32, 0};
			case 2:
				return new int[]{14, 23, 5, 32, 2, 36, 0};
			case 3:
				return new int[]{15, 25, 5, 33, 2, 40, 0};
			case 4:
				return new int[]{17, 26, 6, 37, 3, 42, 0};
			case 5:
				return new int[]{19, 28, 6, 42, 3, 43, 0};
			case 6:
				return new int[]{20, 29, 6, 46, 3, 44, 0};
			case 7:
				return new int[]{21, 30, 6, 46, 3, 44, 0};
			case 8:
				return new int[]{21, 32, 7, 48, 3, 46, 0};
			case 9:
				return new int[]{22, 33, 7, 50, 3, 48, 0};
			case 10:
				return new int[]{22, 35, 7, 51, 3, 50, 0};
		}
		throw new UnsupportedOperationException();
	}

	private int[] year1943(int lastRoll) {
		switch (lastRoll){
			case 1:
				return new int[]{11, 16, 0, 26, 2, 31, 0};
			case 2:
				return new int[]{12, 17, 0, 28, 2, 32, 0};
			case 3:
				return new int[]{13, 18, 0, 30, 2, 33, 0};
			case 4:
				return new int[]{13, 19, 0, 31, 2, 33, 0};
			case 5:
				return new int[]{14, 20, 0, 34, 2, 34, 0};
			case 6:
				return new int[]{15, 21, 0, 34, 2, 36, 0};
			case 7:
				return new int[]{15, 22, 0, 35, 2, 38, 0};
			case 8:
				return new int[]{17, 24, 0, 38, 2, 40, 0};
			case 9:
				return new int[]{19, 27, 0, 42, 3, 43, 0};
			case 10:
				return new int[]{20, 31, 0, 45, 3, 46, 0};
		}
		throw new UnsupportedOperationException();
	}

	private int[] askUserForOption(int carrier, int surface, int transport, int retirement,
								   int usCV_Opt1, int usSurf_Opt1, int stratSur_Opt1,
								   int usCV_Opt2, int usSurf_Opt2, int stratSur_Opt2) {

		String stratOpt1 = "N";
		String stratOpt2 = "N";

		if (stratSur_Opt1 == 1){
			stratOpt1 = "Y";
		}

		if (stratSur_Opt2 == 1){
			stratOpt2 = "Y";
		}


		String message =
				"The scenario you rolled allows you to choose your start.  Review the options below and select one:\n\n" +
				"Scenario Timeframe - " + scenarioPeriod.getTimeframe() +
				"\n\n" +
				"Japanese Commitment Limits\n" +
				"Carrier - " + carrier + " / Surface - " + surface + " / Transport - " + transport + " / Retirement " + retirement +
				"\n\n" +
				"                      Option 1          Option 2\n" +
				"CV Count:          " + usCV_Opt1 + "                       " + usCV_Opt2 + "\n" +
				"Surf Pts:          " + usSurf_Opt1 + "                     " + usSurf_Opt2 + "\n" +
				"Surprise?         " + stratOpt1 + "                       " + stratOpt2;

		//System.out.println(message);

		String[] options = {"Option 1", "Option 2"};

		int response = JOptionPane.showOptionDialog(null, message, "User Choice", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		if (response == 1){
			return new int[] {carrier, surface, transport, retirement, usCV_Opt2, usSurf_Opt2, stratSur_Opt2};
		} else {
			return new int[] {carrier, surface, transport, retirement, usCV_Opt1, usSurf_Opt1, stratSur_Opt1};
		}
	}

	private void printSettings(int dieRoll){
		System.out.println("Die roll - " + dieRoll);
		System.out.println("Carrier Limit - " + japaneseCarrierLimit);
		System.out.println("Surface Limit - " + japaneseSurfaceLimit);
		System.out.println("Transport Limit - " + japaneseTransportLimit);
		System.out.println("Retirement Limit - " + japaneseRetirementLimit);
		System.out.println("US Carrier Count - " + usCarrierCount);
		System.out.println("US Surface Points - " + usSurfacePoints);
		System.out.println("Strategic Surprise? - " + strategicSurprise);
	}

	public int getJapaneseCarrierLimit() {
		return japaneseCarrierLimit;
	}

	public int getJapaneseSurfaceLimit() {
		return japaneseSurfaceLimit;
	}

	public int getJapaneseTransportLimit() {
		return japaneseTransportLimit;
	}

	public int getJapaneseRetirementLimit() {
		return japaneseRetirementLimit;
	}

	public int getUsCarrierCount() {
		return usCarrierCount;
	}

	public int getUsSurfacePoints() {
		return usSurfacePoints;
	}

	public boolean isStrategicSurprise() {
		return strategicSurprise;
	}
}
