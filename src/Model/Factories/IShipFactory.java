package Model.Factories;

import Model.Ships.Ship;

public interface IShipFactory {

    Ship giveCarrier();
    Ship giveCarrier_Escort();
    Ship giveCarrier_Light();
    Ship giveBattleship();
    Ship giveCruiser_CA();
    Ship giveCruiser_CL();
    Ship giveDestroyer();
    Ship giveTransport();
}
