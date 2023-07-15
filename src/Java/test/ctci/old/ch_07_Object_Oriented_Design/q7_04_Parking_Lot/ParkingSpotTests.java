package Java.test.ctci.old.ch_07_Object_Oriented_Design.q7_04_Parking_Lot;

import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot.Car;
import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot.Level;
import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot.ParkingSpot;
import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot.VehicleSize;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.*;

@SuppressWarnings({"ConstantValue", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParkingSpotTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void ParkingSpot() {
        printTestHeader(name.getMethodName());
        int flr = 1;
        int numberSpots = 2;
        Level lvl = new Level(flr, numberSpots);
        int r = 1;
        int n = 1;
        VehicleSize size = VehicleSize.Large;
        ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, size);
        assertNotNull(parkingSpot);
    }

    @Test
    public void canFitVehicle() {
        printTestHeader(name.getMethodName());
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
        System.out.format("\tcanFitVehicle - %b\n", result);
    }

    @Test
    public void getRow() {
        printTestHeader(name.getMethodName());
        int flr = 1;
        int numberSpots = 2;
        Level lvl = new Level(flr, numberSpots);
        int r = 1;
        int n = 1;
        VehicleSize size = VehicleSize.Large;
        ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, size);
        int result = parkingSpot.getRow();
        assertEquals(r, result);
        System.out.format("\tgetRow - %d\n", result);
    }

    @Test
    public void getSize() {
        printTestHeader(name.getMethodName());
        int flr = 1;
        int numberSpots = 2;
        Level lvl = new Level(flr, numberSpots);
        int r = 1;
        int n = 1;
        VehicleSize size = VehicleSize.Large;
        ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, size);
        VehicleSize result = parkingSpot.getSize();
        assertEquals(size, result);
        System.out.format("\tgetSize - %s\n", result);
    }

    @Test
    public void getSpotNumber() {
        printTestHeader(name.getMethodName());
        int flr = 1;
        int numberSpots = 2;
        Level lvl = new Level(flr, numberSpots);
        int r = 1;
        int n = 1;
        VehicleSize size = VehicleSize.Large;
        ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, size);
        int result = parkingSpot.getSpotNumber();
        assertEquals(r, result);
        System.out.format("\tgetSpotNumber - %d\n", result);
    }

    @Test
    public void isAvailable() {
        printTestHeader(name.getMethodName());
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
        System.out.format("\tisAvailable - %b : %b\n", result_1, result_2);
    }

    @Test
    public void park() {
        printTestHeader(name.getMethodName());
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
        System.out.format("\tpark - %b\n", result);
    }

    @Test
    public void print() {
        printTestHeader(name.getMethodName());
        int flr = 1;
        int numberSpots = 2;
        Level lvl = new Level(flr, numberSpots);
        int r = 1;
        int n = 1;
        VehicleSize size = VehicleSize.Large;
        ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, size);
        parkingSpot.print();
    }

    @Test
    public void removeVehicle() {
        printTestHeader(name.getMethodName());
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
        System.out.format("\tremoveVehicle - %b : %b\n", result_1, result_2);
    }
}
