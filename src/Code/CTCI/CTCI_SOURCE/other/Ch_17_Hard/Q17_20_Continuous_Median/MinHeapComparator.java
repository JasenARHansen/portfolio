package Code.CTCI.CTCI_SOURCE.other.Ch_17_Hard.Q17_20_Continuous_Median;

import java.util.Comparator;

public class MinHeapComparator implements Comparator<Integer> {
    // Comparator that sorts integers from lowest to highest
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}
