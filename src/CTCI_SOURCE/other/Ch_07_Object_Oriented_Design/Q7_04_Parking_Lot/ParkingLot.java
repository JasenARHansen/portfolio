package CTCI_SOURCE.other.Ch_07_Object_Oriented_Design.Q7_04_Parking_Lot;

public class ParkingLot {
    private final int NUM_LEVELS = 5;
    private final Level[] levels;

    public ParkingLot() {
        levels = new Level[NUM_LEVELS];
        for (int i = 0; i < NUM_LEVELS; i++) {
            levels[i] = new Level(i, 30);
        }
    }

    /* Park the vehicle in a spot (or multiple spots). Return false if failed. */
    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < levels.length; i++) {
            System.out.print("Level" + i + ": ");
            levels[i].print();
            System.out.println();
        }
        System.out.println();
    }
}
