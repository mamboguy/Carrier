package Model.Intelligence;

import Model.Forces.IForce;

public interface IIntelligenceModel {

    /**
     The highest number that can be rolled on the chart for this intel upgrade
     @return - The upper bound the die can roll
     */
    int upperChartNumber();

    /**
     The lowest number that can be rolled on the chart for this intel upgrade
     @return - The lower bound the die can roll
     */
    int lowerChartNumber();

    /**
     Gets the modifiers to use when upgrading the intelligence level
     @param force - The force that is having its intel upgraded
     @return - The final integer value of all modifiers being used
     */
    int getModifiers(IForce force);

    /**
     Upgrades the current intelligence model to the next
     @return - The new model to use
     @param dieRoll - die roll to use to upgrade
     @param parent - the parent force to reference if needed
     @param wasNaturalTen
     */
    IIntelligenceModel upgradeIntelligence(int dieRoll, IForce parent, boolean wasNaturalTen);

    /**
     Downgrades the current intelligence model
     @return - the downgraded model
     */
    IIntelligenceModel downgradeIntelligence();

    /**
     Current level of intelligence for the force
     @return - IntelLevel of the force
     */
    IntelLevel getIntelLevel();

    /**
     Returns the model's current settings
     @return - String representation of model's current settings to print to console
     */
    String printSettings();
}
