package Model.Plane;

public enum PlaneType {
    SBD(14, "Dauntless", 3, 0, false), TBF(14, "Avenger", 2, 0, false), TBD(8, "Devastator", 1, 0, false), P38(18,
                                                                                                               "Lightning",
                                                                                                               0, 1.0,
                                                                                                               true), P39(
            7, "Airacobra", 0, 0.5, true), F4F(12, "Wildcat", 0, 1.0, true), MedBomber(11, "Medium Bomber", 1, 0,
                                                                                       false);

    private int range;
    private int attackStrength;
    private String nickname;
    private double capContribution;
    private boolean allowCAP;

    PlaneType(int range, String nickname, int attackStrength, double capContribution, boolean allowCAP) {
        this.range = range;
        this.attackStrength = attackStrength;
        this.nickname = nickname;
        this.capContribution = capContribution;
        this.allowCAP = allowCAP;
    }

    public boolean allowCAP() {
        return allowCAP;
    }

    public int getRange() {
        return range;
    }

    public String getNickname() {
        return nickname;
    }

    public double getCapContribution() {
        return capContribution;
    }

    public int getAttackStrength() {
        return attackStrength;

    }
}
