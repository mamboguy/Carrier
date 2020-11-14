package Model.Plane.MovementModels;

/**
 Created on 14 Nov 2020

 @Author - Mambo */

public class GroundedMoveModel implements IPlaneMoveModel{

	@Override
	public int getMoveDistance() {
		return 1;
	}
}
