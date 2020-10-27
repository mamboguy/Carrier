package Model.Intelligence.Other;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.IntelLevel;
import Model.Intelligence.Intelligence;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level4Model
		extends Intelligence {

	private int cvCount;
	private int cveCount;
	private int cvlCount;
	private int bbCount;
	private int caCount;
	private int clCount;
	private int ddCount;
	private int transportCount;

	public Level4Model(int cvCount, int cveCount, int cvlCount, int bbCount, int caCount, int clCount, int ddCount, int transportCount) {
		this.cvCount = cvCount;
		this.cveCount = cveCount;
		this.cvlCount = cvlCount;
		this.bbCount = bbCount;
		this.caCount = caCount;
		this.clCount = clCount;
		this.ddCount = ddCount;
		this.transportCount = transportCount;
	}

	public int getCvCount() {
		return cvCount;
	}

	public int getCveCount() {
		return cveCount;
	}

	public int getCvlCount() {
		return cvlCount;
	}

	public int getTransportCount() {
		return transportCount;
	}

	public int getBbCount() {
		return bbCount;
	}

	public int getCaCount() {
		return caCount;
	}

	public int getClCount() {
		return clCount;
	}

	public int getDdCount() {
		return ddCount;
	}

	@Override
	public IntelLevel intelligenceLevel() {
		return IntelLevel.Level4;
	}

	//Level 4 intelligence never changes
	@Override
	protected int getModifiers() {
		return 0;
	}

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {
		return this;
	}

	@Override
	public IIntelligence downgradeIntelligence() {
		return this;
	}
}
