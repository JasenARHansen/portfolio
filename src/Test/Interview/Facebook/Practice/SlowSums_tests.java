package Test.Interview.Facebook.Practice;

import Code.Interview.Facebook.Practice.SlowSums;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SlowSums_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void getTotalTime_1() {
        int expected = 26;
        int[] values = {4, 2, 1, 3};
        int result = SlowSums.getTotalTime(values);
        System.out.format(
                "%s: The worst possible penalty of adding the values '%s' is %d.\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void getTotalTime_2() {
        int expected = 88;
        int[] values = {2, 3, 9, 8, 4};
        int result = SlowSums.getTotalTime(values);
        System.out.format(
                "%s: The worst possible penalty of adding the values '%s' is %d.\n",
                name.getMethodName(), Arrays.toString(values), result);
        assertEquals(expected, result);
    }
}
