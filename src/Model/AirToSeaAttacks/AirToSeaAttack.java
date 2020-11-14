package Model.AirToSeaAttacks;

import Controller.ModdedDie;
import Model.Forces.IForce;
import Model.Forces.IStrikeForce;

import java.util.ArrayList;

public abstract class AirToSeaAttack {

    protected IForce shipFleet;
    protected IStrikeForce strikeForce;

    protected ArrayList<ModdedDie> attackRolls;
    protected int allAttacksModifier;

    public AirToSeaAttack(IForce shipFleet, IStrikeForce strikeForce){
        this.shipFleet = shipFleet;
        this.strikeForce = strikeForce;
        attackRolls = new ArrayList<>();
        allAttacksModifier = 0;
    }

    //CONSTANTS
    protected static final int[][] AA_FIRE_TABLE = new int[][]{
            // 1, 10, 15, 20, 30, 40, 50, 60, 80, 100, 120+
            {  0, 0,  0,  0,  0,  0,  0,  0,  0,  1,    1}, // <= 1
            {  0, 0,  0,  0,  0,  0,  0,  0,  1,  2,    2}, // 2
            {  0, 0,  0,  0,  0,  0,  1,  1,  1,  2,    2}, // 3
            {  0, 0,  0,  0,  0,  1,  1,  1,  1,  2,    2}, // 4
            {  0, 0,  0,  0,  1,  1,  1,  1,  1,  2,    2}, // 5
            {  0, 0,  0,  0,  1,  1,  1,  1,  1,  2,    2}, // 6
            {  0, 0,  0,  1,  1,  1,  1,  1,  2,  2,    2}, // 7
            {  0, 0,  1,  1,  1,  1,  1,  2,  2,  2,    3}, // 8
            {  0, 1,  1,  1,  1,  1,  2,  2,  2,  3,    3}, // 9
            {  1, 1,  1,  1,  1,  2,  2,  2,  3,  3,    4}, // 10
            {  1, 1,  1,  2,  2,  2,  3,  3,  4,  4,    5}, // 11
    };

    protected static final int[] AA_FIRE_ATTACK_MODIFIER_TABLE = new int[] {
            // 1, 10, 15, 20, 30, 40, 50, 60, 80, 100, 120+
               2, 1,  1,  1,  0,  0,  0,  0,  -1, -1,  -2
    };

    protected int aaFireAttackModifier;

    //Template method for executing an attack
    public void executeAttack(IForce enemyFleet, IStrikeForce strikeForce){

        usWarning();

        //CAP combat, handles losses internally
        combatVSCAP();

        aaFireResolution();

        allAttacksModifier += addSpecificModifiers();

        if (strikeForce.isUnloadingTransport()){
            allAttacksModifier++;
        }

        airAttackTableLookup();

        targetSelection();

        applyDamageToShips();
    }

    /**
     The US Warning phase of an air attack.  Only occurs during Japanese strikes against US fleets
     */
    protected abstract void usWarning();

    /**
     Executes the CAP combat portion of an air attack.
     Is expected to handle what aircraft are lost internally
     */
    protected abstract void combatVSCAP();

    /**
     Executes the AA fire phase of an air attack.
     Is expected to handle what aircraft are lost internally
     */
    protected abstract void aaFireResolution();

    protected abstract void airAttackTableLookup();

    protected abstract int addSpecificModifiers();

    protected abstract void targetSelection();

    protected abstract void applyDamageToShips();

    /**
     Gets the array index to use based off anti-aircraft strength
     @param aaValue - The strength of the fleet's AA
     @return - The index location to reference in the AA table
     */
    protected int getAAIndex(int aaValue) {
        int aaArrayIndex = 0;

        // Generate the index array to lookup the AA value on based onn the fleet's AA value
        if (aaValue >= 10 && aaValue < 15){
            aaArrayIndex = 1;
        } else if (aaValue >= 15 && aaValue < 20){
            aaArrayIndex = 2;
        } else if (aaValue >= 20 && aaValue < 30){
            aaArrayIndex = 3;
        } else if (aaValue >= 30 && aaValue < 40){
            aaArrayIndex = 4;
        } else if (aaValue >= 40 && aaValue < 50){
            aaArrayIndex = 5;
        } else if (aaValue >= 50 && aaValue < 60){
            aaArrayIndex = 6;
        } else if (aaValue >= 60 && aaValue < 80){
            aaArrayIndex = 7;
        } else if (aaValue >= 80 && aaValue < 100){
            aaArrayIndex = 8;
        } else if (aaValue >= 100 && aaValue < 120){
            aaArrayIndex = 9;
        } else if (aaValue >= 120){
            aaArrayIndex = 10;
        }

        return aaArrayIndex;
    }

    /**
     Reference the number of steps to be lost by AA fire based off a die roll and aa strength
     @param aaArrayIndex - The column to reference on the AA chart
     @param dieRoll - The row to reference on the AA chart
     @return - The number of steps lost to AA fire
     */
    protected int getAALosses(int aaArrayIndex, int dieRoll){
        //Set the AA Fire Attack Modifier for the future while computing AA Losses
        allAttacksModifier += AA_FIRE_ATTACK_MODIFIER_TABLE[aaArrayIndex];

        return AA_FIRE_TABLE[aaArrayIndex][dieRoll];
    }

    /**
     Converts the attackStrength of the strike into attack dice
     @param attackStrength - the strength of the strike
     */
    protected void lookupAirAttackDieRollChart(double attackStrength) {
        if (attackStrength >= 87){
            addDice(5, 1);
        } else if (attackStrength >= 73){
            addDice(1, 0);
            addDice(4, 1);
        } else if (attackStrength >= 67){
            addDice(2, 0);
            addDice(3, 1);
        } else if (attackStrength >= 61){
            addDice(4, 1);
        } else if (attackStrength >= 55){
            addDice(1, 0);
            addDice(3, 1);
        } else if (attackStrength >= 49){
            addDice(3, 0);
            addDice(1, 1);
        } else if (attackStrength >= 44){
            addDice(3, 1);
        } else if (attackStrength >= 39){
            addDice(1, 0);
            addDice(2, 1);
        } else if (attackStrength >= 35){
            addDice(3, 0);
        } else if (attackStrength >= 30){
            addDice(2, 1);
        } else if (attackStrength >= 25){
            addDice(1, 0);
            addDice(1, 1);
        } else if (attackStrength >= 21){
            addDice(2, 0);
        } else if (attackStrength >= 18){
            addDice(1, -1);
            addDice(1, 0);
        } else if (attackStrength >= 14){
            addDice(1, 1);
        } else if (attackStrength >= 11){
            addDice(1, 0);
        } else if (attackStrength >= 7){
            addDice(1, -1);
        } else if (attackStrength >= 4){
            addDice(1, -3);
        } else {
            addDice(1, -5);
        }
    }

    /**
     Adds the appropriate number of dice with a modifier
     @param numOfDice - number of dice to add
     @param modifier - modifier for each die
     */
    private void addDice(int numOfDice, int modifier){
        for (int i = 0; i < numOfDice; i++) {
            attackRolls.add(new ModdedDie(10, modifier + allAttacksModifier));
        }
    }
}
