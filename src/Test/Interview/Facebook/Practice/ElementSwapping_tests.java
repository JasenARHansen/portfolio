package Test.Interview.Facebook.Practice;

import Code.Interview.Facebook.Practice.ElementSwapping;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ElementSwapping_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void findMinArray_1() {
        int[] expected = {1, 5, 3};
        int k = 2;
        int[] values = {5, 3, 1};
        int[] result = ElementSwapping.findMinArray(values, k);
        System.out.format(
                "%s: The smallest possible lexical sort of '%s' with %d swaps is '%s'.\n",
                name.getMethodName(), Arrays.toString(values), k, Arrays.toString(result));
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    @Test
    public void findMinArray_2() {
        int[] expected = {2, 8, 9, 11, 1};
        int k = 3;
        int[] values = {8, 9, 11, 2, 1};
        int[] result = ElementSwapping.findMinArray(values, k);
        System.out.format(
                "%s: The smallest possible lexical sort of '%s' with %d swaps is '%s'.\n",
                name.getMethodName(), Arrays.toString(values), k, Arrays.toString(result));
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }
}
