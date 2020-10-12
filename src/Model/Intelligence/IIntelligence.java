package Model.Intelligence;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public interface IIntelligence {

	int intelligenceLevel();

	IIntelligence upgradeIntelligence(int dieRoll);

	IIntelligence downgradeIntelligence();
}
