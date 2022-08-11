package Test.Interview.Facebook.practice;

import Code.Interview.Facebook.practice.BalancedSplit;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BalanceSplit_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void balancedSplitExists_1() {
        int[] values = {1, 5, 7, 1};
        boolean result = BalancedSplit.balancedSplitExists(values);
        System.out.format(
                "%s: A balanced split for '%s' exists: %b\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertTrue(result);
    }

    @Test
    public void balancedSplitExists_2() {
        int[] values = {12, 7, 6, 7, 6};
        boolean result = BalancedSplit.balancedSplitExists(values);
        System.out.format(
                "%s: A balanced split for '%s' exists: %b\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertFalse(result);
    }

    @Test
    public void balancedSplitExists_3() {
        int[] values = {2, 1, 2, 5};
        boolean result = BalancedSplit.balancedSplitExists(values);
        System.out.format(
                "%s: A balanced split for '%s' exists: %b\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertTrue(result);
    }

    @Test
    public void balancedSplitExists_4() {
        int[] values = {3, 6, 3, 4, 4};
        boolean result = BalancedSplit.balancedSplitExists(values);
        System.out.format(
                "%s: A balanced split for '%s' exists: %b\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertFalse(result);
    }

    @Test
    public void balancedSplitExists_5() {
        int[] values = {9, 6, 6, 9, 6};
        boolean result = BalancedSplit.balancedSplitExists(values);
        System.out.format(
                "%s: A balanced split for '%s' exists: %b\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertTrue(result);
    }
}
