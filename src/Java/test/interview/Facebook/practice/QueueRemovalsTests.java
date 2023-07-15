package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.QueueRemovals;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertArrayEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QueueRemovalsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void findPositions_1() {
        int[] expected = {5, 6, 4, 1, 2};
        printTestHeader(name.getMethodName());
        int x = 5;
        int[] array = {1, 2, 2, 3, 4, 5};
        int[] result = QueueRemovals.findPositions(array, x);
        System.out.format(
                "\tThe array '%s' with %d iterations becomes '%s'\n",
                Arrays.toString(array), x, Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void findPositions_2() {
        int[] expected = {2, 5, 10, 13};
        printTestHeader(name.getMethodName());
        int x = 4;
        int[] array = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
        int[] result = QueueRemovals.findPositions(array, x);
        System.out.format(
                "\tThe array '%s' with %d iterations becomes '%s'\n",
                Arrays.toString(array), x, Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        QueueRemovals.getDescription();
    }
}
