package Model.Forces;

public interface IStrikeForce {

    boolean hasTBDs();

    boolean hasEscorts();

    int getEscortSize();

    int getAttackForceSize();

	int getAttackForceAttackValue();

	boolean isCoordinated();

	boolean isUnloadingTransport();
}
