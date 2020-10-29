package Model.Intelligence.Other;

import Controller.GameMaster.GameSettings;
import Model.Forces.IForce;
import Model.Intelligence.*;
import Model.Ships.Ship;

import java.util.ArrayList;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level4Model implements IIntelligenceModel {

	private int cvCount;
	private int cveCount;
	private int cvlCount;
	private int bbCount;
	private int caCount;
	private int clCount;
	private int ddCount;
	private int transportCount;

	private boolean hasGeneratedShips = false;

	private ArrayList<Ship> shipList = new ArrayList<>();

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

	public ArrayList<Ship> generateShips() {

		//Only allow a Level 4 model to generate ships once
		if (!hasGeneratedShips){
			shipList.addAll(GameSettings.instance().getJapaneseShipFactory().giveCarrier(cvCount));
			shipList.addAll(GameSettings.instance().getJapaneseShipFactory().giveCarrier_Escort(cveCount));
			shipList.addAll(GameSettings.instance().getJapaneseShipFactory().giveCarrier_Light(cvlCount));
			shipList.addAll(GameSettings.instance().getJapaneseShipFactory().giveBattleship(bbCount));
			shipList.addAll(GameSettings.instance().getJapaneseShipFactory().giveCruiser_CA(caCount));
			shipList.addAll(GameSettings.instance().getJapaneseShipFactory().giveCruiser_CL(clCount));
			shipList.addAll(GameSettings.instance().getJapaneseShipFactory().giveDestroyer(ddCount));
			shipList.addAll(GameSettings.instance().getJapaneseShipFactory().giveTransport(transportCount));

			hasGeneratedShips = true;
		}

		return shipList;
	}

	public boolean hasEnoughShips(){
		return GameSettings.instance().getJapaneseShipFactory().hasEnoughShips(cvCount, cveCount, cvlCount, bbCount, caCount, clCount, ddCount);
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

	public void addShips(int cvCount, int cveCount, int cvlCount, int bbCount, int caCount, int clCount, int ddCount, int transportCount){
		this.cvCount += cvCount;
		this.cveCount += cveCount;
		this.cvlCount += cvlCount;
		this.bbCount += bbCount;
		this.caCount += caCount;
		this.clCount += clCount;
		this.ddCount += ddCount;
		this.transportCount += transportCount;
	}

	public String printSettings(){
		for (Ship item : shipList){
			System.out.println("  - IJN " + item.getShipName() + " (" + item.getShortTypeName() + ")");
		}

		return "";
	}

	//Level 4 intelligence never changes
	@Override
	public int upperChartNumber() {
		return 0;
	}

	@Override
	public int lowerChartNumber() {
		return 0;
	}

	@Override
	public int getModifiers(IForce force) {
		return 0;
	}

	@Override
	public IIntelligenceModel upgradeIntelligence(int dieRoll, IForce parent) {
		return this;
	}

	@Override
	public IIntelligenceModel downgradeIntelligence() {
		return this;
	}

	@Override
	public IntelLevel getIntelLevel() {
		return IntelLevel.Level4;
	}
}
