package Test.HackerRank.Sorting;

import HackerRank.Sorting.BubbleSort;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BubbleSort_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void countSwaps_1() {
        int[] expected = {1, 4, 6};
        int[] original = {6, 4, 1};
        int[] values = original.clone();
        System.out.format("%s:\n", name.getMethodName());
        BubbleSort.countSwaps(values);
        System.out.format(
                "%s:Sorting the array '%s' results in the sorted array '%s'.\n",
                name.getMethodName(), Arrays.toString(original), Arrays.toString(values));
        assertEquals(Arrays.toString(expected), Arrays.toString(values));
    }

    @Test
    public void countSwaps_2() {
        int[] expected = {1, 2, 3};
        int[] original = {1, 2, 3};
        int[] values = original.clone();
        System.out.format("%s:\n", name.getMethodName());
        BubbleSort.countSwaps(values);
        System.out.format(
                "%s:Sorting the array '%s' results in the sorted array '%s'.\n",
                name.getMethodName(), Arrays.toString(original), Arrays.toString(values));
        assertEquals(Arrays.toString(expected), Arrays.toString(values));
    }

    @Test
    public void countSwaps_3() {
        int[] expected = {1, 2, 3};
        int[] original = {3, 1, 2};
        int[] values = original.clone();
        System.out.format("%s:\n", name.getMethodName());
        BubbleSort.countSwaps(values);
        System.out.format(
                "%s:Sorting the array '%s' results in the sorted array '%s'.\n",
                name.getMethodName(), Arrays.toString(original), Arrays.toString(values));
        assertEquals(Arrays.toString(expected), Arrays.toString(values));
    }

    @Test
    public void countSwaps_4() {
        int[] expected = {1, 2, 3, 4};
        int[] original = {4, 2, 3, 1};
        int[] values = original.clone();
        System.out.format("%s:\n", name.getMethodName());
        BubbleSort.countSwaps(values);
        System.out.format(
                "%s:Sorting the array '%s' results in the sorted array '%s'.\n",
                name.getMethodName(), Arrays.toString(original), Arrays.toString(values));
        assertEquals(Arrays.toString(expected), Arrays.toString(values));
    }
}
