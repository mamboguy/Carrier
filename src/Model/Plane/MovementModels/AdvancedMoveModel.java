package Model.Plane.MovementModels;

/**
 Created on 12 Oct 2020

 @Author - Mambo */

public class AdvancedMoveModel implements IPlaneMoveModel{

	@Override
	public int getMoveDistance() {
		// TODO: 2020-10-12 Implement me
		boolean actionPhaseIsEven = false;

		if (actionPhaseIsEven){
			return 2;
		} else {
			return 1;
		}
	}
}
