package Model.Factories;

import Model.Enums.ScenarioPeriod;

/**
 A list of all the Japanese ships available to the factories for handing out
 */
public enum JapaneseShipIndex {

    //Type, Name, Air Value, AA Value, HP, Bombardment, Avail Jan-Jul42, Avail Aug-Sept42, Avail Oct-Dec42, Avail 43

    //CVs
    Akagi("Akagi", 11, 4, 8, 0, true, false, false, false),
    Kaga ("Kaga", 11, 5, 8, 0, true, false, false, false),
    Soryu ("Soryu", 9, 6, 7, 0, true, false, false, false),
    Hiryu ("Hiryu", 9, 6, 7, 0, true, false, false, false),
    Shokaku ("Shokaku", 10, 8, 8, 0, true, true, true, true),
    Zuikaku ("Zuikaku", 10, 8, 8, 0, true, true, true, true),

    //CVL
    Hiyo ("Hiyo", 6, 5, 6, 0, false, true, true, true),
    Junyo ("Junyo", 6, 5, 6, 0, false, true, true, true),
    Ryujo ("Ryujo", 6, 2, 5, 0, true, true, false, false),

    //CVE
    Shoho ("Shoho", 4, 2, 5, 0, true, false, false, false),
    Taiyo ("Taiyo", 3, 2, 5, 0, true, true, true, true),
    Zuiho ("Zuiho", 4, 2, 5, 0, true, true, true, true),

    //BB
    Haruna ("Haruna", 0, 4, 15, 10, true, true, true, true),
    Hiei ("Hiei", 0,4, 15, 10, true, true, true, false),
    Kirishima ("Kirishima", 0, 4, 15, 10, true, true, true, false),
    Kongo ("Kongo", 0, 4, 15, 10, true, true, true, true),

    //CA
    Aoba ("Aoba", 0, 2, 7, 3, true, true, false, true),
    Atago ("Atago", 0, 2, 9, 4, true, true, true, true),
    Chikuma ("Chikuma", 0, 2, 7, 3, true, true, true, true),
    Furutaka ("Furutaka", 0, 2, 7, 3, true, true, false, false),
    Haguro ("Haguro", 0, 2, 9, 4, true, true, true, true),
    Kako ("Kako", 0, 2, 7, 3, true, true, false,false),
    Kinugasa ("Kinugasa", 0, 2, 7, 4, true, true, true, false), //Not in rules, sunk in Dec 1942
    Kumano ("Kumano", 0, 2, 9, 4, true, true, true, true),
    Maya ("Maya", 0, 2, 9, 4,  true, true, true, true),
    Myoko ("Myoko", 0, 2, 9, 4,  true, true, true, true),
    Suzuya ("Suzuya", 0, 2, 9, 4,  true, true, true, true),
    Takao ("Takao", 0, 2, 9, 4,  true, true, true, true),
    Tone ("Tone", 0, 3, 9, 4,  true, true, true, true),

    //CL
    Isuzu ("Isuzu", 0, 1, 4, 2, true, true, true, true),
    Jintsu ("Jintsu", 0, 1, 4, 2, true, true, true, true),
    Nagara ("Nagara", 0, 1, 4, 2, true, true, true, true),
    Tatsuta ("Tatsuta", 0, 0, 3, 2, true, true, true, true),
    Tenryu ("Tenryu", 0, 1, 3, 2, true, true, true, false),
    Yubari ("Yubari", 0, 1, 3, 2, true, true, true, true),
    Yura ("Isuzu", 0, 1, 4, 2, true, true, true, false),

