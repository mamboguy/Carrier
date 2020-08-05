package Controller.GameMaster;

import Model.Enums.ScenarioPeriod;

public class GameSettings {

    //<editor-fold defaultstate="collapsed" desc="Define as Singleton">
    private static GameSettings instance = null;

    protected GameSettings() {
    }

    public static GameSettings instance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }
    //</editor-fold>

    private ScenarioPeriod scenario;

    public void setScenario(ScenarioPeriod scenario) {
        this.scenario = scenario;
    }

    public ScenarioPeriod getScenarioPeriod() {
        return scenario;
    }
}
