package Java.test.ctci.old.ch_07_Object_Oriented_Design.q7_04_Parking_Lot;

import static org.junit.Assert.*;

import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot.Bus;
import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot.Level;
import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot.ParkingSpot;
import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot.VehicleSize;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"ConstantValue", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BusTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void Bus() {
    Bus bus = new Bus();
    assertNotNull(bus);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void print() {
    Bus bus = new Bus();
    System.out.format("%s:\n", name.getMethodName());
    bus.print();
  }

  @Test
  public void canFitInSpot() {
    Bus bus = new Bus();
    int flr = 1;
    int numberSpots = 2;
    Level lvl = new Level(flr, numberSpots);
    int r = 1;
    int n = 1;
    ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, VehicleSize.Large);
    boolean result = bus.canFitInSpot(parkingSpot);
    assertTrue(result);
    System.out.format("%s: canFitInSpot - %b\n", name.getMethodName(), result);
  }
}
