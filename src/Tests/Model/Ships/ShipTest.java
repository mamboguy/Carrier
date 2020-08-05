package Tests.Model.Ships;

import Model.Ships.Ship;
import Model.Ships.Ship_Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShipTest {

	private Ship carrierEnterprise;
	private Ship carrierLexington;
	private Ship carrierVictorious;
	private Ship carrierWasp;
	private Ship battleship;

	@BeforeEach
	void setUp() {
		carrierEnterprise = new Ship(Ship_Type.Carrier, 10, 8, 0, "Enterprise");
		carrierLexington = new Ship(Ship_Type.Carrier, 12, 9, 0, "Lexington");
		carrierVictorious = new Ship(Ship_Type.Carrier, 8, 9, 0, "Victorious");
		carrierWasp = new Ship(Ship_Type.Carrier, 10, 7, 0, "Wasp");
		battleship = new Ship(Ship_Type.Battleship, 20, 20, 12, "Indiana");
	}

	@Test
	void applyDamage() {
		// <editor-fold defaultstate="collapsed" desc="Checks for heavy damage working">
		carrierVictorious.applyDamage(1);
		assertFalse(carrierVictorious.isHeavilyDamaged());
		carrierVictorious.applyDamage(1);
		assertFalse(carrierVictorious.isHeavilyDamaged());
		carrierVictorious.applyDamage(1);
		assertFalse(carrierVictorious.isHeavilyDamaged());
		carrierVictorious.applyDamage(1);
		assertFalse(carrierVictorious.isHeavilyDamaged());
		carrierVictorious.applyDamage(1);
		assertTrue(carrierVictorious.isHeavilyDamaged());

		carrierWasp.applyDamage(3);
		assertFalse(carrierWasp.isHeavilyDamaged());
		carrierWasp.applyDamage(2);
		assertTrue(carrierWasp.isHeavilyDamaged());

		carrierLexington.applyDamage(2);
		assertFalse(carrierLexington.isHeavilyDamaged());
		carrierLexington.applyDamage(2);
		assertFalse(carrierLexington.isHeavilyDamaged());
		carrierLexington.applyDamage(1);
		assertFalse(carrierLexington.isHeavilyDamaged());
		carrierLexington.applyDamage(1);
		assertTrue(carrierLexington.isHeavilyDamaged());

		carrierEnterprise.applyDamage(1);
		assertFalse(carrierEnterprise.isHeavilyDamaged());
		carrierEnterprise.applyDamage(4);
		assertTrue(carrierEnterprise.isHeavilyDamaged());

		battleship.applyDamage(5);
		assertFalse(battleship.isHeavilyDamaged());
		battleship.applyDamage(4);
		assertFalse(battleship.isHeavilyDamaged());
		battleship.applyDamage(1);
		assertTrue(battleship.isHeavilyDamaged());
		// </editor-fold>
	}
}