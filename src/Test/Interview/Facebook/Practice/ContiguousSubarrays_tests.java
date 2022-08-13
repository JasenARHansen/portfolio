package Test.Interview.Facebook.Practice;

import Code.Interview.Facebook.Practice.ContiguousSubarrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContiguousSubarrays_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void countSubarrays_1() {
        int[] expected = {1, 3, 1, 5, 1};
        int[] values = {3, 4, 1, 6, 2};
        int[] result = ContiguousSubarrays.countSubarrays(values);
        System.out.format(
                "%s: The array '%s' has the following number of subarrays '%s'\n",
                name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    @Test
    public void countSubarrays_2() {
        int[] expected = {1, 2, 6, 1, 3, 1};
        int[] values = {2, 4, 7, 1, 5, 3};
        int[] result = ContiguousSubarrays.countSubarrays(values);
        System.out.format(
                "%s: The array '%s' has the following number of subarrays '%s'\n",
                name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }
}
