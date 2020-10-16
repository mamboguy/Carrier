package Controller.GameMaster;

import Controller.Die;
import Model.Enums.ScenarioPeriod;
import Model.Settings.JapaneseCommitmentAndUSForces;
import Model.Settings.JapaneseIndexes;
import Model.Settings.JapaneseObjective;

public class GameSettings {

    //<editor-fold defaultstate="collapsed" desc="Define as Singleton">
    private static GameSettings instance = null;

    protected GameSettings() {
        Die die = new Die(10);
        die.rollDie();

        //First generate the time period
        generateTimePeriod(die.getLastRoll());

        //Japanese objective is next
        japaneseObjective = new JapaneseObjective(scenario);

        //Generate commitments
        commitments = new JapaneseCommitmentAndUSForces(scenario, japaneseObjective.hasSecondaryObjective());
        indexes = new JapaneseIndexes();
    }

    public static GameSettings instance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }

    //</editor-fold>
    private ScenarioPeriod scenario;

    private JapaneseObjective japaneseObjective;
    private JapaneseCommitmentAndUSForces commitments;
    private JapaneseIndexes indexes;

    public JapaneseCommitmentAndUSForces getCommitments() {
        return commitments;
    }

    public JapaneseIndexes getIndexes() {
        return indexes;
    }

    public JapaneseObjective getJapaneseObjective() {
        return japaneseObjective;
    }

    public ScenarioPeriod getScenarioPeriod() {
        return scenario;
    }

    private void generateTimePeriod(int lastRoll) {
        switch (lastRoll){
            case 1:
            case 2:
            case 3:
                scenario = ScenarioPeriod.Jan_July_42;
                break;
            case 4:
            case 5:
            case 6:
                scenario = ScenarioPeriod.Aug_Sept_42;
                break;
            case 7:
            case 8:
            case 9:
                scenario = ScenarioPeriod.Oct_Dec_42;
                break;
            case 10:
                scenario = ScenarioPeriod.Year_1943;
                break;
        }

        System.out.println("Period - " + scenario.getTimeframe() + "(" + lastRoll + ")\n");
    }
}
