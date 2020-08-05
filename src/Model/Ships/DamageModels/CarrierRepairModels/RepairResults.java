package Model.Ships.DamageModels.CarrierRepairModels;

/**
 Created on 03 Aug 2020

 @Author - Mambo */

public class RepairResults {

	private int repairResult;
	private boolean causedIrreparableHullDamage;
	private boolean criticalFailure;
	private boolean allowRaisingAndLowering;

	public RepairResults(int repairResult, boolean causedIrreparableHullDamage, boolean criticalFailure, boolean allowRaisingAndLowering) {
		this.repairResult = repairResult;
		this.causedIrreparableHullDamage = causedIrreparableHullDamage;
		this.criticalFailure = criticalFailure;
		this.allowRaisingAndLowering = allowRaisingAndLowering;
	}

	public int getRepairResult() {
		return repairResult;
	}

	public boolean isCausedIrreparableHullDamage() {
		return causedIrreparableHullDamage;
	}

	public boolean isCriticalFailure() {
		return criticalFailure;
	}

	public boolean isAllowRaisingAndLowering() {
		return allowRaisingAndLowering;
	}
}
