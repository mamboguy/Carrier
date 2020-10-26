package Model.Settings;

import Controller.GameMaster.GameSettings;

/**
 Created on 12 Oct 2020

 @Author - Mambo */

public class JapaneseIndexes {

	private int carrierIndex;
	private int surfaceIndex;
	private int transportIndex;
	private int retirementIndex;

	public JapaneseIndexes() {
		this.carrierIndex = 0;
		this.surfaceIndex = 0;
		this.transportIndex = 0;
		this.retirementIndex = 0;
	}

	public int getCarrierIndex() {
		return carrierIndex;
	}

	public void addCarrierIndex(int carrierIndex) {
		this.carrierIndex += carrierIndex;
	}

	public int getSurfaceIndex() {
		return surfaceIndex;
	}

	public void addSurfaceIndex(int surfaceIndex) {
		this.surfaceIndex += surfaceIndex;
	}

	public int getTransportIndex() {
		return transportIndex;
	}

	public void addTransportIndex(int transportIndex) {
		this.transportIndex += transportIndex;
	}

	public int getRetirementIndex() {
		return retirementIndex;
	}

	public void addRetirementIndex(int retirementIndex) {
		this.retirementIndex += retirementIndex;
	}

	public boolean isCarrierCommitWithinXOfLimit(int i) {
		int commitLimit = GameSettings.instance().getCommitments().getJapaneseCarrierLimit();

		return ((commitLimit - this.carrierIndex) <= i);
	}
}
