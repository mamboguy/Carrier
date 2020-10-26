//package Model.Ships.OLD_CODE;
//
//import Controller.Events.PlaneMoved.PlaneMoveListener;
//import Controller.Events.PlaneMoved.PlaneMovedEvent;
//import Controller.GameMaster.GameSettings;
//import Model.Interfaces.IAirfield;
//import Model.Plane.Plane;
//
//import javax.swing.*;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public abstract class Carrier
//		extends Ship
//		implements IAirfield {
//
//	private final int hangarCapacity;
//	private AirfieldOps airfieldController;
//	private int deckINOP;
//	private boolean deckDisabled;
//
//	//Light, Medium, Heavy, Dead in water
//	private int[] damageThresholds;
//
//	private List listeners;
//
//	public static final String CV_TYPE = "CV";
//	public static final String CVE_TYPE = "CVE";
//	public static final String CVL_TYPE = "CVL";
//
//	public static final String LOCATION_FLT_DECK_READY = "FltDeckReady";
//	public static final String LOCATION_FLT_DECK_UNREADY = "FltDeckUnready";
//	public static final String LOCATION_SERVICING_AREA = "ServicingArea";
//	public static final String LOCATION_HANGAR_AREA = "HangarArea";
//
//	public Carrier(String[] args) {
//		super(args);
//
//		listeners = new ArrayList();
//		damageThresholds = new int[4];
//
//		this.hangarCapacity = Integer.parseInt(args[2]);
//
//		if (getNationality().isAmerican()) {
//			for (int i = 0; i < 4; i++) {
//				damageThresholds[i] = Integer.parseInt(args[11 + i]);
//			}
//		}
//		servicingArea = new ArrayList<>();
//		hangarArea = new ArrayList<>();
//		fltDeckReady = new ArrayList<>();
//		fltDeckUnready = new ArrayList<>();
//
//		airfieldController = new AirfieldOps(GameSettings.SEA_BASED);
//		deckINOP = 0;
//		deckDisabled = false;
//
//		ADDTESTAIRCRAFT();
//	}
//
//	//TESTING PURPOSES ONLY
//	private void ADDTESTAIRCRAFT() {
//		for (int i = 0; i < 2; i++) {
//			servicingArea.add(new TBD(GameSettings.SEA_BASED));
//			hangarArea.add(new F4F(GameSettings.SEA_BASED));
//		}
//		;
//		fltDeckReady.add(new TBF(GameSettings.SEA_BASED));
//		fltDeckReady.get(0).setCombatReady();
//		fltDeckUnready.add(new SBD(GameSettings.SEA_BASED));
//	}
//
//	//<editor-fold defaultstate="collapsed" desc="Getters">
//
//	@Override
//	public boolean canShoreMove() {
//		return false;
//	}
//
//	public int getPlaneCount() {
//		return getFltDeckCount() + servicingArea.size() + hangarArea.size();
//	}
//
//	private int getFltDeckCount() {
//		return fltDeckReady.size() + fltDeckUnready.size();
//	}
//
//	public int getPurchaseCost() {
//		return 0;
//	}
//
//	public int getHangarCapacity() {
//		return hangarCapacity;
//	}
//	//</editor-fold>
//
//	//<editor-fold defaultstate="collapsed" desc="Plane Transition Methods">
//	@Override
//	public boolean landPlane(Plane plane) {
//		if (!airfieldController.landPlane(plane)) {
//			//Error already shown, just return false below
//
//		} else if (getPlaneCount() >= hangarCapacity) {
//			//Show error that carrier is too full
//
//		} else if (getFltDeckCount() >= AirfieldOps.MAX_FLT_DECK_CAPACITY) {
//			//Show error that flt deck is too full
//
//		} else if (getCurrentDamageType() >= DEAD_IN_WATER) {
//			//Error that carrier unable to land b/c dead in water
//
//		} else {
//
//			//Set plane has moved on airfield
//			plane.setMoved();
//
//			//Add plane to unready portion of airfield
//			fltDeckUnready.add(plane);
//
//			//Unset that launching is allowed
//			airfieldController.setNoLaunchingAllowed();
//
//			plane.unsetAloft();
//
//			firePlaneMovedEvent(LOCATION_FLT_DECK_UNREADY);
//
//			return true;
//		}
//
//		return false;
//	}
//
//	@Override
//	public boolean launchPlane(Plane plane) {
//
//		if (!airfieldController.launchPlane(plane)) {
//			//Error already shown, just return false below
//
//		} else if (!fltDeckReady.contains(plane)) {
//			//Error that flt deck does not contain that plane
//
//		} else if (getFltDeckCount() >= 8) {
//			//Error that flt deck is too full to launch
//
//		} else if (getCurrentDamageType() >= DEAD_IN_WATER) {
//			//Error that carrier unable to land b/c dead in water
//
//		} else {
//			//Add plane to unready portion of airfield
//			fltDeckReady.remove(plane);
//
//			//Unset that launching is allowed
//			airfieldController.setNoLandingAllowed();
//
//			plane.setMoved();
//
//			plane.setAloft();
//
//			firePlaneMovedEvent(LOCATION_FLT_DECK_READY);
//
//			return true;
//		}
//
//		return false;
//
//	}
//
//	@Override
//	public boolean raisePlane(Plane plane) {
//
//		if (!airfieldController.raisePlane(plane)) {
//			System.out.println("Not valid");
//			//Error already shown, just return false below
//
//		} else if (!(servicingArea.contains(plane) || hangarArea.contains(plane))) {
//			System.out.println("Not in servicing");
//			//Error that flt deck does not contain that plane
//
//		} else if (getFltDeckCount() >= 8) {
//			System.out.println("flt deck full");
//			//Error that flt deck is too full to launch
//
//		} else {
//
//			plane.setMoved();
//
//			try {
//				if (servicingArea.remove(plane)) {
//					firePlaneMovedEvent(LOCATION_SERVICING_AREA);
//				}
//				if (hangarArea.remove(plane)) {
//					firePlaneMovedEvent(LOCATION_HANGAR_AREA);
//				}
//			} catch (Exception e) {
//			}
//
//			if (plane.isCombatReady()) {
//				fltDeckReady.add(plane);
//				firePlaneMovedEvent(LOCATION_FLT_DECK_READY);
//			} else {
//				fltDeckUnready.add(plane);
//				firePlaneMovedEvent(LOCATION_FLT_DECK_UNREADY);
//			}
//
//			return true;
//		}
//
//		return false;
//	}
//
//	@Override
//	public boolean lowerPlaneToHangar(Plane plane) {
//		if (!airfieldController.lowerPlane(plane)) {
//			//Error already shown, just return false below
//
//		} else if (!(fltDeckUnready.contains(plane) || fltDeckReady.contains(plane))) {
//			//Error that flt deck does not contain that plane
//
//		} else {
//
//			//Set plane has moved
//			plane.setMoved();
//
//			try {
//				if (fltDeckUnready.remove(plane)) {
//					firePlaneMovedEvent(LOCATION_FLT_DECK_UNREADY);
//				}
//				if (fltDeckReady.remove(plane)) {
//					firePlaneMovedEvent(LOCATION_FLT_DECK_READY);
//				}
//			} catch (Exception e) {
//			}
//
//			plane.unsetCombatReady();
//
//			hangarArea.add(plane);
//
//			firePlaneMovedEvent(LOCATION_HANGAR_AREA);
//
//			return true;
//		}
//
//		return false;
//	}
//
//	@Override
//	public boolean lowerPlaneToServicing(Plane plane) {
//		if (!airfieldController.lowerPlane(plane)) {
//			//Error already shown, just return false below
//
//		} else if (!fltDeckReady.contains(plane)) {
//			//Error that flt deck does not contain that plane
//
//		} else if (servicingArea.size() >= 8) {
//			//Error that servicing area is too full
//
//		} else {
//
//			//Set plane has moved
//			plane.setMoved();
//
//			fltDeckReady.remove(plane);
//
//			firePlaneMovedEvent(LOCATION_FLT_DECK_READY);
//
//			plane.unsetCombatReady();
//
//			servicingArea.add(plane);
//
//			firePlaneMovedEvent(LOCATION_SERVICING_AREA);
//
//			return true;
//		}
//
//		return false;
//	}
//
//	@Override
//	public boolean moveHangarToServicing(Plane plane) {
//		if (!airfieldController.moveHangarToServicing(plane)) {
//
//		} else if (servicingArea.size() >= 8) {
//			//Error that servicing area is too full
//
//		} else if (!hangarArea.contains(plane)) {
//			//Error that plane is not in servicingArea
//
//		} else {
//			servicingArea.add(plane);
//
//			firePlaneMovedEvent(LOCATION_SERVICING_AREA);
//
//			hangarArea.remove(plane);
//
//			firePlaneMovedEvent(LOCATION_HANGAR_AREA);
//
//			plane.setMoved();
//
//			return true;
//		}
//
//		return false;
//	}
//
//	@Override
//	public boolean moveServicingToHangar(Plane plane) {
//		if (!airfieldController.moveServicingToHangar(plane)) {
//
//		} else if (!servicingArea.contains(plane)) {
//			//Error that plane is not in servicingArea
//			System.out.println("Not in servicing area");
//
//		} else {
//			firePlaneMovedEvent(LOCATION_SERVICING_AREA);
//
//			servicingArea.remove(plane);
//
//			firePlaneMovedEvent(LOCATION_HANGAR_AREA);
//
//			hangarArea.add(plane);
//
//			plane.unsetCombatReady();
//
//			plane.setMoved();
//
//			return true;
//		}
//
//		return false;
//	}
//	//</editor-fold>
//
//	//<editor-fold defaultstate="collapsed" desc="ArrayList Returs">
//	public ArrayList<Plane> getServicingArea() {
//		return this.servicingArea;
//	}
//
//	public ArrayList<Plane> getHangarArea() {
//		return this.hangarArea;
//	}
//
//	public ArrayList<Plane> getFltDeckReady() {
//		return this.fltDeckReady;
//	}
//
//	public ArrayList<Plane> getFltDeckUnready() {
//		return this.fltDeckUnready;
//	}
//	//</editor-fold>
//
//	public JPanel drawToHotSwap() {
//		//IMPLEMENT ME
//		throw new UnsupportedOperationException();
//	}
//
//	//<editor-fold defaultstate="collapsed" desc="Point Scoring">
//	//TODO - Implement point scoring methods on carrier
//	@Override
//	public int scorePoints() {
//		throw new UnsupportedOperationException(
//				"Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//	}
//
//	@Override
//	protected int getHeavyDamagePoints() {
//		throw new UnsupportedOperationException("Not supported yet.");
//	}
//
//	@Override
//	protected int getSunkDamagePoints() {
//		throw new UnsupportedOperationException("Not supported yet.");
//	}
//	//</editor-fold>
//
//	//TODO FIX THIS
//	@Override
//	public boolean processDamage(int numHits) {
//		//Takes numHits as health damage
//		addDamage(numHits);
//
//		if (numHits > 0 && getCurrentDamageType() >= MEDIUM_DAMAGE) {
//			deckINOP += 2;
//		}
//
//		if (getCurrentDamageType() >= DEAD_IN_WATER) {
//			deckDisabled = true;
//		}
//
//		return (getCurrentDamageType() == SUNK);
//	}
//
//	private int getCurrentDamageType() {
//
//		if (getCurrentDamage() >= getHP()) {
//			return SUNK;
//		} else if (getCurrentDamage() == 0) {
//			return NO_DAMAGE;
//		}
//
//		if (getNationality().isAmerican()) {
//			if (getCurrentDamage() >= damageThresholds[3]) {
//				return DEAD_IN_WATER;
//			} else if (getCurrentDamage() >= damageThresholds[2]) {
//				return HEAVY_DAMAGE;
//			} else if (getCurrentDamage() >= damageThresholds[1]) {
//				return MEDIUM_DAMAGE;
//			} else {
//				return LIGHT_DAMAGE;
//			}
//		} else {
//			if (getCurrentDamage() >= Math.floorDiv(getHP(), 2)) {
//				return HEAVY_DAMAGE;
//			} else if (getCurrentDamage() > 0) {
//				return LIGHT_DAMAGE;
//			} else {
//				return NO_DAMAGE;
//			}
//		}
//	}
//
//	@Override
//	public int moveDistance() {
//		if (getCurrentDamageType() >= DEAD_IN_WATER) {
//			return 0;
//		} else {
//			return 1;
//		}
//	}
//
//	public String toString() {
//		String s = super.toString();
//		s += "\nDamage Thresholds (Light, Medium, Heavy, DiW): ";
//		for (int i = 0; i < damageThresholds.length; i++) {
//			s += this.damageThresholds[i] + ", ";
//		}
//		s = s.substring(0, s.length() - 2) + "\n";
//
//		return s;
//	}
//
//	@Override
//	public void stepReset() {
//		airfieldController.stepReset();
//
//		for (Plane temp : servicingArea) {
//			temp.stepReset();
//			temp.setCombatReady();
//		}
//
//		for (Plane temp : hangarArea) {
//			temp.stepReset();
//		}
//
//		for (Plane temp : fltDeckReady) {
//			temp.stepReset();
//		}
//
//		for (Plane temp : fltDeckUnready) {
//			temp.stepReset();
//		}
//	}
//
//	@Override
//	public void turnReset() {
//		//IMPLEMENT ME
//	}
//
//	public synchronized void addPlaneMoveListener(PlaneMoveListener pml) {
//		listeners.add(pml);
//	}
//
//	public synchronized void removePlaneMoveListener(PlaneMoveListener pml) {
//		listeners.remove(pml);
//	}
//
//	private synchronized void firePlaneMovedEvent(String location) {
//		PlaneMovedEvent event = new PlaneMovedEvent(this, location);
//
//		Iterator list = listeners.iterator();
//
//		while (list.hasNext()) {
//			((PlaneMoveListener) list.next()).planeMoved(event);
//		}
//	}
//
//}