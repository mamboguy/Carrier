package Model.Factories;

import Model.Enums.ScenarioPeriod;

public enum USShipIndex {

    //CV
    Lexington ("Lexington", 22, 12, 9, 0, true, true, true, true),
    Saratoga ("Saratoga", 22, 12, 9, 0, true, true, false, true),
    Yorktown ("Yorktown", 24, 10, 8, 0, true, false, false, false),
    Enterprise ("Enterprise", 24, 10, 8, 0, true, true, true, true),
    Hornet ("Hornet", 24, 10, 8, 0, true, true, true, false),
    Wasp ("Wasp", 20, 10, 7, 0, true, true, false, false),
    Victorious ("Victorious", 11, 8, 9, 0, false, false, false, true),

    //BB
    Indiana("Indiana", 0, 20, 20, 12, false, false, false, true),
    Massachusetts("Massachusetts", 0, 20, 20, 12, false, false, false, true),
    NorthCarolina ("North Carolina", 0, 18, 18, 12, true, true, false, true),
    SouthDakota("South Dakota", 0, 20, 20, 12, true, true, true, true),
    Washington ("Washington", 0, 18, 18, 12, false, false, true, true),

    //CA
    Astoria ("Astoria", 0, 4, 8, 3, true, true, false, false),
    Australia ("Australia", 0, 3, 7, 3, true, true, false, false),
    Canberra ("Canberra", 0, 3, 3, 7, false, true, false, false),
    Chester ("Chester", 0, 4, 6, 3, true, true, true, true),
    Chicago ("Chicago", 0, 4, 6, 3, true, true, true, false),
    Minneapolis ("Minneapolis", 0, 4, 8, 3, true, true, true, false),
    NewOrleans ("New Orleans", 0, 4, 8, 3, true, true, true, false),
    Northampton ("Northampton", 0, 4, 6, 3, true, true, true, false),
    Pensacola ("Pensacola", 0, 4, 6, 3, true, true, true, false),
    Portland ("Portland", 0, 4, 7, 3, true, true, true, true),
    SaltLakeCity ("Salt Lake City", 0, 4, 6, 3, true, true, true, true),
    SanFrancisco ("San Francisco", 0, 4, 8, 3, true, true, true, false),
    Vincennes ("Vincennes", 0, 4, 8, 3, true, true, false, false),

    //CL
    Boise ("Boise", 0, 4, 5, 3, false, false, true, true),
    Cleveland ("Cleveland", 0, 4, 5, 3, false, false, false, true),
    Columbia ("Columbia", 0, 4, 5, 3, false, false, false, true),
    Denver ("Denver", 0, 4, 5, 3, false, false, false, true),
    Hobart ("Hobart", 0, 3, 4, 2, true, false, false, false),
    Helena ("Helena", 0, 4, 5, 3, false, false, true, true),
    Honolulu ("Honolulu", 0, 4, 5, 3, false, false, true, true),
    StLouis ("St Louis", 0, 4, 5, 3, false, false, false, true),

    //CLAA
    Atlanta ("Atlanta", 0, 9, 4, 2, false, true, true, false),
    Juneau ("Juneau", 0, 9, 4, 2, false, true, true, false),
    SanDiego ("San Diego", 0, 9, 4, 2, false, true, true, true),
    SanJuan ("San Juan", 0, 9, 4, 2, false, true, true, true),

