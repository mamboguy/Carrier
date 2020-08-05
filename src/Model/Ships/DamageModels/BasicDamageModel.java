package Model.Ships.DamageModels;

/**
 Created on 03 Aug 2020

 @Author - Mambo */

public abstract class BasicDamageModel
		implements IDamageModel {

	int currentHP;
	int inopMarkers;
	final int maximumHP;

	public BasicDamageModel(int maximumHP) {
		this.currentHP = maximumHP;
		this.maximumHP = maximumHP;

		inopMarkers = 0;
	}

	/**
	 Applies damage to the ship based off the damage model

	 @param numberOfHits - the number of hits to apply to the ship
	 */
	public void applyDamage(int numberOfHits) {

		//Create a holder for new markers
		int newINOPMarkers = 0;

		//Apply all hits one at a time
		for (int i = 0; i < numberOfHits; i++) {

			//Check to see if another INOP deck marker applies
			//This is done first since the rules dictate that a carrier has to be AT a damage level of "M" or
			//higher and receive a hit (EXCEPTION: Victorious only receives if at dmg level of "H" and receives hit
			if (receiveINOPMarkers(currentHP)) {
				newINOPMarkers++;
			}

			//Apply a point of damage to the current HP
			currentHP--;
		}

		//If the carrier gained new inop markers during this attack, add 2 additional INOP markers
		if (newINOPMarkers > 0) {
			inopMarkers += 2;
		}
	}

	/**
	 Request INOP Flight deck markers based on current HP and the number of hits

	 @param currHP - the current HP of the carrier
	 @return - the number of INOP Markers to receive
	 */
	public abstract boolean receiveINOPMarkers(int currHP);

	/**
	 Tells if the ship's flight deck is INOP

	 @return is the flight deck INOP
	 */
	public abstract boolean isFlightDeckINOP();

	/**
	 Gets the number of INOP flight deck markers

	 @return - number of INOP flight deck markers
	 */
	public abstract int getFlightDeckCounters();

	public abstract void repair();

	/**
	 All ships will sink when they have no HP

	 @return Does the ship have 0 HP
	 */
	public boolean isSunk() {
		return currentHP == 0;
	}

	public int getCurrentHP() {
		return currentHP;
	}
}
