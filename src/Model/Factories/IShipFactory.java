package Model.Factories;

import Model.Ships.Ship;

import java.util.ArrayList;

public interface IShipFactory {

    ArrayList<Ship> giveCarrier(int count);
    ArrayList<Ship> giveCarrier_Escort(int count);
    ArrayList<Ship> giveCarrier_Light(int count);
    ArrayList<Ship> giveBattleship(int count);
    ArrayList<Ship> giveCruiser_CA(int count);
    ArrayList<Ship> giveCruiser_CL(int count);
    ArrayList<Ship> giveCruiser_CLAA(int count);
    ArrayList<Ship> giveDestroyer(int count);
    ArrayList<Ship> giveTransport(int count);
}
