package Model.Plane;

import java.util.ArrayList;

/**
 Created on 18 Oct 2020

 @Author - Mambo */

public class PlaneList extends ArrayList{

	private ArrayList<Plane> planeList;

	public PlaneList(){
		super();
		planeList = new ArrayList<Plane>();
	}

	@Override
	public boolean contains(Object o) {

		for (Plane item : planeList) {
			if (((Plane)o).getID() == item.getID()){
				return true;
			}
		}

		return false;
	}
}
