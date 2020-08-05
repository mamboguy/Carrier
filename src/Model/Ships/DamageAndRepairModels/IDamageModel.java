package Model.Ships.DamageAndRepairModels;

/**
 Created on 02 Aug 2020

 @Author - Mambo */

public interface IDamageModel {

	boolean isHeavilyDamaged();

	boolean isLightlyDamaged();

	boolean isMediumDamaged();

	boolean isDeadInWater();

	boolean canLaunchPlanes();
}
