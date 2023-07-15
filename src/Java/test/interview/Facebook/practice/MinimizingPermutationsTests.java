package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.MinimizingPermutations;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MinimizingPermutationsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        MinimizingPermutations.getDescription();
    }

    @Test
    public void minOperations_1() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        int[] values = {3, 1, 2};
        int result = MinimizingPermutations.minOperations(values);
        System.out.format(
                "\tThe list of '%s' can be sorted with %d reverses.\n",
                Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void minOperations_2() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        int[] values = {1, 2, 5, 4, 3};
        int result = MinimizingPermutations.minOperations(values);
        System.out.format(
                "\tThe list of '%s' can be sorted with %d reverses.\n",
                Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void minOperations_3() {
        int expected = 0;
        printTestHeader(name.getMethodName());
        int[] values = {1, 2, 3, 4, 5, 6};
        int result = MinimizingPermutations.minOperations(values);
        System.out.format(
                "\tThe list of '%s' can be sorted with %d reverses.\n",
                Arrays.toString(values), result);
        assertEquals(expected, result);
    }
}
