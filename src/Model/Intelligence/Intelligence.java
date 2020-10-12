package Model.Intelligence;

import Controller.Die;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public abstract class Intelligence implements IIntelligence{

	private Die die;

	public Intelligence(){
		die = new Die(10);
	}

	protected int getDieRoll(){
		die.rollDie();

		//Roll the die with the necessary modifiers
		return die.getBoundedLastRoll(getModifiers(), 1, 10);
	}

	protected boolean isLastRollNaturalTen(){
		return die.isNaturalTen();
	}

	protected abstract int getModifiers();
}
