package Test.HackerRank.Sorting;

import HackerRank.Sorting.CountingInversions;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountingInversions_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void countInversions_1() {
        long expectedResult = 2;
        int[] expected = {1, 2, 4};
        int[] original = {2, 4, 1};
        int[] values = original.clone();
        System.out.format("%s:\n", name.getMethodName());
        long result = CountingInversions.countInversions(values);
        System.out.format(
                "%s: Sorting the array '%s' results in %d inversions and the sorted array '%s'.\n",
                name.getMethodName(), Arrays.toString(original), result, Arrays.toString(values));
        assertEquals(Arrays.toString(expected), Arrays.toString(values));
        assertEquals(expectedResult, result);
    }

    @Test
    public void countInversions_2() {
        long expectedResult = 0;
        int[] expected = {1, 1, 1, 2, 2};
        int[] original = {1, 1, 1, 2, 2};
        int[] values = original.clone();
        System.out.format("%s:\n", name.getMethodName());
        long result = CountingInversions.countInversions(values);
        System.out.format(
                "%s: Sorting the array '%s' results in %d inversions and the sorted array '%s'.\n",
                name.getMethodName(), Arrays.toString(original), result, Arrays.toString(values));
        assertEquals(Arrays.toString(expected), Arrays.toString(values));
        assertEquals(expectedResult, result);
    }

    @Test
    public void countInversions_3() {
        long expectedResult = 4;
        int[] expected = {1, 1, 2, 2, 3};
        int[] original = {2, 1, 3, 1, 2};
        int[] values = original.clone();
        System.out.format("%s:\n", name.getMethodName());
        long result = CountingInversions.countInversions(values);
        System.out.format(
                "%s: Sorting the array '%s' results in %d inversions and the sorted array '%s'.\n",
                name.getMethodName(), Arrays.toString(original), result, Arrays.toString(values));
        assertEquals(Arrays.toString(expected), Arrays.toString(values));
        assertEquals(expectedResult, result);
    }

    @Test
    public void countInversions_4() {
        long expectedResult = 1;
        int[] expected = {1, 3, 5, 7};
        int[] original = {1, 5, 3, 7};
        int[] values = original.clone();
        System.out.format("%s:\n", name.getMethodName());
        long result = CountingInversions.countInversions(values);
        System.out.format(
                "%s: Sorting the array '%s' results in %d inversions and the sorted array '%s'.\n",
                name.getMethodName(), Arrays.toString(original), result, Arrays.toString(values));
        assertEquals(Arrays.toString(expected), Arrays.toString(values));
        assertEquals(expectedResult, result);
    }

    @Test
    public void countInversions_5() {
        long expectedResult = 6;
        int[] expected = {1, 3, 5, 7};
        int[] original = {7, 5, 3, 1};
        int[] values = original.clone();
        System.out.format("%s:\n", name.getMethodName());
        long result = CountingInversions.countInversions(values);
        System.out.format(
                "%s: Sorting the array '%s' results in %d inversions and the sorted array '%s'.\n",
                name.getMethodName(), Arrays.toString(original), result, Arrays.toString(values));
        assertEquals(Arrays.toString(expected), Arrays.toString(values));
        assertEquals(expectedResult, result);
    }

    @Test
    public void countInversions_7() {
        long expectedResult = 0;
        int[] expected = {1, 3, 5, 7};
        int[] original = {1, 3, 5, 7};
        int[] values = original.clone();
        System.out.format("%s:\n", name.getMethodName());
        long result = CountingInversions.countInversions(values);
        System.out.format(
                "%s: Sorting the array '%s' results in %d inversions and the sorted array '%s'.\n",
                name.getMethodName(), Arrays.toString(original), result, Arrays.toString(values));
        assertEquals(Arrays.toString(expected), Arrays.toString(values));
        assertEquals(expectedResult, result);
    }

    @Test
    public void countInversions_8() {
        long expectedResult = 5;
        int[] expected = {1, 3, 5, 7};
        int[] original = {7, 3, 5, 1};
        int[] values = original.clone();
        System.out.format("%s:\n", name.getMethodName());
        long result = CountingInversions.countInversions(values);
        System.out.format(
                "%s: Sorting the array '%s' results in %d inversions and the sorted array '%s'.\n",
                name.getMethodName(), Arrays.toString(original), result, Arrays.toString(values));
        assertEquals(Arrays.toString(expected), Arrays.toString(values));
        assertEquals(expectedResult, result);
    }

    @Test
    public void countInversions_9() {
        long expectedResult = 3;
        int[] expected = {1, 2, 3};
        int[] original = {3, 2, 1};
        int[] values = original.clone();
        System.out.format("%s:\n", name.getMethodName());
        long result = CountingInversions.countInversions(values);
        System.out.format(
                "%s: Sorting the array '%s' results in %d inversions and the sorted array '%s'.\n",
                name.getMethodName(), Arrays.toString(original), result, Arrays.toString(values));
        assertEquals(Arrays.toString(expected), Arrays.toString(values));
        assertEquals(expectedResult, result);
    }
}
