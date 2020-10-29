package Model.Intelligence;

import Model.Forces.IForce;

public interface IIntelligenceModel {

    int upperChartNumber();

    int lowerChartNumber();

    int getModifiers(IForce force);

    IIntelligenceModel upgradeIntelligence(int dieRoll, IForce parent);

    IIntelligenceModel downgradeIntelligence();

    IntelLevel getIntelLevel();

    String printSettings();
}
