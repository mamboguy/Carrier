package Model.Ships.DamageAndRepairModels;

/**
 Created on 02 Aug 2020

 @Author - Mambo */

public class NonCarrierDamageModel
		extends BasicDamageModel
		implements IDamageModel {

	public NonCarrierDamageModel(int maximumHP) {
		super(maximumHP);
	}

	//Non-carriers do not implement light, medium or dead in water mechanics

	@Override
	public boolean isLightlyDamaged() {
		return false;
	}

	@Override
	public boolean isMediumDamaged() {
		return false;
	}

	@Override
	public boolean isHeavilyDamaged() {
		//Heavily damaged if it is less than or equal to half the maximum HP of the ship
		return (super.maximumHP % 2 == 1) ? (super.currentHP <= (super.maximumHP - 1)) : (super.currentHP <= super.maximumHP / 2);
	}

	@Override
	public boolean isDeadInWater() {
		return false;
	}

	//Non carrier ships don't have flight decks

	@Override
	public boolean receiveINOPMarkers(int currHP) {
		return false;
	}

	@Override
	public boolean canLaunchPlanes() {
		return false;
	}

	@Override
	public boolean isFlightDeckINOP() {
		return false;
	}

	@Override
	public int getFlightDeckCounters() {
		return 0;
	}

	@Override
	public void repair() {
		//Do nothing since non-carrier ships don't have a repair model
	}

}
