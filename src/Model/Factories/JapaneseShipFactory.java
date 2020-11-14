package Model.Factories;

import Controller.Die;
import Model.Enums.ScenarioPeriod;
import Model.Ships.Ship;
import Model.Ships.Ship_Type;

import java.util.ArrayList;
import java.util.List;

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

    private Die die;

    private List<JapaneseShipIndex> carriersAvailable = new ArrayList<JapaneseShipIndex>();
    private List<JapaneseShipIndex> carrierEscortsAvailable = new ArrayList<JapaneseShipIndex>();
    private List<JapaneseShipIndex> carrierLightsAvailable = new ArrayList<JapaneseShipIndex>();
    private List<JapaneseShipIndex> battleshipsAvailable = new ArrayList<JapaneseShipIndex>();
    private List<JapaneseShipIndex> cruiserCAAvailable = new ArrayList<JapaneseShipIndex>();
    private List<JapaneseShipIndex> cruiserCLAvailable = new ArrayList<JapaneseShipIndex>();
    private List<JapaneseShipIndex> destroyersAvailable = new ArrayList<JapaneseShipIndex>();

    private List<JapaneseShipIndex> carriersUsed = new ArrayList<JapaneseShipIndex>();
    private List<JapaneseShipIndex> carrierEscortsUsed = new ArrayList<JapaneseShipIndex>();
    private List<JapaneseShipIndex> carrierLightsUsed = new ArrayList<JapaneseShipIndex>();
    private List<JapaneseShipIndex> battleshipsUsed = new ArrayList<JapaneseShipIndex>();
    private List<JapaneseShipIndex> cruiserCAUsed = new ArrayList<JapaneseShipIndex>();
    private List<JapaneseShipIndex> cruiserCLUsed = new ArrayList<JapaneseShipIndex>();
    private List<JapaneseShipIndex> destroyersUsed = new ArrayList<JapaneseShipIndex>();

    public JapaneseShipFactory(ScenarioPeriod period){

        //TODO 10/28/2020 - Add in option to only get available ships

        generateList(carriersAvailable, CARRIERS, period);
        generateList(carrierEscortsAvailable, ESCORT_CARRIERS, period);
        generateList(carrierLightsAvailable, LIGHT_CARRIERS, period);
        generateList(battleshipsAvailable, BATTLESHIPS, period);
        generateList(cruiserCAAvailable, CRUISER_CA, period);
        generateList(cruiserCLAvailable, CRUISER_CL, period);
        generateList(destroyersAvailable, DESTROYER, period);

        //printSettings();
    }

    @Override
    public ArrayList<Ship> giveCarrier(int count) {
        return getShipFromArray(Ship_Type.Carrier_CV, carriersAvailable, carriersUsed, count);
    }

    @Override
    public ArrayList<Ship> giveCarrier_Escort(int count) {
        return getShipFromArray(Ship_Type.Carrier_Escort, carrierEscortsAvailable, carrierEscortsUsed, count);
    }

    @Override
    public ArrayList<Ship> giveCarrier_Light(int count) {
        return getShipFromArray(Ship_Type.Carrier_Light, carrierLightsAvailable, carrierLightsUsed, count);
    }

    @Override
    public ArrayList<Ship> giveBattleship(int count) {
        return getShipFromArray(Ship_Type.Battleship, battleshipsAvailable, battleshipsUsed, count);
    }

    @Override
    public ArrayList<Ship> giveCruiser_CA(int count) {
        return getShipFromArray(Ship_Type.Cruiser_CA, cruiserCAAvailable, cruiserCAUsed, count);
    }

    @Override
    public ArrayList<Ship> giveCruiser_CL(int count) {
        return getShipFromArray(Ship_Type.Cruiser_CL, cruiserCLAvailable, cruiserCLUsed, count);
    }

    @Override
    public ArrayList<Ship> giveCruiser_CLAA(int count) {
        //Japanese do not AA type cruisers
        return null;
    }

    @Override
    public ArrayList<Ship> giveDestroyer(int count) {
        return getShipFromArray(Ship_Type.Destroyer, destroyersAvailable, destroyersUsed, count);
    }

    @Override
    public ArrayList<Ship> giveTransport(int count) {
        JapaneseShipIndex transport = JapaneseShipIndex.Maru;

        ArrayList<Ship> temp = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            temp.add(new Ship(Ship_Type.Transport, transport.getAaValue(), transport.getMaxHP(), transport.getBombardmentValue(), transport.getName()));
        }

        return temp;
    }

    private void printSettings() {
        System.out.println();
        System.out.println("Carriers available: " + carriersAvailable.size());
        System.out.println("Light Carriers available: " + carrierLightsAvailable.size());
        System.out.println("Escort Carriers available: " + carrierEscortsAvailable.size());
        System.out.println("Battleships available: " + battleshipsAvailable.size());
        System.out.println("Cruisers CA available: " + cruiserCAAvailable.size());
        System.out.println("Cruisers CL available: " + cruiserCLAvailable.size());
        System.out.println("Destroyers available: " + destroyersAvailable.size());
    }

    private void generateList(List<JapaneseShipIndex> available, JapaneseShipIndex[] pool, ScenarioPeriod period) {
        JapaneseShipIndex temp;

        for (int i = 0; i < pool.length; i++) {
            if (pool[i].isAvailableForPeriod(period)){
                available.add(pool[i]);
            }
        }
    }

    private void resideDie(int length) {
        die = new Die(length);
    }

    /**
     * Get a ship from the available array, move it to the used array and return the ship
     * @param shipsAvailable - list of available ships
     * @param shipsUsed - list of used ships
     * @return - the ship that was moved from the available to used list
     */
    private ArrayList<Ship> getShipFromArray(Ship_Type type, List<JapaneseShipIndex> shipsAvailable, List<JapaneseShipIndex> shipsUsed, int count) {

        //list to return
        ArrayList<Ship> list = new ArrayList<>();
        JapaneseShipIndex chosenShip;

        for (int i = 0; i < count; i++) {

            if (shipsAvailable.size() != 1){

                //Reside the die so that it only chooses from the available pool
                resideDie(shipsAvailable.size());

                //Roll the die and lookup the result in the array
                die.rollDie();

                //Get the ship that was rolled and have it move from the available to used lists
                chosenShip = shipsAvailable.get(die.getLastRoll() - 1);

            } else {

                chosenShip = shipsAvailable.get(0);

            }

            //Move ship to used
            shipsUsed.add(chosenShip);
            shipsAvailable.remove(chosenShip);

            //Add to list of ships after creation
            list.add(ShipObjectFactory.createJapaneseShip(type, chosenShip));
        }

        return list;
    }

    /**
     Determines if the factory has enough of the ships available based off requirements produced by the Level 3 to
     Level 4 upgrade
     @param cvCount - Num of CVs needed
     @param cveCount - Num of CVEs needed
     @param cvlCount - Num of CVLs needed
     @param bbCount - Num of BBs needed
     @param caCount - Num of CAs needed
     @param clCount - Num of CLs needed
     @param ddCount - Num of DDs needed
     @return
     */
    public boolean hasEnoughShips(int cvCount, int cveCount, int cvlCount, int bbCount, int caCount, int clCount, int ddCount) {
        return checkSize(carriersAvailable, cvCount) && checkSize(carrierEscortsAvailable, cveCount) &&
                checkSize(carrierLightsAvailable, cvlCount) && checkSize(battleshipsAvailable, bbCount) &&
                checkSize(cruiserCAAvailable, caCount) && checkSize(cruiserCLAvailable, clCount) &&
                checkSize(destroyersAvailable, ddCount);
    }

    /**
     Checks a list of available ships and the number needed and determines if enough are available
     @param shipList - The list of ships that are available
     @param shipsNeeded - The number of ships needed
     @return - True if there are enough ships available to meet quota
     */
    private boolean checkSize(List<JapaneseShipIndex> shipList, int shipsNeeded) {
        return (shipList.size() >= shipsNeeded);
    }
}
