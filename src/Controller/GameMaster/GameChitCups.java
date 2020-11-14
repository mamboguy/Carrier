package Controller.GameMaster;

import Controller.Die;
import Model.Intelligence.IIntelligenceModel;
import Model.Intelligence.Level1.*;
import Model.Intelligence.Level2.*;
import Model.Intelligence.Other.DummyModel;
import java.util.ArrayList;

public class GameChitCups {

    private ArrayList<IIntelligenceModel> intelligenceChitCup;
    private Die die;
    private IIntelligenceModel lastDrawnChit;

    //<editor-fold defaultstate="collapsed" desc="Define as Singleton">
    private static GameChitCups instance = null;

    private GameChitCups() {

        resetChitCup();
    }

    private ArrayList<IIntelligenceModel> insertChits(IIntelligenceModel model, int count) {
        ArrayList<IIntelligenceModel> temp = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            temp.add(model);
        }

        return temp;
    }

    public static GameChitCups instance() {
        if (instance == null) {
            instance = new GameChitCups();
        }

        return instance;
    }
    //</editor-fold>

    public IIntelligenceModel drawAndRemoveForceChitIntel(){
        die.rollDie();

        //Draw and remove from the chit cup
        lastDrawnChit = intelligenceChitCup.get(die.getLastRoll() - 1);
        intelligenceChitCup.remove(die.getLastRoll() - 1);

        die = new Die(intelligenceChitCup.size());

        return lastDrawnChit;
    }

    public void returnLastDrawnChit(){
        if (lastDrawnChit != null){
            intelligenceChitCup.add(lastDrawnChit);
            lastDrawnChit = null;
        }
    }

    public void resetChitCup() {
        intelligenceChitCup = new ArrayList<>();

        //Add 7x Level 1 Carrier
        intelligenceChitCup.addAll(insertChits(new Level1_Carrier(), 7));
        //Add 7x Level 1 Surface
        intelligenceChitCup.addAll(insertChits(new Level1_Surface(), 7));
        //Add 3x Level 1 Large
        intelligenceChitCup.addAll(insertChits(new Level1_Large(), 3));
        //Add 3x Level 1 Medium
        intelligenceChitCup.addAll(insertChits(new Level1_Medium(), 3));
        //Add 2x Level 1 Small
        intelligenceChitCup.addAll(insertChits(new Level1_Small(), 2));
        //Add 2x Level 2 1-2 Carrier
        intelligenceChitCup.addAll(insertChits(new Level2_1or2CV(), 2));
        //Add 1x Level 2 2-3 Carrier
        intelligenceChitCup.addAll(insertChits(new Level2_2or3CV(), 1));
        //Add 1x Level 2 3+ Carrier
        intelligenceChitCup.addAll(insertChits(new Level2_3PlusCV(), 1));
        //Add 1x Level 2 Large Surface
        intelligenceChitCup.addAll(insertChits(new Level2_LgSurface(), 1));
        //Add 3x Level 2 Medium Surface
        intelligenceChitCup.addAll(insertChits(new Level2_MedSurface(), 3));
        //Add 2x Level 2 Small Surface
        intelligenceChitCup.addAll(insertChits(new Level2_SmSurface(), 2));
        //Add 28 Dummies
        intelligenceChitCup.addAll(insertChits(new DummyModel(), 28));

        die = new Die(intelligenceChitCup.size());
    }
}
