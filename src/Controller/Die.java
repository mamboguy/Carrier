package Controller;

/**
 Created on 03 Aug 2020

 @Author - Mambo */

public class Die {

	protected int lastRoll;
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

	public boolean isNaturalTen(){
		return lastRoll == 10;
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

	public int getBoundedLastRoll_ArrayResult(int modifier, int upperBound, int lowerBound) {
		int roll = lastRoll;

		if (lastRoll + modifier >= upperBound) {
			roll = upperBound;
		} else if (lastRoll + modifier <= lowerBound) {
			roll = lowerBound;
		} else {
			roll =  lastRoll + modifier;
		}

		//Offset the roll so that the lowerbound is equal to 0 (allowing array lookup)
		return roll - lowerBound;
	}
}
