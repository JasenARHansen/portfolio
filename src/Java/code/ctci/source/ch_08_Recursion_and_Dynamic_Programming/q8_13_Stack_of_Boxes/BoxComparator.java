package Java.code.ctci.source.ch_08_Recursion_and_Dynamic_Programming.q8_13_Stack_of_Boxes;

import java.util.Comparator;

public class BoxComparator implements Comparator<Box> {

    @Override
    public int compare(Box x, Box y) {
        return y.height - x.height;
    }
}
