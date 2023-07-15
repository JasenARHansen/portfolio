package Java.test.ctci.old.ch_07_Object_Oriented_Design.q7_04_Parking_Lot;

import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot.Bus;
import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot.Level;
import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot.ParkingSpot;
import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot.VehicleSize;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"ConstantValue", "DuplicatedCode"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BusTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void Bus() {
        printTestHeader(name.getMethodName());
        Bus bus = new Bus();
        assertNotNull(bus);
    }

    @Test
    public void canFitInSpot() {
        printTestHeader(name.getMethodName());
        Bus bus = new Bus();
        int flr = 1;
        int numberSpots = 2;
        Level lvl = new Level(flr, numberSpots);
        int r = 1;
        int n = 1;
        ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, VehicleSize.Large);
        boolean result = bus.canFitInSpot(parkingSpot);
        assertTrue(result);
        System.out.format("\tcanFitInSpot - %b\n", result);
    }

    @Test
    public void print() {
        printTestHeader(name.getMethodName());
        Bus bus = new Bus();
        bus.print();
    }
}
