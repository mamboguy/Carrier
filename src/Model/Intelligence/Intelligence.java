package Model.Intelligence;

import Controller.Die;
import Model.Forces.IForce;
import Model.Intelligence.Other.Level0Model;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Intelligence implements IIntelligence{

	private Die die;
	protected IForce parent;
	private IIntelligenceModel intelModel;

	public Intelligence(IForce parent){
		this.die = new Die(10);
		this.parent = parent;
		intelModel = new Level0Model();
	}

	protected int getDieRoll(){
		die.rollDie();

		System.out.print("(" + die.getBoundedLastRoll(intelModel.getModifiers(parent), intelModel.upperChartNumber(), intelModel.lowerChartNumber()) + ")");

		//Roll the die with the necessary modifiers
		return die.getBoundedLastRoll(intelModel.getModifiers(parent), intelModel.upperChartNumber(), intelModel.lowerChartNumber());
	}

	protected boolean isLastRollNaturalTen(){
		return die.isNaturalTen();
	}

	@Override
	public IntelLevel intelligenceLevel() {
		return intelModel.getIntelLevel();
	}

	@Override
	public void upgradeIntelligence() {
		intelModel = intelModel.upgradeIntelligence(getDieRoll(), parent);
	}

	@Override
	public void downgradeIntelligence() {
		intelModel = intelModel.downgradeIntelligence();
	}

	@Override
	public void printSettings() {
		System.out.println(intelModel.printSettings());
	}

	public IIntelligenceModel getIntelModel() {
		return intelModel;
	}

	public void setIntelModel(IIntelligenceModel intelModel) {
		this.intelModel = intelModel;
	}
}
