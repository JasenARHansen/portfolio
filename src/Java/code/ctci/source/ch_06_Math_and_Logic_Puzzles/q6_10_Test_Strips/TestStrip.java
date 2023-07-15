package Java.code.ctci.source.ch_06_Math_and_Logic_Puzzles.q6_10_Test_Strips;

import java.util.ArrayList;

public class TestStrip {
    public static final int DAYS_FOR_RESULT = 7;
    private final ArrayList<ArrayList<Bottle>> dropsByDay = new ArrayList<>();
    private final int id;

    public TestStrip(int id) {
        this.id = id;
    }

    public void addDropOnDay(int day, Bottle bottle) {
        /* Add drop from bottle on specific day. */
        sizeDropsForDay(day);
        ArrayList<Bottle> drops = dropsByDay.get(day);
        drops.add(bottle);
    }

    private void sizeDropsForDay(int day) {
        /* Resize list of days/drops to be large enough. */
        while (dropsByDay.size() <= day) {
            dropsByDay.add(new ArrayList<>());
        }
    }

    public int getId() {
        return id;
    }

    public ArrayList<Bottle> getLastWeeksBottles(int day) {
        /* Gets bottles that were used in the test DAYS_FOR_RESULT days ago. */
        if (day < DAYS_FOR_RESULT) {
            return null;
        }
        return dropsByDay.get(day - DAYS_FOR_RESULT);
    }

    public boolean isPositiveOnDay(int day) {
        /* Checks if the test strip has had any poisoned bottles since before DAYS_FOR_RESULT */
        int testDay = day - DAYS_FOR_RESULT;
        if (testDay < 0 || testDay >= dropsByDay.size()) {
            return false;
        }
        for (int d = 0; d <= testDay; d++) {
            ArrayList<Bottle> bottles = dropsByDay.get(d);
            if (hasPoison(bottles)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasPoison(ArrayList<Bottle> bottles) {
        /* Checks if any of the bottles in the set are poisoned. */
        for (Bottle b : bottles) {
            if (b.isPoisoned()) {
                return true;
            }
        }
        return false;
    }
}
