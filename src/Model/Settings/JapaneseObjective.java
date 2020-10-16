package Model.Settings;

import Controller.Die;
import Model.Enums.Objective;
import Model.Enums.ScenarioPeriod;

/**
 Created on 12 Oct 2020

 @Author - Mambo */

public class JapaneseObjective {

	private Objective primaryObjective;
	private Objective secondaryObjective;
	private int combatPrimary;
	private int combatSecondary;
	private int transportPrimary;
	private int transportSecondary;
	private boolean isInterdiction;

	public JapaneseObjective(ScenarioPeriod period){

		primaryObjective = null;
		secondaryObjective = null;
		combatPrimary = 20;
		combatSecondary = 0;
		transportPrimary = 6;
		transportSecondary = 0;
		isInterdiction = false;

		Die die = new Die(10);
		die.rollDie();

		switch (period){
			case Jan_July_42:
				janJul42(die.getLastRoll());
				break;
			case Aug_Sept_42:
				augSept42(die.getLastRoll());
				break;
			case Oct_Dec_42:
				octDec42(die.getLastRoll());
				break;
			case Year_1943:
				year1943(die.getLastRoll());
				break;
		}

		printSettings(die.getLastRoll());
	}

	private void printSettings(int dieRoll){
		System.out.println("Die roll = " + dieRoll + "\n" + toString());
	}

	@Override
	public String toString() {

		String secondary = "";

		if (hasSecondaryObjective()){
			secondary = "Secondary Obj: " + secondaryObjective.getName() + "\n" +
					"Combat Power: " + getCombatSecondary() + "  -  Transport Power: " + getTransportSecondary();
		}

		String primary = "Primary Obj: " + primaryObjective.getName() + "\n" +
				"Combat Power: " + getCombatPrimary() + "  -  Transport Power: " + getTransportPrimary();

		return primary + "\n" + secondary + "\n" + "Interdiction?: " + isInterdiction + "\n";
	}

	private void janJul42(int lastRoll) {
		switch (lastRoll){
			case 1:
			case 2:
			case 3:
				primaryObjective = Objective.Moresby;
				break;
			case 4:
				primaryObjective = Objective.Moresby;
				secondaryObjective = Objective.Guadalcanal;
				setPrimary(16, 5);
				break;
			case 5:
			case 6:
				primaryObjective = Objective.Moresby;
				secondaryObjective = Objective.Guadalcanal;
				setPrimary(15, 4);
				break;
			case 7:
				primaryObjective = Objective.Moresby;
				secondaryObjective = Objective.Guadalcanal;
				setPrimary(12, 3);
				break;
			case 8:
				primaryObjective = Objective.Hebrides;
				break;
			case 9:
				primaryObjective = Objective.Hebrides;
				secondaryObjective = Objective.Guadalcanal;
				setPrimary(14, 4);
				break;
			case 10:
				primaryObjective = Objective.Guadalcanal;
				secondaryObjective = Objective.Hebrides;
				setPrimary(14, 4);
				break;
		}
	}

	private void augSept42(int lastRoll) {
		switch (lastRoll){
			case 1:
				primaryObjective = Objective.Moresby;
				break;
			case 2:
				primaryObjective = Objective.Guadalcanal;
				break;
			case 3:
				primaryObjective = Objective.Moresby;
				secondaryObjective = Objective.Guadalcanal;
				setPrimary(14, 4);
				break;
			case 4:
				primaryObjective = Objective.Guadalcanal;
				secondaryObjective = Objective.Hebrides;
				setPrimary(15, 5);
				break;
			case 5:
				primaryObjective = Objective.Guadalcanal;
				secondaryObjective = Objective.Moresby;
				setPrimary(12, 4);
				break;
			case 6:
			case 7:
			case 8:
				primaryObjective = Objective.Guadalcanal;
				break;
			case 9:
				primaryObjective = Objective.Guadalcanal;
				isInterdiction = true;
				break;
			case 10:
				primaryObjective = Objective.Hebrides;
				secondaryObjective = Objective.Guadalcanal;
				setPrimary(14, 4);
				break;
		}
	}

	private void octDec42(int lastRoll) {
		switch (lastRoll){
			case 1:
				primaryObjective = Objective.Moresby;
				break;
			case 2:
				primaryObjective = Objective.Moresby;
				secondaryObjective = Objective.Guadalcanal;
				setPrimary(12, 4);
				break;
			case 3:
				primaryObjective = Objective.Guadalcanal;
				secondaryObjective = Objective.Hebrides;
				setPrimary(14, 4);
				break;
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
				primaryObjective = Objective.Guadalcanal;
				break;
			case 9:
			case 10:
				primaryObjective = Objective.Guadalcanal;
				isInterdiction = true;
				break;
		}
	}

	private void year1943(int lastRoll) {

		isInterdiction = true;

		switch (lastRoll){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				primaryObjective = Objective.Georgia;
				break;
			case 7:
			case 8:
			case 9:
			case 10:
				primaryObjective = Objective.Bougainville;
				break;
		}
	}

	private void setPrimary(int combatPrimary, int transportPrimary) {
		this.combatPrimary = combatPrimary;
		this.combatSecondary = 20 - combatPrimary;
		this.transportPrimary = transportPrimary;
		this.transportSecondary = 6 - transportPrimary;
	}

	public Objective getGetPrimaryObjective() {
		return primaryObjective;
	}

	public Objective getGetSecondaryObjective() {
		return secondaryObjective;
	}

	public int getCombatPrimary() {
		return combatPrimary;
	}

	public int getCombatSecondary() {
		return combatSecondary;
	}

	public int getTransportPrimary() {
		return transportPrimary;
	}

	public int getTransportSecondary() {
		return transportSecondary;
	}

	public boolean hasSecondaryObjective() {
		return secondaryObjective != null;
	}
}
