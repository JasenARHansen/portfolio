package Java.test.ctci.old.ch_07_Object_Oriented_Design.q7_04_Parking_Lot;

import static org.junit.Assert.*;

import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot.*;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@SuppressWarnings({"ConstantValue", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParkingSpotTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void ParkingSpot() {
    int flr = 1;
    int numberSpots = 2;
    Level lvl = new Level(flr, numberSpots);
    int r = 1;
    int n = 1;
    VehicleSize size = VehicleSize.Large;
    ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, size);
    assertNotNull(parkingSpot);
    System.out.format("%s:\n", name.getMethodName());
  }

  @Test
  public void print() {
    int flr = 1;
    int numberSpots = 2;
    Level lvl = new Level(flr, numberSpots);
    int r = 1;
    int n = 1;
    VehicleSize size = VehicleSize.Large;
    ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, size);
    System.out.format("%s:\n", name.getMethodName());
    parkingSpot.print();
  }

  @Test
  public void park() {
    int flr = 1;
    int numberSpots = 2;
    Level lvl = new Level(flr, numberSpots);
    int r = 1;
    int n = 1;
    VehicleSize size = VehicleSize.Large;
    ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, size);
    Car car = new Car();
    boolean result = parkingSpot.park(car);
    assertTrue(result);
    System.out.format("%s: park - %b\n", name.getMethodName(), result);
  }

  @Test
  public void canFitVehicle() {
    int flr = 1;
    int numberSpots = 2;
    Level lvl = new Level(flr, numberSpots);
    int r = 1;
    int n = 1;
    VehicleSize size = VehicleSize.Large;
    ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, size);
    Car car = new Car();
    boolean result = parkingSpot.canFitVehicle(car);
    assertTrue(result);
    System.out.format("%s: canFitVehicle - %b\n", name.getMethodName(), result);
  }

  @Test
  public void isAvailable() {
    int flr = 1;
    int numberSpots = 2;
    Level lvl = new Level(flr, numberSpots);
    int r = 1;
    int n = 1;
    VehicleSize size = VehicleSize.Large;
    ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, size);
    boolean result_1 = parkingSpot.isAvailable();
    Car car = new Car();
    parkingSpot.park(car);
    boolean result_2 = parkingSpot.isAvailable();
    assertTrue(result_1);
    assertFalse(result_2);
    System.out.format("%s: isAvailable - %b : %b\n", name.getMethodName(), result_1, result_2);
  }

  @Test
  public void getRow() {
    int flr = 1;
    int numberSpots = 2;
    Level lvl = new Level(flr, numberSpots);
    int r = 1;
    int n = 1;
    VehicleSize size = VehicleSize.Large;
    ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, size);
    int result = parkingSpot.getRow();
    assertEquals(r, result);
    System.out.format("%s: getRow - %d\n", name.getMethodName(), result);
  }

  @Test
  public void getSpotNumber() {
    int flr = 1;
    int numberSpots = 2;
    Level lvl = new Level(flr, numberSpots);
    int r = 1;
    int n = 1;
    VehicleSize size = VehicleSize.Large;
    ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, size);
    int result = parkingSpot.getSpotNumber();
    assertEquals(r, result);
    System.out.format("%s: getSpotNumber - %d\n", name.getMethodName(), result);
  }

  @Test
  public void getSize() {
    int flr = 1;
    int numberSpots = 2;
    Level lvl = new Level(flr, numberSpots);
    int r = 1;
    int n = 1;
    VehicleSize size = VehicleSize.Large;
    ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, size);
    VehicleSize result = parkingSpot.getSize();
    assertEquals(size, result);
    System.out.format("%s: getSize - %s\n", name.getMethodName(), result);
  }

  @Test
  public void removeVehicle() {
    int flr = 1;
    int numberSpots = 2;
    Level lvl = new Level(flr, numberSpots);
    int r = 1;
    int n = 1;
    VehicleSize size = VehicleSize.Large;
    ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, size);
    Car car = new Car();
    parkingSpot.park(car);
    boolean result_1 = parkingSpot.isAvailable();
    parkingSpot.removeVehicle();
    boolean result_2 = parkingSpot.isAvailable();
    assertFalse(result_1);
    assertTrue(result_2);
    System.out.format("%s: removeVehicle - %b : %b\n", name.getMethodName(), result_1, result_2);
  }
}
