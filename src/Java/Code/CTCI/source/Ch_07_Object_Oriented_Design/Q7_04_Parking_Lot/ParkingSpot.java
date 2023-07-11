package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot;

@SuppressWarnings("unused")
public class ParkingSpot {
  private final VehicleSize spotSize;
  private final int row;
  private final int spotNumber;
  private final Level level;
  private Vehicle vehicle;

  public ParkingSpot(Level lvl, int r, int n, VehicleSize sz) {
    level = lvl;
    row = r;
    spotNumber = n;
    spotSize = sz;
  }

  public boolean park(Vehicle v) {
    /* Park vehicle in this spot. */
    if (!canFitVehicle(v)) {
      return false;
    }
    vehicle = v;
    vehicle.parkInSpot(this);
    return true;
  }

  public boolean canFitVehicle(Vehicle vehicle) {
    /* Checks if the spot is big enough for the vehicle (and is available). This compares
    the SIZE only. It does not check if it has enough spots. */
    return isAvailable() && vehicle.canFitInSpot(this);
  }

  public boolean isAvailable() {
    return vehicle == null;
  }

  public int getRow() {
    return row;
  }

  public int getSpotNumber() {
    return spotNumber;
  }

  public VehicleSize getSize() {
    return spotSize;
  }

  public void removeVehicle() {
    /* Remove vehicle from spot, and notify level that a new spot is available. */
    level.spotFreed();
    vehicle = null;
  }

  public void print() {
    if (vehicle == null) {
      if (spotSize == VehicleSize.Compact) {
        System.out.print("c");
      } else if (spotSize == VehicleSize.Large) {
        System.out.print("l");
      } else if (spotSize == VehicleSize.Motorcycle) {
        System.out.print("m");
      }
    } else {
      vehicle.print();
    }
  }
}
