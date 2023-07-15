package Java.test.educative;

import Java.code.educative.DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegersTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers.getDescription();
    }

    @Test
    public void longest_increasing_subsequence_1() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        int[] values = {3, 10, 2, 1, 20};
        int result =
                DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers
                        .longest_increasing_subsequence_recursion(values);
        System.out.format(
                "\tThe longest increasing subsequence of '%s' is %d.\n", Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void longest_increasing_subsequence_2() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        int[] values = {3, 2};
        int result =
                DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers
                        .longest_increasing_subsequence_recursion(values);
        System.out.format(
                "\tThe longest increasing subsequence of '%s' is %d.\n", Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void longest_increasing_subsequence_3() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        int[] values = {50, 3, 10, 7, 40, 80};
        int result =
                DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers
                        .longest_increasing_subsequence_recursion(values);
        System.out.format(
                "\tThe longest increasing subsequence of '%s' is %d.\n", Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void longest_increasing_subsequence_4() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        int[] values = {3, 10, 2, 1, 20};
        int result =
                DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers
                        .longest_increasing_subsequence_dynamic(values);
        System.out.format(
                "\tThe longest increasing subsequence of '%s' is %d.\n", Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void longest_increasing_subsequence_5() {
        int expected = 1;
        printTestHeader(name.getMethodName());
        int[] values = {3, 2};
        int result =
                DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers
                        .longest_increasing_subsequence_dynamic(values);
        System.out.format(
                "\tThe longest increasing subsequence of '%s' is %d.\n", Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void longest_increasing_subsequence_6() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        int[] values = {50, 3, 10, 7, 40, 80};
        int result =
                DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers
                        .longest_increasing_subsequence_dynamic(values);
        System.out.format(
                "\tThe longest increasing subsequence of '%s' is %d.\n", Arrays.toString(values), result);
        assertEquals(expected, result);
    }
}
