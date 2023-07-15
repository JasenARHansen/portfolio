package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.ContiguousSubArrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertArrayEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContiguousSubArraysTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void countSubArrays_1() {
        int[] expected = {1, 3, 1, 5, 1};
        printTestHeader(name.getMethodName());
        int[] values = {3, 4, 1, 6, 2};
        int[] result = ContiguousSubArrays.countSubArrays(values);
        System.out.format(
                "\tThe array '%s' has the following number of sub-arrays '%s'\n",
                Arrays.toString(values), Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void countSubArrays_2() {
        int[] expected = {1, 2, 6, 1, 3, 1};
        printTestHeader(name.getMethodName());
        int[] values = {2, 4, 7, 1, 5, 3};
        int[] result = ContiguousSubArrays.countSubArrays(values);
        System.out.format(
                "\tThe array '%s' has the following number of sub-arrays '%s'\n",
                Arrays.toString(values), Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        ContiguousSubArrays.getDescription();
    }
}
