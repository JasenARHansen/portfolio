package Test.Java.educative;

import Java.Code.Educative.DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void longest_increasing_subsequence_1() {
        int expected = 3;
        int[] values = {3, 10, 2, 1, 20};
        int result =
                DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers
                        .longest_increasing_subsequence_recursion(values);

        System.out.format(
                "%s: The longest increasing subsequence of '%s' is %d.\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void longest_increasing_subsequence_2() {
        int expected = 1;
        int[] values = {3, 2};
        int result =
                DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers
                        .longest_increasing_subsequence_recursion(values);

        System.out.format(
                "%s: The longest increasing subsequence of '%s' is %d.\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void longest_increasing_subsequence_3() {
        int expected = 4;
        int[] values = {50, 3, 10, 7, 40, 80};
        int result =
                DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers
                        .longest_increasing_subsequence_recursion(values);

        System.out.format(
                "%s: The longest increasing subsequence of '%s' is %d.\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void longest_increasing_subsequence_4() {
        int expected = 3;
        int[] values = {3, 10, 2, 1, 20};
        int result =
                DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers
                        .longest_increasing_subsequence_dynamic(values);

        System.out.format(
                "%s: The longest increasing subsequence of '%s' is %d.\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void longest_increasing_subsequence_5() {
        int expected = 1;
        int[] values = {3, 2};
        int result =
                DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers
                        .longest_increasing_subsequence_dynamic(values);

        System.out.format(
                "%s: The longest increasing subsequence of '%s' is %d.\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void longest_increasing_subsequence_6() {
        int expected = 4;
        int[] values = {50, 3, 10, 7, 40, 80};
        int result =
                DynamicProgrammingLongestIncreasingSubsequenceFromArrayOfIntegers
                        .longest_increasing_subsequence_dynamic(values);

        System.out.format(
                "%s: The longest increasing subsequence of '%s' is %d.\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }
}
