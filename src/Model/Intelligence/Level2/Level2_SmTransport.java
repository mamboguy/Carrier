package Model.Intelligence.Level2;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.Level1.Level1_Transport;
import Model.Intelligence.Level3.Transport.Level3_TransportB;
import Model.Intelligence.Level3.Transport.Level3_TransportC;
import Model.Intelligence.Level3.Transport.Level3_TransportD;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level2_SmTransport extends Level2{

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {
		switch (dieRoll){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				return new Level3_TransportD();
			case 6:
			case 7:
			case 8:
				return new Level3_TransportC();
			case 9:
			case 10:
				return new Level3_TransportB();
			default:
				throw new UnsupportedOperationException();
		}
	}

	@Override
	public IIntelligence downgradeIntelligence() {
		return new Level1_Transport();
	}
}
