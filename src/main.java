import Controller.Die;
import Controller.GameMaster.GameSettings;
import Model.Factories.JapaneseShipFactory;
import Model.Forces.JapaneseForce;
import Model.Intelligence.IIntelligence;
import Model.Intelligence.IntelLevel;
import Model.Intelligence.Intelligence;
import Model.Intelligence.Level1.Level1_Carrier;
import Model.Intelligence.Other.Level0Model;
import Model.Intelligence.Other.Level4Model;
import Model.Ships.Ship;

import java.util.ArrayList;

/**
 Date Created Feb 20, 2017

 @author Michael C */
public class main {

    public static void main(String[] args) {

        //testShips();

        System.out.println("-------------------------------------");

        testIntelUpgrade();

    }

    private static void testShips() {
        int cvCount = 1;
        int cveCount = 1;
        int cvlCount = 1;
        int battleships = 2;
        int cruiserCA = 3;
        int cruiserCL = 3;
        int destroyers = 12;

        System.out.println();
        printShipNames(GameSettings.instance().getJapaneseShipFactory().giveCarrier(cvCount));
        printShipNames(GameSettings.instance().getJapaneseShipFactory().giveCarrier_Escort(cveCount));
        printShipNames(GameSettings.instance().getJapaneseShipFactory().giveCarrier_Light(cvlCount));
        printShipNames(GameSettings.instance().getJapaneseShipFactory().giveBattleship(battleships));
        printShipNames(GameSettings.instance().getJapaneseShipFactory().giveCruiser_CA(cruiserCA));
        printShipNames(GameSettings.instance().getJapaneseShipFactory().giveCruiser_CL(cruiserCL));
        printShipNames(GameSettings.instance().getJapaneseShipFactory().giveDestroyer(destroyers));
    }

    private static void printShipNames(ArrayList<Ship> shipList) {
        int size = shipList.size();
        System.out.println("Category: " + shipList.get(0).getShortTypeName());

        for (Ship item : shipList){
            System.out.println("  - " + item.getShipName());
        }
    }

    private static void testIntelUpgrade(){
        Intelligence temp = new Intelligence(new JapaneseForce());

        while (true){

            if (temp.intelligenceLevel() == IntelLevel.Dummy){
                temp.setIntelModel(new Level0Model());
            }

            if (temp.intelligenceLevel() == IntelLevel.Level4){
                break;
            }

            temp.printSettings();
            temp.upgradeIntelligence();
        }

        Level4Model full = ((Level4Model) temp.getIntelModel());

        full.generateShips();
        full.printSettings();
    }
}
