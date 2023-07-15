package Java.test.unsorted;

import Java.code.unsorted.classes.classesInstance.Heap;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HeapTest {
    @Rule
    public TestName name = new TestName();

    @Test
    public void maxHeap() {
        int expected = 17;
        printTestHeader(name.getMethodName());
        List<Integer> insert = Arrays.asList(17, 9, 22, 9, 5, 67);
        Heap<Integer> maxHeap = new Heap<>(false);
        for (int number : insert) {
            maxHeap.insert(number);
        }
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result = maxHeap.remove();
        }
        assertEquals(expected, result);
        System.out.format("\tHeap:  %s\n", maxHeap.getHeap());
    }

    @Test
    public void minHeap() {
        int expected = 9;
        printTestHeader(name.getMethodName());
        List<Integer> insert = Arrays.asList(17, 9, 22, 9, 5, 67);
        Heap<Integer> minHeap = new Heap<>();
        for (Integer number : insert) {
            minHeap.insert(number);
        }
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result = minHeap.remove();
        }
        assertEquals(expected, result);
        System.out.format("\tHeap: %s\n", minHeap.getHeap());
    }
}
