package Model.Intelligence.Level2;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.Level1.Level1_Transport;
import Model.Intelligence.Level3.Transport.Level3_TransportA;
import Model.Intelligence.Level3.Transport.Level3_TransportB;
import Model.Intelligence.Level3.Transport.Level3_TransportC;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level2_LgTransport
		extends Level2{

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {
		switch (dieRoll){
			case 1:
			case 2:
				return new Level3_TransportC();
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
				return new Level3_TransportB();
			case 8:
			case 9:
			case 10:
				return new Level3_TransportA();
			default:
				throw new UnsupportedOperationException();
		}
	}

	@Override
	public IIntelligence downgradeIntelligence() {
		return new Level1_Transport();
	}
}
