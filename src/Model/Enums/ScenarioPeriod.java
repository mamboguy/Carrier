package Model.Enums;

/**
 Enum for all references from the Scenario Time Period Table
 Actual table built in Setup class

 @author Mamboguy */
public enum ScenarioPeriod {

	Jan_July_42(0, "Jan-Jul '42", ScenarioPeriod.EARLY_WAR_AA, "Early War", -1, -1),
	Aug_Sept_42(1, "Aug-Sept '42", ScenarioPeriod.STANDARD_AA, "Standard", 0, 0),
	Oct_Dec_42(2, "Oct-Dec '42", ScenarioPeriod.IMPROVED_AA, "Improved", 1, 1),
	Year_1943(3, "1943", ScenarioPeriod.IMPROVED_AA, "Improved", 1, 1);

	private static final int EARLY_WAR_AA = -1;
	private static final int STANDARD_AA = 0;
	private static final int IMPROVED_AA = 1;

	private final String stringOutput;
	private final int aaModifier;
	private final String aaType;
	private final int repairModifier;
	private final int contactModifier;
	private final int intValue;

	ScenarioPeriod(int intValue, String stringOutput, int aaModifer, String aaType, int repairModifier, int contactModifier) {
		this.intValue = intValue;
		this.stringOutput = stringOutput;
		this.aaModifier = aaModifer;
		this.aaType = aaType;
		this.repairModifier = repairModifier;
		this.contactModifier = contactModifier;
	}

	public int getAAModifier() {
		return aaModifier;
	}

	public String getAAType() {
		return aaType;
	}

	public int getRepairModifier() {
		return repairModifier;
	}

	public int getContactModifier() {
		return contactModifier;
	}

	public ScenarioPeriod getPeriod() {
		return this;
	}

	public String getTimeframe() {
		return stringOutput;
	}

	@Override
	public String toString() {
		return "ScenarioPeriod{" + "stringOutput=" + stringOutput + ", aaModifier=" + aaModifier + ", aaType=" + aaType + ", repairModifier=" + repairModifier + ", contactModifier=" + contactModifier + ", intValue=" + intValue + '}';
	}

	public int getIntValue() {
		return intValue;
	}
}
