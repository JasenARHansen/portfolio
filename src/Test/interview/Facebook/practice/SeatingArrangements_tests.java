package Test.interview.Facebook.practice;

import Code.interview.Facebook.practice.SeatingArrangements;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeatingArrangements_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void minOverallAwkwardness_1() {
        int expected = 4;
        int[] values = {5, 10, 6, 8};
        int result = SeatingArrangements.minOverallAwkwardness(values);
        System.out.format(
                "%s: The smallest possible awkwardness of a table seating people with heights '%s' is %d.\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void minOverallAwkwardness_2() {
        int expected = 4;
        int[] values = {1, 2, 5, 3, 7};
        int result = SeatingArrangements.minOverallAwkwardness(values);
        System.out.format(
                "%s: The smallest possible awkwardness of a table seating people with heights '%s' is %d.\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void minOverallAwkwardness_3() {
        int expected = 2;
        int[] values = {1, 2, 5, 3, 7, 1, 2, 3, 4, 5, 6};
        int result = SeatingArrangements.minOverallAwkwardness(values);
        System.out.format(
                "%s: The smallest possible awkwardness of a table seating people with heights '%s' is %d.\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void minOverallAwkwardness_brute_1() {
        int expected = 4;
        int[] values = {5, 10, 6, 8};
        int result = SeatingArrangements.minOverallAwkwardness_brute(values);
        System.out.format(
                "%s: The smallest possible awkwardness of a table seating people with heights '%s' is %d.\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void minOverallAwkwardness_brute_2() {
        int expected = 4;
        int[] values = {1, 2, 5, 3, 7};
        int result = SeatingArrangements.minOverallAwkwardness_brute(values);
        System.out.format(
                "%s: The smallest possible awkwardness of a table seating people with heights '%s' is %d.\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void minOverallAwkwardness_brute_3() {
        int expected = 2;
        int[] values = {1, 2, 5, 3, 7, 1, 2, 3, 4, 5, 6};
        int result = SeatingArrangements.minOverallAwkwardness_brute(values);
        System.out.format(
                "%s: The smallest possible awkwardness of a table seating people with heights '%s' is %d.\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }
}
