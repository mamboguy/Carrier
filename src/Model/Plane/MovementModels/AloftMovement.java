package Model.Plane.MovementModels;

/**
 Created on 12 Oct 2020

 @Author - Mambo */

public class AloftMovement
		implements IPlaneMoveModel{

	@Override
	public int getMoveDistance() {
		return 1;
	}
}
