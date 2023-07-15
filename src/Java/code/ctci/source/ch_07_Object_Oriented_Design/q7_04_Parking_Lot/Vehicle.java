package Java.code.ctci.source.ch_07_Object_Oriented_Design.q7_04_Parking_Lot;

import java.util.ArrayList;

@SuppressWarnings("unused")
public abstract class Vehicle {
    protected final ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
    protected String licensePlate;
    protected VehicleSize size;
    protected int spotsNeeded;

    public abstract boolean canFitInSpot(ParkingSpot spot);

    public void clearSpots() {
        /* Remove car from spot, and notify spot that it's gone. */
        for (ParkingSpot parkingSpot : parkingSpots) {
            parkingSpot.removeVehicle();
        }
        parkingSpots.clear();
    }

    public VehicleSize getSize() {
        return size;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public void parkInSpot(ParkingSpot spot) {
        /* Park vehicle in this spot (among others, potentially). */
        parkingSpots.add(spot);
    }

    public abstract void print();
}
