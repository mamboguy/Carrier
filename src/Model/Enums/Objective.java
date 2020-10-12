package Model.Enums;

/**
 Created on 12 Oct 2020

 @Author - Mambo */

public enum Objective {

	Moresby("Port Moresby", 2549, 0),
	Guadalcanal("Guadalcanal", 2626, 2527),
	Hebrides("North Hebrides", 3712, 0),
	Georgia("New Georgia", 2232, 0),
	Bougainville("Bougainville", 1935, 0);

	private String name;
	private int primaryObjectiveHexID;
	private int secondaryObjectiveHexID;

	Objective(String name, int primaryObjectiveHexID, int secondaryObjectiveHexID) {
		this.name = name;
		this.primaryObjectiveHexID = primaryObjectiveHexID;
		this.secondaryObjectiveHexID = secondaryObjectiveHexID;
	}

	public String getName() {
		return name;
	}

	public int getPrimaryObjectiveHexID() {
		return primaryObjectiveHexID;
	}

	public int getSecondaryObjectiveHexID() {
		return secondaryObjectiveHexID;
	}
}
