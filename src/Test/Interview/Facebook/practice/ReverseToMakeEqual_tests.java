package Test.Interview.Facebook.practice;

import Code.Interview.Facebook.practice.ReverseToMakeEqual;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReverseToMakeEqual_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void areTheyEqual_1() {
        int[] array_a = {1, 2, 3, 4};
        int[] array_b = {1, 4, 3, 2};
        boolean result = ReverseToMakeEqual.areTheyEqual(array_a, array_b);
        System.out.format(
                "%s: The array '%s' can be made equal to '%s': %b\n",
                name.getMethodName(), Arrays.toString(array_a), Arrays.toString(array_b), result);
        assertTrue(result);
    }

    @Test
    public void areTheyEqual_2() {
        int[] array_a = {1, 2, 3, 4};
        int[] array_b = {1, 4, 3, 3};
        boolean result = ReverseToMakeEqual.areTheyEqual(array_a, array_b);
        System.out.format(
                "%s: The array '%s' can be made equal to '%s': %b\n",
                name.getMethodName(), Arrays.toString(array_a), Arrays.toString(array_b), result);
        assertFalse(result);
    }

    @Test
    public void areTheyEqual_3() {
        int[] array_a = {1, 2, 3, 4};
        int[] array_b = {1, 3, 2, 4};
        boolean result = ReverseToMakeEqual.areTheyEqual(array_a, array_b);
        System.out.format(
                "%s: The array '%s' can be made equal to '%s': %b\n",
                name.getMethodName(), Arrays.toString(array_a), Arrays.toString(array_b), result);
        assertTrue(result);
    }

    @Test
    public void areTheyEqual_4() {
        int[] array_a = {1, 2, 3, 4, 5, 6};
        int[] array_b = {2, 1, 4, 3, 6, 5};
        boolean result = ReverseToMakeEqual.areTheyEqual(array_a, array_b);
        System.out.format(
                "%s: The array '%s' can be made equal to '%s': %b\n",
                name.getMethodName(), Arrays.toString(array_a), Arrays.toString(array_b), result);
        assertTrue(result);
    }

    @Test
    public void areTheyEqual_5() {
        int[] array_a = {1, 2, 3, 4, 5, 6};
        int[] array_b = {2, 1, 6, 3, 4, 5};
        boolean result = ReverseToMakeEqual.areTheyEqual(array_a, array_b);
        System.out.format(
                "%s: The array '%s' can be made equal to '%s': %b\n",
                name.getMethodName(), Arrays.toString(array_a), Arrays.toString(array_b), result);
        assertTrue(result);
    }

    @Test
    public void areTheyEqual_6() {
        int[] array_a = {1, 2, 3, 4, 5, 6};
        int[] array_b = {2, 4, 6, 3, 1, 5};
        boolean result = ReverseToMakeEqual.areTheyEqual(array_a, array_b);
        System.out.format(
                "%s: The array '%s' can be made equal to '%s': %b\n",
                name.getMethodName(), Arrays.toString(array_a), Arrays.toString(array_b), result);
        assertFalse(result);
    }
}
