package Java.test.hackerrank.sorting;

import Java.code.hackerrank.sorting.CountingInversions;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountingInversionsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void countInversions_1() {
        long expected = 2;
        printTestHeader(name.getMethodName());
        int[] sorted = {1, 2, 4};
        int[] original = {2, 4, 1};
        int[] values = original.clone();
        long result = CountingInversions.countInversions(values);
        System.out.format(
                "\tSorting the array '%s' results in %d inversions and the sorted array '%s'.\n",
                Arrays.toString(original), result, Arrays.toString(values));
        assertEquals(Arrays.toString(sorted), Arrays.toString(values));
        assertEquals(expected, result);
    }

    @Test
    public void countInversions_2() {
        long expected = 0;
        printTestHeader(name.getMethodName());
        int[] original = {1, 1, 1, 2, 2};
        int[] values = original.clone();
        printTestHeader(name.getMethodName());
        long result = CountingInversions.countInversions(values);
        System.out.format(
                "\tSorting the array '%s' results in %d inversions and the sorted array '%s'.\n",
                Arrays.toString(original), result, Arrays.toString(values));
        assertEquals(Arrays.toString(original), Arrays.toString(values));
        assertEquals(expected, result);
    }

    @Test
    public void countInversions_3() {
        long expected = 4;
        printTestHeader(name.getMethodName());
        int[] sorted = {1, 1, 2, 2, 3};
        int[] original = {2, 1, 3, 1, 2};
        int[] values = original.clone();
        printTestHeader(name.getMethodName());
        long result = CountingInversions.countInversions(values);
        System.out.format(
                "\tSorting the array '%s' results in %d inversions and the sorted array '%s'.\n",
                Arrays.toString(original), result, Arrays.toString(values));
        assertEquals(Arrays.toString(sorted), Arrays.toString(values));
        assertEquals(expected, result);
    }

    @Test
    public void countInversions_4() {
        long expected = 1;
        printTestHeader(name.getMethodName());
        int[] sorted = {1, 3, 5, 7};
        int[] original = {1, 5, 3, 7};
        int[] values = original.clone();
        printTestHeader(name.getMethodName());
        long result = CountingInversions.countInversions(values);
        System.out.format(
                "\tSorting the array '%s' results in %d inversions and the sorted array '%s'.\n",
                Arrays.toString(original), result, Arrays.toString(values));
        assertEquals(Arrays.toString(sorted), Arrays.toString(values));
        assertEquals(expected, result);
    }

    @Test
    public void countInversions_5() {
        long expected = 6;
        printTestHeader(name.getMethodName());
        int[] sorted = {1, 3, 5, 7};
        int[] original = {7, 5, 3, 1};
        int[] values = original.clone();
        printTestHeader(name.getMethodName());
        long result = CountingInversions.countInversions(values);
        System.out.format(
                "\tSorting the array '%s' results in %d inversions and the sorted array '%s'.\n",
                Arrays.toString(original), result, Arrays.toString(values));
        assertEquals(Arrays.toString(sorted), Arrays.toString(values));
        assertEquals(expected, result);
    }

    @Test
    public void countInversions_7() {
        long expected = 0;
        printTestHeader(name.getMethodName());
        int[] sorted = {1, 3, 5, 7};
        int[] original = {1, 3, 5, 7};
        int[] values = original.clone();
        printTestHeader(name.getMethodName());
        long result = CountingInversions.countInversions(values);
        System.out.format(
                "\tSorting the array '%s' results in %d inversions and the sorted array '%s'.\n",
                Arrays.toString(original), result, Arrays.toString(values));
        assertEquals(Arrays.toString(sorted), Arrays.toString(values));
        assertEquals(expected, result);
    }

    @Test
    public void countInversions_8() {
        printTestHeader(name.getMethodName());
        long expected = 5;
        int[] sorted = {1, 3, 5, 7};
        int[] original = {7, 3, 5, 1};
        int[] values = original.clone();
        printTestHeader(name.getMethodName());
        long result = CountingInversions.countInversions(values);
        System.out.format(
                "\tSorting the array '%s' results in %d inversions and the sorted array '%s'.\n",
                Arrays.toString(original), result, Arrays.toString(values));
        assertEquals(Arrays.toString(sorted), Arrays.toString(values));
        assertEquals(expected, result);
    }

    @Test
    public void countInversions_9() {
        long expected = 3;
        printTestHeader(name.getMethodName());
        int[] sorted = {1, 2, 3};
        int[] original = {3, 2, 1};
        int[] values = original.clone();
        printTestHeader(name.getMethodName());
        long result = CountingInversions.countInversions(values);
        System.out.format(
                "\tSorting the array '%s' results in %d inversions and the sorted array '%s'.\n",
                Arrays.toString(original), result, Arrays.toString(values));
        assertEquals(Arrays.toString(sorted), Arrays.toString(values));
        assertEquals(expected, result);
    }
}
