package Model.Forces;

import Controller.Die;
import Controller.GameMaster.GameSettings;
import Model.Enums.Objective;

public class JapaneseForce implements IForce{

    private int airValue = -1;
    private boolean hasAirValue;
    private Objective objective;

    public JapaneseForce(){
        Die d = new Die(2);
        d.rollDie();

        if (d.getLastRoll() == 1){
            objective = GameSettings.instance().getJapaneseObjective().getPrimaryObjective();
        } else {
            objective = GameSettings.instance().getJapaneseObjective().getSecondaryObjective();
        }

        d.rollDie();
        hasAirValue = (d.getLastRoll() == 1);

        if (hasAirValue){
            d = new Die(20);
            d.rollDie();

            airValue = d.getLastRoll();
        }

        printSettings();
    }

    @Override
    public int getAirValue() {
        return airValue;
    }

    @Override
    public int getAAValue() {
        return 20;
    }

    @Override
    public boolean hasAirValue() {
        return hasAirValue;
    }

    @Override
    public Objective getObjective() {
        return objective;
    }

    @Override
    public void activate() {
        throw new UnsupportedOperationException();
    }

    private void printSettings(){
        System.out.println("Has Air Value = " + hasAirValue);
        System.out.println("Air Value = " + airValue);
        System.out.println("Primary obj? = " + (GameSettings.instance().getJapaneseObjective().getPrimaryObjective() == objective));
        System.out.println();
    }
}
