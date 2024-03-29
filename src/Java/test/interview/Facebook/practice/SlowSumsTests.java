package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.SlowSums;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SlowSumsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getTotalTime_1() {
        int expected = 26;
        printTestHeader(name.getMethodName());
        int[] values = {4, 2, 1, 3};
        int result = SlowSums.getTotalTime(values);
        System.out.format(
                "\tThe worst possible penalty of adding the values '%s' is %d.\n",
                Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void getTotalTime_2() {
        int expected = 88;
        printTestHeader(name.getMethodName());
        int[] values = {2, 3, 9, 8, 4};
        int result = SlowSums.getTotalTime(values);
        System.out.format(
                "\tThe worst possible penalty of adding the values '%s' is %d.\n",
                Arrays.toString(values), result);
        assertEquals(expected, result);
    }
}
