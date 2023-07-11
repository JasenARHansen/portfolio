package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot;

public class Motorcycle extends Vehicle {
  public Motorcycle() {
    spotsNeeded = 1;
    size = VehicleSize.Motorcycle;
  }

  public boolean canFitInSpot(ParkingSpot spot) {
    return true;
  }

  public void print() {
    System.out.print("M");
  }
}
