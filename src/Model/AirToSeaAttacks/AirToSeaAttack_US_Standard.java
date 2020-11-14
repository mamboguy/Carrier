package Model.AirToSeaAttacks;

import Controller.Die;
import Controller.GameMaster.GameSettings;
import Model.Enums.ScenarioPeriod;
import Model.Forces.IForce;
import Model.Forces.IStrikeForce;

public class AirToSeaAttack_US_Standard extends AirToSeaAttack{

    private boolean isSurpriseCAP;
    private boolean isSurprisePlanesOnDeck;

    public AirToSeaAttack_US_Standard(IForce shipFleet, IStrikeForce strikeForce, boolean isSurpriseCAP, boolean isSurprisePlanesOnDeck) {
        super(shipFleet, strikeForce);
        this.isSurpriseCAP = isSurpriseCAP;
        this.isSurprisePlanesOnDeck = isSurprisePlanesOnDeck;
    }

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
    protected void combatVSCAP() {

        //Get the strength of the enemy force's CAP
        int capStrength = lookupCAPStrength(shipFleet.getAirValue());

        //Lookup how many losses are the result of that CAP strength
        int losses = lookupCAPLosses(capStrength);

        //if the target has no CAP, then all attacks get an additional +1 modifier
        if (capStrength == 0){
            allAttacksModifier++;
        }

        askUserForCAPLosses(losses);
    }

    @Override
    protected void aaFireResolution() {

        if (!isSurprisePlanesOnDeck){
            //Get the index array for the fleet's AA value
            int aaArrayIndex = super.getAAIndex(shipFleet.getAAValue());

            //Get the modifiers for the die roll
            int modifiers = getAADieModifiers();

            //Roll die and adjust for an array
            die.rollDie();
            int dieRoll = die.getBoundedLastRoll_ArrayResult(modifiers, 12, 1);

            //US loses twice the number of steps of result of AA Fire Table
            int losses = 2 * super.getAALosses(aaArrayIndex, dieRoll);

            //Let the user determine combat losses
            askUserForAALosses(losses);
        } else {
            informUserOfMessage("SURPRISE!/n/nYou caught the enemy with planes on the flight deck and the enemy are" +
                                        "unwilling to fire their AA guns right now.");

            //Strike will suffer no losses to AA fire since it is prevented
        }
    }

    @Override
    protected void airAttackTableLookup() {

        //Get the forces attack value
        int strength = strikeForce.getAttackForceAttackValue();

        double modifier = 1.0;

        //Determine the modifier if the strike is coordinated
        if (strikeForce.isCoordinated()){
            if (GameSettings.instance().getScenarioPeriod() == ScenarioPeriod.Jan_July_42){
                modifier = 1.25;
            } else {
                modifier = 1.5;
            }
        }

        //Get finalized attack strength
        double attackStrength = modifier * strength;

        //Get the dice and their modifiers added
        lookupAirAttackDieRollChart(attackStrength);
    }

    @Override
    protected int addSpecificModifiers() {
        return isSurprisePlanesOnDeck ? 5 : 0;
    }

    @Override
    protected void targetSelection() {
        // TODO: 2020-11-14 Add popup asking user which dice to apply to which ships
    }

    @Override
    protected void applyDamageToShips() {

    }

    /**
     * Looks up the CAP strength of the enemy fleet and returns the number strength of the Japanese CAP
     * @param enemyAirValue - The air value strength of the enemy fleet
     * @return - Size of CAP
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

    /**
     Determines losses for the strike due to Japanese CAP
     @param capStrength - The strength of the CAP
     @return - number of planes to lose
     */
    private int lookupCAPLosses(int capStrength) {

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

        // Surprise - CAP (-1 modifier)
        if (isSurpriseCAP){
            modifiers -= 1;
        }

        // Surprise - Planes on Deck (-2 modifier)
        if (isSurprisePlanesOnDeck){
            modifiers -= 2;
        }

        //Roll die and check with modifiers
        die.rollDie();
        return die.getBoundedLastRoll(modifiers, 11, 1);
    }

    private int getAADieModifiers() {
        int modifiers = 0;

        //All fire receives a -1 modifier if in the first part of 1942
        if (GameSettings.instance().getScenarioPeriod().getPeriod() == ScenarioPeriod.Jan_July_42){
            modifiers -= 1;
        }

        //"Surprise - CAP" modifier of -2 if active
        if (isSurpriseCAP){
            modifiers -= 2;
        }

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

    private void informUserOfMessage(String message) {
        // TODO: 2020-11-14 - Implement me
        //User will be given a popup that informs them of the message (usually surprise)
    }

    private void askUserForAALosses(int losses) {
        //TODO 10/26/2020 - Implement me
        //Can combine with CAP losses and make an IUserPrompt class that passes in a new prompt?
    }
}
