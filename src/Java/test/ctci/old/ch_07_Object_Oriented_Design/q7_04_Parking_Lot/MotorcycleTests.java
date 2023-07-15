package Java.test.ctci.old.ch_07_Object_Oriented_Design.q7_04_Parking_Lot;

import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot.Level;
import Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot.Motorcycle;
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
public class MotorcycleTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void Motorcycle() {
        printTestHeader(name.getMethodName());
        Motorcycle motorcycle = new Motorcycle();
        assertNotNull(motorcycle);
    }

    @Test
    public void canFitInSpot() {
        printTestHeader(name.getMethodName());
        Motorcycle motorcycle = new Motorcycle();
        int flr = 1;
        int numberSpots = 2;
        Level lvl = new Level(flr, numberSpots);
        int r = 1;
        int n = 1;
        ParkingSpot parkingSpot = new ParkingSpot(lvl, r, n, VehicleSize.Large);
        boolean result = motorcycle.canFitInSpot(parkingSpot);
        assertTrue(result);
        System.out.format("\tcanFitInSpot - %b\n", result);
    }

    @Test
    public void print() {
        printTestHeader(name.getMethodName());
        Motorcycle motorcycle = new Motorcycle();
        motorcycle.print();
    }
}
