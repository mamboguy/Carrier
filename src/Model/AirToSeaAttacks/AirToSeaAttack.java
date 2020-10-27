package Model.AirToSeaAttacks;

import Model.Forces.IForce;
import Model.Forces.IStrikeForce;

public abstract class AirToSeaAttack {

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
        combatVSCAP(enemyFleet, strikeForce);

        aaFireResolution(enemyFleet, strikeForce);

        airAttackTableLookup();

        targetSelection();

        applyDamageToShips();
    }

    protected abstract void usWarning();

    protected abstract void combatVSCAP(IForce enemyFleet, IStrikeForce strikeForce);

    protected abstract void aaFireResolution(IForce enemyFleet, IStrikeForce strikeForce);

    protected abstract void airAttackTableLookup();

    protected abstract void targetSelection();

    protected abstract void applyDamageToShips();

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

    protected int getAALosses(int aaArrayIndex, int dieRoll){
        //Set the AA Fire Attack Modifier for the future while computing AA Losses
        aaFireAttackModifier = AA_FIRE_ATTACK_MODIFIER_TABLE[aaArrayIndex];

        return AA_FIRE_TABLE[aaArrayIndex][dieRoll];
    }
}