    //DD
    AaronWard ("Aaron Ward", 0, 3, 2, 1, true, true, true, true),
    Anderson ("Anderson", 0, 3, 2, 1, true, true, true, true),
    Aylwin ("Aylwin", 0, 3, 2, 1, true, true, true, true),
    Balch ("Balch", 0, 4, 2, 1, true, true, true , true),
    Benham ("Benham", 0, 2, 2, 1, true, true, true, false),
    Barton ("Barton", 0, 3, 2, 1, false, false, true, false),
    Buchanan ("Buchanan", 0, 3, 2, 1, true, true, true, true),
    Conyngham ("Conyngham", 0, 3, 2, 1, true, true, true, true),
    Cushing ("Cushing", 0, 3, 2, 1, false, false, true, false),
    Dale ("Dale", 0, 3, 2, 1, true, true, true, true),
    Dewey ("Dewey", 0, 3, 2, 1, true, true, true, true),
    Ellett ("Ellett", 0, 2, 2, 1, true, true, true, true),
    Farenholt ("Farenholt", 0, 3, 2, 1, true, true, true, true),
    Farragut ("Farragut", 0, 3, 2, 1, true, true, true, true),
    Grayson ("Grayson", 0, 3, 2, 1, true, true, true, true),
    Hammann ("Hammann", 0, 3, 2, 1, true, false, false, false),
    Hughes ("Hughes", 0, 3, 2, 1, true, true, true, true),
    Lang ("Lang", 0, 2, 2, 1, true, true, true, true),
    Mahan ("Mahan", 0, 3, 2, 1, true, true, true, true),
    Maury ("Maury", 0, 2, 2, 1, true, true, true, true),
    MacDonough ("MacDonough", 0, 3, 2, 1, true, true, true, true),
    Monaghan ("Monoghan", 0, 3, 2, 1, true, true, true, true),
    Monssen ("Monssen", 0, 3, 2, 1, true, true, true, false),
    Morris ("Morris", 0, 3, 2, 1, true, true, true, true),
    Mustin ("Mustin", 0, 3, 2, 1, true, true, true, true),
    Phelps ("Phelps", 0, 4, 2, 1, true, true, true, true),
    Perkins ("Perkins", 0, 3, 2, 1, true, true, true, true),
    Porter ("Porter", 0, 4, 2, 1, true, true, true, false),
    Preston ("Preston", 0, 3, 2, 1, true, true, true, false),
    Russell ("Russell", 0, 3, 2, 1, true, true, true, true),
    Selfridge ("Selfridge", 0, 4, 2, 1, true, true, true, true),
    Shaw ("Shaw", 0, 3, 2, 1, true, true, true, true),
    Sims ("Sims", 0, 3, 2, 1, true, false, false, false),
    Smith ("Smith", 0, 3, 2, 1, true, true, true, true),
    Stack ("Stack", 0, 2, 2, 1, true, true, true, true),
    Sterett ("Sterett", 0, 2, 2, 1, true, true, true, true),
    Walke ("Walke", 0, 3, 2, 1, true, true, true, false),
    Worden ("Worden", 0, 3, 2, 1, true, true, true, false),

    //Transport
    CrescentCity ("Crescent City", 0, 1, 2, 0, true, true, true, true),
    McCawley ("McCawley", 0, 1, 2, 0, true, true, true, true),
    PresAdams ("President Adams", 0, 1, 2, 0, true, true, true, true),
    PresJack ("President Jackson", 0, 1, 2, 0, true, true, true, true),

    //Special
    Nimitz ("Nimitz", 16, 15, 20, 0, true, true, true, true);

    private String name;
    private int maxHangar;
    private int aaValue;
    private int maxHP;
    private int bombardment;
    private boolean availJanJul42;
    private boolean availAugSet42;
    private boolean availOctDec42;
    private boolean avail1943;

    USShipIndex(String name, int maxHangar, int aaValue, int maxHP, int bombardment, boolean availJanJul42, boolean availAugSet42, boolean availOctDec42, boolean avail1943) {
        this.name = name;
        this.maxHangar = maxHangar;
        this.aaValue = aaValue;
        this.maxHP = maxHP;
        this.bombardment = bombardment;
        this.availJanJul42 = availJanJul42;
        this.availAugSet42 = availAugSet42;
        this.availOctDec42 = availOctDec42;
        this.avail1943 = avail1943;
    }

    public String getName() {
        return name;
    }

    public int getMaxHangar() {
        return maxHangar;
    }

    public int getAaValue() {
        return aaValue;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getBombardment() {
        return bombardment;
    }

    public boolean isAvailableForPeriod(ScenarioPeriod period){
        int index = period.getIntValue() + 5;

        switch (index){
            case 5:
                return availJanJul42;
            case 6:
                return availAugSet42;
            case 7:
                return availOctDec42;
            case 8:
                return avail1943;
            default:
                return false;
        }
    }
}