    //DD
    Akatsuki ("Akatsuki", 0, 2, 3, 1, true, true, true, false),
    Akebono ("Akebono", 0, 1, 3, 1, true, true, true, true),
    Akigumo ("Akigumo", 0, 1, 3, 1, true, true, true, true),
    Akizuki ("Akizuki", 0, 1, 3, 1, false, true, true, true),
    Amatsukaze ("Amatsukaze", 0, 1, 3, 1, true, true, true, true),
    Arashi ("Arashi", 0, 1, 3, 1, true, true, true, true),
    Ariake ("Akiake", 0, 1, 3, 1, true, true, true, true),
    Asagumo ("Asagumo", 0, 1, 3, 1, true, true, true, true),
    Asanagi ("Asanagi", 0, 1, 3, 1, true, true, true, true),
    Harusame ("Harusame", 0, 1, 3, 1, true, true, true, true),
    Hatsukaze ("Hatsukaze", 0, 1, 3, 1, true, true, true, true),
    Hayashio ("Hayashio", 0, 1, 3, 1, true, true, true, false),
    Ikazuchi ("Ikazuchi", 0, 2, 3, 1, true, true, true, true),
    Isokaze ("Isokaze", 0, 1, 3, 1, true, true, true, true),
    Kagero ("Kagero", 0, 1, 3, 1, true, true, true, true),
    Kazegumo ("Kazegumo", 0, 1, 3, 1, true, true, true, true),
    Kawakaze ("Kawakaze", 0, 1, 3, 1, true, true, true, true),
    Kikuzuki ("Kikuzuki", 0, 2, 3, 1, true, false, false, false),
    Kuroshio ("Kuroshio", 0, 1, 3, 1, true, true, true, true),
    Maikaze ("Maikaze", 0, 1, 3, 1, true, true, true, true),
    Makikumo ("Makikumo", 0, 1, 3, 1, false, true, true, true),
    Makinami ("Makinami", 0, 1, 3, 1, true, true, true, true),
    Minegumo ("Minogumo", 0, 1, 3, 1, true, true, true, true),
    Mochizuki ("Mochizuki", 0, 2, 3, 1, true, true, true, true),
    Murasame ("Murasame", 0, 1, 3, 1, true, true, true, true),
    Mutsuki ("Mutsuki", 0, 2, 3, 1, true, false, false, false),
    Naganami ("Naganami", 0, 1, 3, 1, true, true, true, true),
    Natsugumo ("Natsugumo", 0, 1, 3, 1, true, true, false, false),
    Nowaki ("Nowaki", 0, 1, 3, 1, true, true, true, true),
    Oite ("Oite", 0, 1, 3, 1, true, true, true, true),
    Oyashio ("Oyashio", 0, 1, 3, 1, true, true, true, true),
    Samidare ("Samidare", 0, 1, 3, 1, true, true, true, true),
    Sazanami ("Sazanami", 0, 1, 3, 1, true, true, true, true),
    Shigure ("Shigure", 0, 1, 3, 1, true, true, true, true),
    Shiratsuyu ("Shiratsuyu", 0, 1, 3, 1, true, true, true, true),
    Suzukaze ("Suzukaze", 0, 1, 3, 1, true, true, true, true),
    Takanami ("Takanami", 0, 1, 3, 1, false, false, true, false),
    Tanikaze ("Tanikaze", 0, 1, 3, 1, true, true, true, true),
    Teruzuki ("Teruzuki", 0, 1, 3, 1, true, true, true, false),
    Tokitsukaze ("Tokitsukaze", 0, 1, 3, 1, true, true, true, true),
    Urakaze ("Urakaze", 0, 1, 3, 1, true, true, true, true),
    Ushio ("Ushio", 0, 1, 3, 1, true, true, true, true),
    Umikaze ("Umikaze", 0, 1, 3, 1, true, true, true, true),
    Uzuki ("Uzuki", 0, 2, 3, 1, true, true, true, true),
    Yamakaze ("Yamakaze", 0, 1, 3, 1, true, false, false, false),
    Yoyoi ("Tanikaze", 0, 2, 3, 1, true, true, false, false),
    Yudachi ("Yudachi", 0, 1, 3, 1, true, true, true, false),
    Yugumo ("Yugumo", 0, 1, 3, 1, true, true, true, true),
    Yugure ("Yugure", 0, 1, 3, 1, true, true, true, true),
    Yukikaze ("Yukikaze", 0, 1, 3, 1, true, true, true, true),
    Yuzuki ("Yuzuki", 0, 2, 3, 1, true, true, true, true),

    //Transports
    Maru ("Maru", 0, 1, 2, 0, true, true, true, true);


    private String name;
    private int airValue;
    private int aaValue;
    private int hpValue;
    private int bombardmentValue;
    private boolean availableJanJul42;
    private boolean availableAugSept42;
    private boolean availableOctDec42;
    private boolean available1943;

    JapaneseShipIndex(String name, int airValue, int aaValue, int hpValue, int bombardmentValue, boolean availableJanJul42, boolean availableAugSept42, boolean availableOctDec42, boolean available1943) {
        this.name = name;
        this.airValue = airValue;
        this.aaValue = aaValue;
        this.hpValue = hpValue;
        this.bombardmentValue = bombardmentValue;
        this.availableJanJul42 = availableJanJul42;
        this.availableAugSept42 = availableAugSept42;
        this.availableOctDec42 = availableOctDec42;
        this.available1943 = available1943;
    }

    public String getName() {
        return name;
    }

    public int getAirValue() {
        return airValue;
    }

    public int getAaValue() {
        return aaValue;
    }

    public int getMaxHP() {
        return hpValue;
    }

    public int getBombardmentValue() {
        return bombardmentValue;
    }

    public boolean isAvailableForPeriod(ScenarioPeriod period){
        int index = period.getIntValue() + 5;

        switch (index){
            case 5:
                return availableJanJul42;
            case 6:
                return availableAugSept42;
            case 7:
                return availableOctDec42;
            case 8:
                return available1943;
            default:
                return false;
        }
    }
}
