package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot;

public class Bus extends Vehicle {
  public Bus() {
    spotsNeeded = 5;
    size = VehicleSize.Large;
  }

  public boolean canFitInSpot(ParkingSpot spot) {
    return spot.getSize() == VehicleSize.Large;
  }

  public void print() {
    System.out.print("B");
  }
}
