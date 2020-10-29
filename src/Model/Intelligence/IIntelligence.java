package Model.Intelligence;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public interface IIntelligence {

	IntelLevel intelligenceLevel();

	void upgradeIntelligence();

	void downgradeIntelligence();

    void printSettings();
}
