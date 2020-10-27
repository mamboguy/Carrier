package Model.Factories;

import Model.Ships.Ship;

public class JapaneseShipFactory implements IShipFactory {

    private static final JapaneseShipIndex[] CARRIERS = new JapaneseShipIndex[]{
        JapaneseShipIndex.Akagi,
        JapaneseShipIndex.Kaga,
        JapaneseShipIndex.Hiryu,
        JapaneseShipIndex.Shokaku,
        JapaneseShipIndex.Soryu,
        JapaneseShipIndex.Zuikaku
    } ;

    private static final JapaneseShipIndex[] LIGHT_CARRIERS = new JapaneseShipIndex[]{
            JapaneseShipIndex.Hiyo,
            JapaneseShipIndex.Junyo,
            JapaneseShipIndex.Ryujo
    };

    private static final JapaneseShipIndex[] ESCORT_CARRIERS = new JapaneseShipIndex[]{
            JapaneseShipIndex.Shoho,
            JapaneseShipIndex.Taiyo,
            JapaneseShipIndex.Zuiho
    };

    private static final JapaneseShipIndex[] BATTLESHIPS = new JapaneseShipIndex[]{
            JapaneseShipIndex.Haruna,
            JapaneseShipIndex.Hiei,
            JapaneseShipIndex.Kirishima,
            JapaneseShipIndex.Kongo
    };

    private static final JapaneseShipIndex[] CRUISER_CA = new JapaneseShipIndex[]{
            JapaneseShipIndex.Aoba,
            JapaneseShipIndex.Atago,
            JapaneseShipIndex.Chikuma,
            JapaneseShipIndex.Furutaka,
            JapaneseShipIndex.Haguro,
            JapaneseShipIndex.Kako,
            JapaneseShipIndex.Kinugasa,
            JapaneseShipIndex.Kumano,
            JapaneseShipIndex.Maya,
            JapaneseShipIndex.Myoko,
            JapaneseShipIndex.Suzuya,
            JapaneseShipIndex.Takao,
            JapaneseShipIndex.Tone
    };

    private static final JapaneseShipIndex[] CRUISER_CL = new JapaneseShipIndex[]{
            JapaneseShipIndex.Isuzu,
            JapaneseShipIndex.Jintsu,
            JapaneseShipIndex.Nagara,
            JapaneseShipIndex.Tatsuta,
            JapaneseShipIndex.Tenryu,
            JapaneseShipIndex.Yubari,
            JapaneseShipIndex.Yura
    };

    private static final JapaneseShipIndex[] DESTROYER = new JapaneseShipIndex[]{
            JapaneseShipIndex.Akatsuki,
            JapaneseShipIndex.Akebono,
            JapaneseShipIndex.Akigumo,
            JapaneseShipIndex.Akizuki,
            JapaneseShipIndex.Amatsukaze,
            JapaneseShipIndex.Arashi,
            JapaneseShipIndex.Ariake,
            JapaneseShipIndex.Asagumo,
            JapaneseShipIndex.Asanagi,
            JapaneseShipIndex.Harusame,
            JapaneseShipIndex.Hatsukaze,
            JapaneseShipIndex.Hayashio,
            JapaneseShipIndex.Ikazuchi,
            JapaneseShipIndex.Isokaze,
            JapaneseShipIndex.Kagero,
            JapaneseShipIndex.Kazegumo,
            JapaneseShipIndex.Kawakaze,
            JapaneseShipIndex.Kikuzuki,
            JapaneseShipIndex.Kuroshio,
            JapaneseShipIndex.Maikaze,
            JapaneseShipIndex.Makikumo,
            JapaneseShipIndex.Makinami,
            JapaneseShipIndex.Minegumo,
            JapaneseShipIndex.Mochizuki,
            JapaneseShipIndex.Murasame,
            JapaneseShipIndex.Mutsuki,
            JapaneseShipIndex.Naganami,
            JapaneseShipIndex.Natsugumo,
            JapaneseShipIndex.Nowaki,
            JapaneseShipIndex.Oite,
            JapaneseShipIndex.Oyashio,
            JapaneseShipIndex.Samidare,
            JapaneseShipIndex.Sazanami,
            JapaneseShipIndex.Shigure,
            JapaneseShipIndex.Shiratsuyu,
            JapaneseShipIndex.Suzukaze,
            JapaneseShipIndex.Takanami,
            JapaneseShipIndex.Tanikaze,
            JapaneseShipIndex.Teruzuki,
            JapaneseShipIndex.Tokitsukaze,
            JapaneseShipIndex.Urakaze,
            JapaneseShipIndex.Ushio,
            JapaneseShipIndex.Umikaze,
            JapaneseShipIndex.Uzuki,
            JapaneseShipIndex.Yamakaze,
            JapaneseShipIndex.Yoyoi,
            JapaneseShipIndex.Yudachi,
            JapaneseShipIndex.Yugumo,
            JapaneseShipIndex.Yugure,
            JapaneseShipIndex.Yukikaze,
            JapaneseShipIndex.Yuzuki
    };

    @Override
    public Ship giveCarrier() {
        return null;
    }

    @Override
    public Ship giveCarrier_Escort() {
        return null;
    }

    @Override
    public Ship giveCarrier_Light() {
        return null;
    }

    @Override
    public Ship giveBattleship() {
        return null;
    }

    @Override
    public Ship giveCruiser_CA() {
        return null;
    }

    @Override
    public Ship giveCruiser_CL() {
        return null;
    }

    @Override
    public Ship giveDestroyer() {
        return null;
    }

    @Override
    public Ship giveTransport() {
        return null;
    }
}
