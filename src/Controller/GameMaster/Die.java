package Controller.GameMaster;

/**
 Created on 03 Aug 2020

 @Author - Mambo */

public class Die {

	private int lastRoll;
	private int sides;

	public Die(int sides) {
		this.sides = sides;
	}

	public void rollDie() {
		this.lastRoll = (int) (Math.random() * sides) + 1;
	}

	public int getLastRoll() {
		return lastRoll;
	}

	public boolean isNaturalOne() {
		return lastRoll == 1;
	}

	public int getBoundedLastRoll(int modifier, int upperBound, int lowerBound) {
		if (lastRoll + modifier >= upperBound) {
			return upperBound;
		} else if (lastRoll + modifier <= lowerBound) {
			return lowerBound;
		} else {
			return lastRoll + modifier;
		}
	}
}
