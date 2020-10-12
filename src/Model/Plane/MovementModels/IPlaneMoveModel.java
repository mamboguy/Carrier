package Model.Plane.MovementModels;

/**
 Created on 12 Oct 2020

 @Author - Mambo */

public interface IPlaneMoveModel {

	int getMoveDistance();

	// TODO: 2020-10-12  Implement models other than those for aloft movement
	//Ex) A plane in hangar can only "move" to the unready flight deck or servicing

}
