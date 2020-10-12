package Model.Intelligence.IntelligenceLevelModels.Level2;

import Model.Intelligence.IIntelligence;
import Model.Intelligence.IntelligenceLevelModels.Level1.Level1_Transport;
import Model.Intelligence.IntelligenceLevelModels.Level3.Transport.Level3_TransportA;
import Model.Intelligence.IntelligenceLevelModels.Level3.Transport.Level3_TransportB;
import Model.Intelligence.IntelligenceLevelModels.Level3.Transport.Level3_TransportC;
import Model.Intelligence.IntelligenceLevelModels.Level3.Transport.Level3_TransportD;

/**
 Created on 11 Oct 2020

 @Author - Mambo */

public class Level2_MedTransport
		extends Level2{

	@Override
	public IIntelligence upgradeIntelligence(int dieRoll) {
		switch (dieRoll){
			case 1:
				return new Level3_TransportD();
			case 2:
			case 3:
			case 4:
			case 5:
				return new Level3_TransportC();
			case 6:
			case 7:
			case 8:
			case 9:
				return new Level3_TransportB();
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
