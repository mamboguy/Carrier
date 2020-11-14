package Model.Intelligence;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

/**
 Interface for all IForces to handle their intelligence level
 */
public interface IIntelligence {

	/**
	 Intel Level of the force's current intelligence
	 @return
	 */
	IntelLevel intelligenceLevel();

	/**
	 Upgrades the intelligence of the force
	 */
	void upgradeIntelligence();

	/**
	 Downgrades the intelligence of the force
	 */
	void downgradeIntelligence();

	/**
	 Prints the current intel settings to the console if called
	 */
    void printSettings();
}
