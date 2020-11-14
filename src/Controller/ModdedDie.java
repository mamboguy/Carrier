package Controller;

/**
 Created on 14 Nov 2020

 @Author - Mambo */

public class ModdedDie extends Die {

	private int inherentModifier;

	public ModdedDie(int sides, int inherentModifier) {
		super(sides);

		this.inherentModifier = inherentModifier;
	}

	@Override
	public void rollDie() {
		super.rollDie();

		lastRoll += inherentModifier;
	}
}
