package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.EditDistance;
import Java.code.interview.Facebook.practice.ElementSwapping;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertArrayEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ElementSwappingTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void findMinArray_1() {
        int[] expected = {1, 5, 3};
        printTestHeader(name.getMethodName());
        int k = 2;
        int[] values = {5, 3, 1};
        int[] result = ElementSwapping.findMinArray(values, k);
        System.out.format(
                "\tThe smallest possible lexical sort of '%s' with %d swaps is '%s'.\n",
                Arrays.toString(values), k, Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void findMinArray_2() {
        int[] expected = {2, 8, 9, 11, 1};
        printTestHeader(name.getMethodName());
        int k = 3;
        int[] values = {8, 9, 11, 2, 1};
        int[] result = ElementSwapping.findMinArray(values, k);
        System.out.format(
                "\tThe smallest possible lexical sort of '%s' with %d swaps is '%s'.\n",
                Arrays.toString(values), k, Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        EditDistance.getDescription();
    }
}
