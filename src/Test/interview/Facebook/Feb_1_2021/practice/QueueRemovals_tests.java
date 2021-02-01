package Test.interview.Facebook.Feb_1_2021.practice;

import interview.Facebook.Feb_1_2021.practice.QueueRemovals;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QueueRemovals_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void findPositions_1() {
        int[] expected = {5, 6, 4, 1, 2};
        int x = 5;
        int[] array = {1, 2, 2, 3, 4, 5};

        int[] result = QueueRemovals.findPositions(array, x);
        System.out.format(
                "%s: The array '%s' with %d iterations becomes '%s'\n",
                name.getMethodName(), Arrays.toString(array), x, Arrays.toString(result));
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    @Test
    public void findPositions_2() {
        int[] expected = {2, 5, 10, 13};
        int x = 4;
        int[] array = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};

        int[] result = QueueRemovals.findPositions(array, x);
        System.out.format(
                "%s: The array '%s' with %d iterations becomes '%s'\n",
                name.getMethodName(), Arrays.toString(array), x, Arrays.toString(result));
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }
}
