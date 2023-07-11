package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot;

import java.util.ArrayList;

@SuppressWarnings("unused")
public abstract class Vehicle {
  protected final ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
  protected String licensePlate;
  protected int spotsNeeded;
  protected VehicleSize size;

  public int getSpotsNeeded() {
    return spotsNeeded;
  }

  public VehicleSize getSize() {
    return size;
  }

  public void parkInSpot(ParkingSpot spot) {
    /* Park vehicle in this spot (among others, potentially). */
    parkingSpots.add(spot);
  }

  public void clearSpots() {
    /* Remove car from spot, and notify spot that it's gone. */
    for (ParkingSpot parkingSpot : parkingSpots) {
      parkingSpot.removeVehicle();
    }
    parkingSpots.clear();
  }

  public abstract boolean canFitInSpot(ParkingSpot spot);

  public abstract void print();
}
