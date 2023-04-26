package Test.Java.unsorted;

import Java.Code.unsorted.classes.classesInstance.Heap;

// import java.util.Scanner;

/**
 * Class BinaryHeapTest
 */
public class HeapTest {
    public static void main(String[] args) {
        // Scanner scan = new Scanner(System.in);
        System.out.println("Heap Test:");
        Heap<Integer> minHeap = new Heap<>();
        minHeap.insert(17);
        System.out.format("\nTop: '%s'", minHeap.peek().toString());
        minHeap.printHeap();
        minHeap.insert(5);
        System.out.format("\nTop: '%s'", minHeap.peek().toString());
        minHeap.printHeap();
        minHeap.insert(3);
        System.out.format("\nTop: '%s'", minHeap.peek().toString());
        minHeap.printHeap();
        minHeap.insert(10);
        System.out.format("\nTop: '%s'", minHeap.peek().toString());
        minHeap.printHeap();
        minHeap.insert(84);
        System.out.format("\nTop: '%s'", minHeap.peek().toString());
        minHeap.printHeap();
        minHeap.insert(19);
        System.out.format("\nTop: '%s'", minHeap.peek().toString());
        minHeap.printHeap();
        minHeap.insert(6);
        System.out.format("\nTop: '%s'", minHeap.peek().toString());
        minHeap.printHeap();
        minHeap.insert(22);
        System.out.format("\nTop: '%s'", minHeap.peek().toString());
        minHeap.printHeap();
        minHeap.insert(9);
        System.out.format("\nTop: '%s'", minHeap.peek().toString());
        minHeap.printHeap();
        minHeap.remove();
        System.out.format("\nTop: '%s'", minHeap.peek().toString());
        minHeap.printHeap();
        minHeap.remove();
        System.out.format("\nTop: '%s'", minHeap.peek().toString());
        minHeap.printHeap();
        minHeap.remove();
        System.out.format("\nTop: '%s'", minHeap.peek().toString());
        minHeap.printHeap();
        minHeap.remove();
        System.out.format("\nTop: '%s'", minHeap.peek().toString());
        minHeap.printHeap();

        Heap<Integer> maxHeap = new Heap<>(false);
        maxHeap.insert(17);
        System.out.format("\nTop: '%s'", maxHeap.peek().toString());
        maxHeap.printHeap();
        maxHeap.insert(5);
        System.out.format("\nTop: '%s'", maxHeap.peek().toString());
        maxHeap.printHeap();
        maxHeap.insert(3);
        System.out.format("\nTop: '%s'", maxHeap.peek().toString());
        maxHeap.printHeap();
        maxHeap.insert(10);
        System.out.format("\nTop: '%s'", maxHeap.peek().toString());
        maxHeap.printHeap();
        maxHeap.insert(84);
        System.out.format("\nTop: '%s'", maxHeap.peek().toString());
        maxHeap.printHeap();
        maxHeap.insert(19);
        System.out.format("\nTop: '%s'", maxHeap.peek().toString());
        maxHeap.printHeap();
        maxHeap.insert(6);
        System.out.format("\nTop: '%s'", maxHeap.peek().toString());
        maxHeap.printHeap();
        maxHeap.insert(22);
        System.out.format("\nTop: '%s'", maxHeap.peek().toString());
        maxHeap.printHeap();
        maxHeap.insert(9);
        System.out.format("\nTop: '%s'", maxHeap.peek().toString());
        maxHeap.printHeap();
        maxHeap.remove();
        System.out.format("\nTop: '%s'", maxHeap.peek().toString());
        maxHeap.printHeap();
        maxHeap.remove();
        System.out.format("\nTop: '%s'", maxHeap.peek().toString());
        maxHeap.printHeap();
        maxHeap.remove();
        System.out.format("\nTop: '%s'", maxHeap.peek().toString());
        maxHeap.printHeap();
        maxHeap.remove();
        System.out.format("\nTop: '%s'", maxHeap.peek().toString());
        maxHeap.printHeap();
    }
}
