package Model.Factories;

import Controller.Die;
import Model.Ships.Ship;

import java.util.ArrayList;
import java.util.List;

public class USShipFactory implements IShipFactory{

    private static final USShipIndex[] CARRIERS = new USShipIndex[]{
        USShipIndex.Enterprise,
        USShipIndex.Hornet,
        USShipIndex.Lexington,
        USShipIndex.Saratoga,
        USShipIndex.Victorious,
        USShipIndex.Wasp,
        USShipIndex.Yorktown
    } ;

    private static final USShipIndex[] BATTLESHIPS = new USShipIndex[]{
        USShipIndex.Indiana,
        USShipIndex.Massachusetts,
        USShipIndex.NorthCarolina,
        USShipIndex.SouthDakota,
        USShipIndex.Washington
    };

    private static final USShipIndex[] CRUISER_CA = new USShipIndex[]{
        USShipIndex.Astoria,
        USShipIndex.Australia,
        USShipIndex.Canberra,
        USShipIndex.Chester,
        USShipIndex.Chicago,
        USShipIndex.Minneapolis,
        USShipIndex.NewOrleans,
        USShipIndex.Northampton,
        USShipIndex.Pensacola,
        USShipIndex.Portland,
        USShipIndex.SaltLakeCity,
        USShipIndex.SanFrancisco,
        USShipIndex.Vincennes
    };

    private static final USShipIndex[] CRUISER_CL = new USShipIndex[]{
        USShipIndex.Boise,
        USShipIndex.Cleveland,
        USShipIndex.Columbia,
        USShipIndex.Denver,
        USShipIndex.Hobart,
        USShipIndex.Helena,
        USShipIndex.Honolulu,
        USShipIndex.StLouis
    };

    private static final USShipIndex[] CRUISER_CLAA = new USShipIndex[]{
        USShipIndex.Atlanta,
        USShipIndex.Juneau,
        USShipIndex.SanDiego,
        USShipIndex.SanJuan
    };

    private static final USShipIndex[] DESTROYER = new USShipIndex[]{
        USShipIndex.AaronWard,
            USShipIndex.Anderson,
            USShipIndex.Aylwin,
            USShipIndex.Balch,
            USShipIndex.Barton,
            USShipIndex.Benham,
            USShipIndex.Buchanan,
            USShipIndex.Conyngham,
            USShipIndex.Cushing,
            USShipIndex.Dale,
            USShipIndex.Dewey,
            USShipIndex.Ellett,
            USShipIndex.Farenholt,
            USShipIndex.Farragut,
            USShipIndex.Grayson,
            USShipIndex.Hammann,
            USShipIndex.Lang,
            USShipIndex.Mahan,
            USShipIndex.Maury,
            USShipIndex.MacDonough,
            USShipIndex.Monaghan,
            USShipIndex.Monssen,
            USShipIndex.Morris,
            USShipIndex.Mustin,
            USShipIndex.Phelps,
            USShipIndex.Porter,
            USShipIndex.Preston,
            USShipIndex.Russell,
            USShipIndex.Selfridge,
            USShipIndex.Shaw,
            USShipIndex.Sims,
            USShipIndex.Smith,
            USShipIndex.Stack,
            USShipIndex.Sterett,
            USShipIndex.Walke,
            USShipIndex.Worden
    };

    private static final USShipIndex[] TRANSPORT = new USShipIndex[]{
        USShipIndex.CrescentCity,
        USShipIndex.McCawley,
        USShipIndex.PresAdams,
        USShipIndex.PresJack
    };

    private Die die;

    private List<USShipIndex> carriersAvailable = new ArrayList<USShipIndex>();
    private List<USShipIndex> battleshipsAvailable = new ArrayList<USShipIndex>();
    private List<USShipIndex> cruiserCAAvailable = new ArrayList<USShipIndex>();
    private List<USShipIndex> cruiserCLAvailable = new ArrayList<USShipIndex>();
    private List<USShipIndex> cruiserCLAAAvailable = new ArrayList<USShipIndex>();
    private List<USShipIndex> destroyersAvailable = new ArrayList<USShipIndex>();

    private List<USShipIndex> carriersUsed = new ArrayList<USShipIndex>();
    private List<USShipIndex> battleshipsUsed = new ArrayList<USShipIndex>();
    private List<USShipIndex> cruiserCAUsed = new ArrayList<USShipIndex>();
    private List<USShipIndex> cruiserCLUsed = new ArrayList<USShipIndex>();
    private List<USShipIndex> cruiserCLAAUsed = new ArrayList<USShipIndex>();
    private List<USShipIndex> destroyersUsed = new ArrayList<USShipIndex>();

    @Override
    public ArrayList<Ship> giveCarrier(int count) {
        return null;
    }

    @Override
    public ArrayList<Ship> giveCarrier_Escort(int count) {
        return null;
    }

    @Override
    public ArrayList<Ship> giveCarrier_Light(int count) {
        return null;
    }

    @Override
    public ArrayList<Ship> giveBattleship(int count) {
        return null;
    }

    @Override
    public ArrayList<Ship> giveCruiser_CA(int count) {
        return null;
    }

    @Override
    public ArrayList<Ship> giveCruiser_CL(int count) {
        return null;
    }

    @Override
    public ArrayList<Ship> giveCruiser_CLAA(int count) {
        return null;
    }

    @Override
    public ArrayList<Ship> giveDestroyer(int count) {
        return null;
    }

    @Override
    public ArrayList<Ship> giveTransport(int count) {
        return null;
    }
}
