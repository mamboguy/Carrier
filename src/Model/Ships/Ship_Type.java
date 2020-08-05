package Model.Ships;

/**
 Created on 02 Aug 2020

 @version 1.0
 <p>
 Replacement for multiple sub-classes of ship.  Instead, ships will have various types assigned to them to make code
 base for ships easier to maintain and change as well as usages by other classes
 @Author - Mambo */

public enum Ship_Type {

	//Ship type (Purchase cost (pg 52), Heavy Damage Points, Sunk Damage Points)
	Battleship(8, 2, 4, "Battleship", "BB"), Cruiser_CA(2, 1, 1, "Cruiser", "CA"), Cruiser_CL(2, 0, 1, "Cruiser",
																							  "CL"), Cruiser_CLAA(3, 1,
																												  2,
																												  "Cruiser",
																												  "CLAA"), Destroyer(
			1, 0, 1, "Destroyer", "DD"), Transport(0, 0, 1, "Transport", "??"), Carrier(0, 0, 0, "Carrier", "UNK");

	private final int purchaseCost;
	private final int heavyDmgPts;
	private final int sunkDmgPoints;
	private final String name;
	private final String shortName;

	Ship_Type(int purchaseCost, int heavyDmgPts, int sunkDmgPoints, String name, String shortName) {
		this.purchaseCost = purchaseCost;
		this.heavyDmgPts = heavyDmgPts;
		this.sunkDmgPoints = sunkDmgPoints;
		this.name = name;
		this.shortName = shortName;
	}

	public int getPurchaseCost() {
		return purchaseCost;
	}

	public int getHeavyDmgPts() {
		return heavyDmgPts;
	}

	public int getSunkDmgPoints() {
		return sunkDmgPoints;
	}

	public String getName() {
		return name;
	}

	public String getShortName() {
		return shortName;
	}
}
