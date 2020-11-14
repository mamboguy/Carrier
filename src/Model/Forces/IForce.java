package Model.Forces;

import Model.Enums.Objective;

public interface IForce {

    int getAirValue();

    int getAAValue();

    boolean hasAirValue();

    Objective getObjective();

    void activate();
}

