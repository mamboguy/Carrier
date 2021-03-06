package Model.Plane;

import Model.Plane.MovementModels.IPlaneMoveModel;
import Model.Plane.MovementModels.AloftMovement;

/**
 * Created on 04 Aug 2020
 *
 * @Author - Mambo
 */

public class Plane {

    private static int planeID = 0;
    private int id;

    //Combat stats
    private boolean combatReady;

    //Endurance stats
    private boolean isAloft;
    private int currentTimeAloft;

    //Movement stats
    private IPlaneMoveModel moveModel;

    //Attribute stats
    private PlaneType planeType;

    public Plane(PlaneType planeType) {
        this.id = planeID++;
        this.isAloft = false;
        this.combatReady = false;

        this.planeType = planeType;
        this.moveModel = new AloftMovement();
    }

    public boolean allowCAP() {
        return planeType.allowCAP();
    }

    public double getCAPContribution() {
        return planeType.getCapContribution();
    }

    public int getID() {
        return this.id;
    }

    public boolean isCombatReady() {
        return combatReady;
    }

    public void setHasMoved() {
        // TODO: 2020-11-14 Implement me
    }
}
