package classes.classesInstance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Median<T extends Comparable<T>> {

    private final Heap<T> larger;
    private final Heap<T> smaller;
    private final List<T> median;

    public Median() {
        // Min heap for larger numbers
        larger = new Heap<>(false);
        // Max heap for smaller numbers
        smaller = new Heap<>(true);
        median = new ArrayList<>();
    }

    public void insert(T input) {
        smaller.insert(input);
        balance();
    }

    private void balance() {
        // Balance heaps
        while (larger.getSize() > smaller.getSize()) {
            median.add(larger.remove());
        }

        // Sanity check, should never actually execute
        while (smaller.getSize() > larger.getSize()) {
            median.add(smaller.remove());
        }

        Collections.sort(median);
        while (median.size() > 2) {
            smaller.insert(median.remove(median.size() - 1));
            larger.insert(median.remove(0));
        }
    }

    public void getMedian() {
        if (median.isEmpty()) {
            System.out.format("\nMedian values: NA");
        } else if (median.size() == 2) {
            System.out.format(
                    "\nMedian values: '%s' and '%s'", median.get(0).toString(), median.get(1).toString());
        } else {
            System.out.format("\nMedian value: '%s'", median.get(0).toString());
        }
    }

    public void printMedian() {
        smaller.printHeap();
        larger.printHeap();
        //	System.out.format("\n%s: '%s'", getHeapType(), this.heapItems.toString());
    }
}
