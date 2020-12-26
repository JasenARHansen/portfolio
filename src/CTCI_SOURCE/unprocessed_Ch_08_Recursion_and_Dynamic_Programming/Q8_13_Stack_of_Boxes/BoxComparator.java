package CTCI_SOURCE.unprocessed_Ch_08_Recursion_and_Dynamic_Programming.Q8_13_Stack_of_Boxes;

import java.util.Comparator;

public class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box x, Box y) {
        return y.height - x.height;
    }
}
