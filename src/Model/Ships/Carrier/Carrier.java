/**
 package Model.Ships.OLD_CODE;
 <p>
 import Controller.Events.PlaneMoved.PlaneMoveListener;
 import Controller.Events.PlaneMoved.PlaneMovedEvent;
 import Controller.GameMaster.GameSettings;
 import Model.Interfaces.IAirfield;
 import Model.Plane.*;
 <p>
 import javax.swing.*;
 import java.util.ArrayList;
 import java.util.Iterator;
 import java.util.List;
 <p>
 public abstract class Carrier
 extends Ship
 implements IAirfield {
 <p>
 private final int hangarCapacity;
 private AirfieldOps airfieldController;
 private int deckINOP;
 private boolean deckDisabled;
 <p>
 //Light, Medium, Heavy, Dead in water
 private int[] damageThresholds;
 <p>
 private List listeners;
 <p>
 public static final String CV_TYPE = "CV";
 public static final String CVE_TYPE = "CVE";
 public static final String CVL_TYPE = "CVL";
 <p>
 public static final String LOCATION_FLT_DECK_READY = "FltDeckReady";
 public static final String LOCATION_FLT_DECK_UNREADY = "FltDeckUnready";
 public static final String LOCATION_SERVICING_AREA = "ServicingArea";
 public static final String LOCATION_HANGAR_AREA = "HangarArea";
 <p>
 public Carrier(String[] args) {
 super(args);
 <p>
 listeners = new ArrayList();
 damageThresholds = new int[4];
 <p>
 this.hangarCapacity = Integer.parseInt(args[2]);
 <p>
 if (getNationality().isAmerican()) {
 for (int i = 0; i < 4; i++) {
 damageThresholds[i] = Integer.parseInt(args[11 + i]);
 }
 }
 servicingArea = new ArrayList<>();
 hangarArea = new ArrayList<>();
 fltDeckReady = new ArrayList<>();
 fltDeckUnready = new ArrayList<>();
 <p>
 airfieldController = new AirfieldOps(GameSettings.SEA_BASED);
 deckINOP = 0;
 deckDisabled = false;
 <p>
 ADDTESTAIRCRAFT();
 }
 <p>
 //TESTING PURPOSES ONLY
 private void ADDTESTAIRCRAFT() {
 for (int i = 0; i < 2; i++) {
 servicingArea.add(new TBD(GameSettings.SEA_BASED));
 hangarArea.add(new F4F(GameSettings.SEA_BASED));
 }
 ;
 fltDeckReady.add(new TBF(GameSettings.SEA_BASED));
 fltDeckReady.get(0).setCombatReady();
 fltDeckUnready.add(new SBD(GameSettings.SEA_BASED));
 }
 <p>
 //<editor-fold defaultstate="collapsed" desc="Getters">

 @Override public boolean canShoreMove() {
 return false;
 }
 <p>
 public int getPlaneCount() {
 return getFltDeckCount() + servicingArea.size() + hangarArea.size();
 }
 <p>
 private int getFltDeckCount() {
 return fltDeckReady.size() + fltDeckUnready.size();
 }
 <p>
 public int getPurchaseCost() {
 return 0;
 }
 <p>
 public int getHangarCapacity() {
 return hangarCapacity;
 }
 //</editor-fold>
 <p>
 //<editor-fold defaultstate="collapsed" desc="Plane Transition Methods">
 @Override public boolean landPlane(Plane plane) {
 if (!airfieldController.landPlane(plane)) {
 //Error already shown, just return false below
 <p>
 } else if (getPlaneCount() >= hangarCapacity) {
 //Show error that carrier is too full
 <p>
 } else if (getFltDeckCount() >= AirfieldOps.MAX_FLT_DECK_CAPACITY) {
 //Show error that flt deck is too full
 <p>
 } else if (getCurrentDamageType() >= DEAD_IN_WATER) {
 //Error that carrier unable to land b/c dead in water
 <p>
 } else {
 <p>
 //Set plane has moved on airfield
 plane.setMoved();
 <p>
 //Add plane to unready portion of airfield
 fltDeckUnready.add(plane);
 <p>
 //Unset that launching is allowed
 airfieldController.setNoLaunchingAllowed();
 <p>
 plane.unsetAloft();
 <p>
 firePlaneMovedEvent(LOCATION_FLT_DECK_UNREADY);
 <p>
 return true;
 }
 <p>
 return false;
 }
 @Override public boolean launchPlane(Plane plane) {
 <p>
 if (!airfieldController.launchPlane(plane)) {
 //Error already shown, just return false below
 <p>
 } else if (!fltDeckReady.contains(plane)) {
 //Error that flt deck does not contain that plane
 <p>
 } else if (getFltDeckCount() >= 8) {
 //Error that flt deck is too full to launch
 <p>
 } else if (getCurrentDamageType() >= DEAD_IN_WATER) {
 //Error that carrier unable to land b/c dead in water
 <p>
 } else {
 //Add plane to unready portion of airfield
 fltDeckReady.remove(plane);
 <p>
 //Unset that launching is allowed
 airfieldController.setNoLandingAllowed();
 <p>
 plane.setMoved();
 <p>
 plane.setAloft();
 <p>
 firePlaneMovedEvent(LOCATION_FLT_DECK_READY);
 <p>
 return true;
 }
 <p>
 return false;
 <p>
 }
 @Override public boolean raisePlane(Plane plane) {
 <p>
 if (!airfieldController.raisePlane(plane)) {
 System.out.println("Not valid");
 //Error already shown, just return false below
 <p>
 } else if (!(servicingArea.contains(plane) || hangarArea.contains(plane))) {
 System.out.println("Not in servicing");
 //Error that flt deck does not contain that plane
 <p>
 } else if (getFltDeckCount() >= 8) {
 System.out.println("flt deck full");
 //Error that flt deck is too full to launch
 <p>
 } else {
 <p>
 plane.setMoved();
 <p>
 try {
 if (servicingArea.remove(plane)) {
 firePlaneMovedEvent(LOCATION_SERVICING_AREA);
 }
 if (hangarArea.remove(plane)) {
 firePlaneMovedEvent(LOCATION_HANGAR_AREA);
 }
 } catch (Exception e) {
 }
 <p>
 if (plane.isCombatReady()) {
 fltDeckReady.add(plane);
 firePlaneMovedEvent(LOCATION_FLT_DECK_READY);
 } else {
 fltDeckUnready.add(plane);
 firePlaneMovedEvent(LOCATION_FLT_DECK_UNREADY);
 }
 <p>
 return true;
 }
 <p>
 return false;
 }
 @Override public boolean lowerPlaneToHangar(Plane plane) {
 if (!airfieldController.lowerPlane(plane)) {
 //Error already shown, just return false below
 <p>
 } else if (!(fltDeckUnready.contains(plane) || fltDeckReady.contains(plane))) {
 //Error that flt deck does not contain that plane
 <p>
 } else {
 <p>
 //Set plane has moved
 plane.setMoved();
 <p>
 try {
 if (fltDeckUnready.remove(plane)) {
 firePlaneMovedEvent(LOCATION_FLT_DECK_UNREADY);
 }
 if (fltDeckReady.remove(plane)) {
 firePlaneMovedEvent(LOCATION_FLT_DECK_READY);
 }
 } catch (Exception e) {
 }
 <p>
 plane.unsetCombatReady();
 <p>
 hangarArea.add(plane);
 <p>
 firePlaneMovedEvent(LOCATION_HANGAR_AREA);
 <p>
 return true;
 }
 <p>
 return false;
 }
 @Override public boolean lowerPlaneToServicing(Plane plane) {
 if (!airfieldController.lowerPlane(plane)) {
 //Error already shown, just return false below
 <p>
 } else if (!fltDeckReady.contains(plane)) {
 //Error that flt deck does not contain that plane
 <p>
 } else if (servicingArea.size() >= 8) {
 //Error that servicing area is too full
 <p>
 } else {
 <p>
 //Set plane has moved
 plane.setMoved();
 <p>
 fltDeckReady.remove(plane);
 <p>
 firePlaneMovedEvent(LOCATION_FLT_DECK_READY);
 <p>
 plane.unsetCombatReady();
 <p>
 servicingArea.add(plane);
 <p>
 firePlaneMovedEvent(LOCATION_SERVICING_AREA);
 <p>
 return true;
 }
 <p>
 return false;
 }
 @Override public boolean moveHangarToServicing(Plane plane) {
 if (!airfieldController.moveHangarToServicing(plane)) {
 <p>
 } else if (servicingArea.size() >= 8) {
 //Error that servicing area is too full
 <p>
 } else if (!hangarArea.contains(plane)) {
 //Error that plane is not in servicingArea
 <p>
 } else {
 servicingArea.add(plane);
 <p>
 firePlaneMovedEvent(LOCATION_SERVICING_AREA);
 <p>
 hangarArea.remove(plane);
 <p>
 firePlaneMovedEvent(LOCATION_HANGAR_AREA);
 <p>
 plane.setMoved();
 <p>
 return true;
 }
 <p>
 return false;
 }
 @Override public boolean moveServicingToHangar(Plane plane) {
 if (!airfieldController.moveServicingToHangar(plane)) {
 <p>
 } else if (!servicingArea.contains(plane)) {
 //Error that plane is not in servicingArea
 System.out.println("Not in servicing area");
 <p>
 } else {
 firePlaneMovedEvent(LOCATION_SERVICING_AREA);
 <p>
 servicingArea.remove(plane);
 <p>
 firePlaneMovedEvent(LOCATION_HANGAR_AREA);
 <p>
 hangarArea.add(plane);
 <p>
 plane.unsetCombatReady();
 <p>
 plane.setMoved();
 <p>
 return true;
 }
 <p>
 return false;
 }
 //</editor-fold>
 <p>
 //<editor-fold defaultstate="collapsed" desc="ArrayList Returs">
 public ArrayList<Plane> getServicingArea() {
 return this.servicingArea;
 }
 <p>
 public ArrayList<Plane> getHangarArea() {
 return this.hangarArea;
 }
 <p>
 public ArrayList<Plane> getFltDeckReady() {
 return this.fltDeckReady;
 }
 <p>
 public ArrayList<Plane> getFltDeckUnready() {
 return this.fltDeckUnready;
 }
 //</editor-fold>
 <p>
 public JPanel drawToHotSwap() {
 //IMPLEMENT ME
 throw new UnsupportedOperationException();
 }
 <p>
 //<editor-fold defaultstate="collapsed" desc="Point Scoring">
 //TODO - Implement point scoring methods on carrier
 @Override public int scorePoints() {
 throw new UnsupportedOperationException(
 "Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 }
 @Override protected int getHeavyDamagePoints() {
 throw new UnsupportedOperationException("Not supported yet.");
 }
 @Override protected int getSunkDamagePoints() {
 throw new UnsupportedOperationException("Not supported yet.");
 }
 //</editor-fold>
 <p>
 //TODO FIX THIS
 @Override public boolean processDamage(int numHits) {
 //Takes numHits as health damage
 addDamage(numHits);
 <p>
 if (numHits > 0 && getCurrentDamageType() >= MEDIUM_DAMAGE) {
 deckINOP += 2;
 }
 <p>
 if (getCurrentDamageType() >= DEAD_IN_WATER) {
 deckDisabled = true;
 }
 <p>
 return (getCurrentDamageType() == SUNK);
 }
 <p>
 private int getCurrentDamageType() {
 <p>
 if (getCurrentDamage() >= getHP()) {
 return SUNK;
 } else if (getCurrentDamage() == 0) {
 return NO_DAMAGE;
 }
 <p>
 if (getNationality().isAmerican()) {
 if (getCurrentDamage() >= damageThresholds[3]) {
 return DEAD_IN_WATER;
 } else if (getCurrentDamage() >= damageThresholds[2]) {
 return HEAVY_DAMAGE;
 } else if (getCurrentDamage() >= damageThresholds[1]) {
 return MEDIUM_DAMAGE;
 } else {
 return LIGHT_DAMAGE;
 }
 } else {
 if (getCurrentDamage() >= Math.floorDiv(getHP(), 2)) {
 return HEAVY_DAMAGE;
 } else if (getCurrentDamage() > 0) {
 return LIGHT_DAMAGE;
 } else {
 return NO_DAMAGE;
 }
 }
 }
 @Override public int moveDistance() {
 if (getCurrentDamageType() >= DEAD_IN_WATER) {
 return 0;
 } else {
 return 1;
 }
 }
 <p>
 public String toString() {
 String s = super.toString();
 s += "\nDamage Thresholds (Light, Medium, Heavy, DiW): ";
 for (int i = 0; i < damageThresholds.length; i++) {
 s += this.damageThresholds[i] + ", ";
 }
 s = s.substring(0, s.length() - 2) + "\n";
 <p>
 return s;
 }
 @Override public void stepReset() {
 airfieldController.stepReset();
 <p>
 for (Plane temp : servicingArea) {
 temp.stepReset();
 temp.setCombatReady();
 }
 <p>
 for (Plane temp : hangarArea) {
 temp.stepReset();
 }
 <p>
 for (Plane temp : fltDeckReady) {
 temp.stepReset();
 }
 <p>
 for (Plane temp : fltDeckUnready) {
 temp.stepReset();
 }
 }
 @Override public void turnReset() {
 //IMPLEMENT ME
 }
 <p>
 public synchronized void addPlaneMoveListener(PlaneMoveListener pml) {
 listeners.add(pml);
 }
 <p>
 public synchronized void removePlaneMoveListener(PlaneMoveListener pml) {
 listeners.remove(pml);
 }
 <p>
 private synchronized void firePlaneMovedEvent(String location) {
 PlaneMovedEvent event = new PlaneMovedEvent(this, location);
 <p>
 Iterator list = listeners.iterator();
 <p>
 while (list.hasNext()) {
 ((PlaneMoveListener) list.next()).planeMoved(event);
 }
 }
 <p>
 } */