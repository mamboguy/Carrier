package Model.AirToSeaAttacks;

import Controller.Die;
import Controller.GameMaster.GameSettings;
import Model.Enums.ScenarioPeriod;
import Model.Forces.IForce;
import Model.Forces.IStrikeForce;

public class AirToSeaAttack_US_Standard extends AirToSeaAttack{

    private static final int[][] capStrengthTable = new int[][] {
            //4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
            { 0, 0, 0, 0, 0, 0, 0,  0,  0,  0,  0,  0,  0,  1,  1,  1,  1}, // <= -2
            { 0, 0, 0, 0, 0, 0, 0,  1,  1,  1,  1,  1,  1,  1,  2,  2,  2}, // -1
            { 0, 0, 0, 0, 1, 1, 1,  1,  1,  1,  1,  1,  1,  2,  2,  2,  2}, // 0
            { 0, 0, 1, 1, 1, 1, 1,  1,  1,  1,  1,  2,  2,  2,  2,  2,  3}, // 1
            { 0, 0, 1, 1, 1, 1, 1,  1,  1,  1,  2,  2,  2,  2,  2,  2,  3}, // 2
            { 0, 1, 1, 1, 1, 1, 1,  1,  1,  2,  2,  2,  2,  2,  2,  3,  3}, // 3
            { 1, 1, 1, 1, 1, 1, 2,  2,  2,  2,  2,  2,  2,  2,  3,  3,  3}, // 4
            { 1, 1, 1, 1, 1, 1, 2,  2,  2,  2,  2,  2,  2,  3,  3,  3,  4}, // 5
            { 1, 1, 1, 1, 1, 1, 2,  2,  2,  2,  2,  3,  3,  3,  3,  4,  4}, // 6
            { 1, 1, 1, 1, 1, 2, 2,  2,  2,  2,  3,  3,  3,  3,  4,  4,  4}, // 7
            { 1, 1, 1, 1, 2, 2, 2,  2,  2,  3,  3,  3,  3,  4,  4,  4,  4}, // 8
            { 1, 1, 1, 2, 2, 2, 2,  2,  3,  3,  3,  3,  4,  4,  4,  4,  4}, // 9
            { 1, 1, 2, 2, 2, 2, 2,  3,  3,  3,  3,  4,  4,  4,  4,  4,  4}, // 10
    };

    private static final int[][] capResultsTable = new int[][]{
            {0, 0, 0, 0}, // <= 1
            {0, 0, 0, 0}, // 2
            {0, 0, 0, 0}, // 3
            {0, 0, 0, 0}, // 4
            {0, 0, 0, 0}, // 5
            {0, 0, 0, 1}, // 6
            {0, 0, 1, 1}, // 7
            {0, 1, 1, 1}, // 8
            {1, 1, 1, 2}, // 9
            {1, 1, 2, 2}, // 10
            {2, 2, 3, 4}, // 11+
    };

    private Die die = new Die(10);

    @Override
    protected void usWarning() {
        //US Attacks do not have a US Warning phase, so do nothing
    }

    @Override
    protected void combatVSCAP(IForce shipFleet, IStrikeForce strikeForce) {

        //Get the strength of the enemy force's CAP
        int capStrength = lookupCAPStrength(shipFleet.getAirValue());

        //Lookup how many losses are the result of that CAP strength
        int losses = lookupCAPLosses(capStrength, strikeForce);

        askUserForCAPLosses(losses);
    }

    @Override
    protected void aaFireResolution(IForce shipFleet, IStrikeForce strikeForce) {

        //TODO 10/26/2020 - Implement skipping all steps if Surprise - Planes on Deck

        //Get the index array for the fleet's AA value
        int aaArrayIndex = super.getAAIndex(shipFleet.getAAValue());

        //Get the modifiers for the die roll
        int modifiers = getAADieModifiers(shipFleet, strikeForce);

        //Roll die and adjust for an array
        die.rollDie();
        int dieRoll = die.getBoundedLastRoll_ArrayResult(modifiers, 12, 1);

        //US loses twice the number of steps of result of AA Fire Table
        int losses = 2 * super.getAALosses(aaArrayIndex, dieRoll);

        //Let the user determine combat losses
        askUserForAALosses(losses);
    }

    @Override
    protected void airAttackTableLookup() {

    }

    @Override
    protected void targetSelection() {

    }

    @Override
    protected void applyDamageToShips() {

    }

    /**
     * Looks up the CAP strength of the enemy fleet and returns the number of STEPS lost to Japanese CAP
     * @param enemyAirValue - The air value strength of the enemy fleet
     * @return - Number of lost steps due to CAP
     */
    private int lookupCAPStrength(int enemyAirValue){

        //Determine the modifier for strategic surprise
        int modifiers = 0;

        if (GameSettings.instance().getCommitments().isStrategicSurprise()){
            modifiers = -3;
        }

        //Roll the die and get result
        die.rollDie();
        int dieRoll = die.getBoundedLastRoll_ArrayResult(modifiers, 10, -2);

        //Lookup the CAP strength on the Japanese CAP Strength Table and return result
        return capStrengthTable[enemyAirValue][dieRoll];
    }

    private int lookupCAPLosses(int capStrength, IStrikeForce strikeForce) {

        int modifiers = 0;

        if (strikeForce.hasTBDs()){
            modifiers -= 1;
        }

        //If the strike has no fighter escort or if the fighter escort is less than half the CAP force
        if (!strikeForce.hasEscorts() ||
                strikeForce.getEscortSize() < (Math.floor(capStrength / 2))){
            modifiers += 1;
        }

        //If the strike force is more than double the size of the enemy CAP
        if (Math.floor(strikeForce.getEscortSize() / 2) > capStrength) {
            modifiers -= 1;
        }

        //TODO 10/26/2020 - Implement Surprise mechanic (Surprise - Planes on Deck & Surprise - CAP)
        // Surprise - Planes on Deck (-2 modifier)
        // Surprise - CAP (-1 modifier)

        //Roll die and check with modifiers
        die.rollDie();
        return die.getBoundedLastRoll(modifiers, 11, 1);
    }

    private int getAADieModifiers(IForce shipFleet, IStrikeForce strikeForce) {
        int modifiers = 0;

        //All fire receives a -1 modifier if in the first part of 1942
        if (GameSettings.instance().getScenarioPeriod().getPeriod() == ScenarioPeriod.Jan_July_42){
            modifiers -= 1;
        }

        //TODO 10/26/2020 - Implement "Surprise - CAP" modifier of -2 if active

        //Get modifier for strike force size
        if (strikeForce.getAttackForceSize() <= 4){
            modifiers -= 3;
        } else if (strikeForce.getAttackForceSize() >= 5 && strikeForce.getAttackForceSize() <= 8) {
            modifiers -= 1;
        } else if (strikeForce.getAttackForceSize() >= 14) {
            modifiers += 2;
        }

        //US +3 modifier does not apply when attacking Japanese fleet
        //Not a japanese strike, so no Rabaul modifier

        return modifiers;
    }

    private void askUserForCAPLosses(int losses) {
        //TODO 10/26/2020 - Implement me
        //User will be given a popup that requests they distribute losses to the attacking force
    }

    private void askUserForAALosses(int losses) {
        //TODO 10/26/2020 - Implement me
        //Can combine with CAP losses and make an IUserPrompt class that passes in a new prompt?
    }
}
