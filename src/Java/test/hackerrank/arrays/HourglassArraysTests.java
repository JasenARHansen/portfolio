package Java.test.hackerrank.arrays;

import Java.code.hackerrank.arrays.HourglassArray;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HourglassArraysTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void hourglassSum_1() {
        int expected = 7;
        printTestHeader(name.getMethodName());
        int[][] values = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        int result = HourglassArray.hourglassSum(values);
        System.out.format(
                "\tThe largest hourglass sub-array has a value of %d.\n", result);
        assertEquals(expected, result);
    }

    @Test
    public void hourglassSum_2() {
        int expected = 28;
        printTestHeader(name.getMethodName());
        int[][] values = {
                {-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        int result = HourglassArray.hourglassSum(values);
        System.out.format(
                "\tThe largest hourglass sub-array has a value of %d.\n", result);
        assertEquals(expected, result);
    }

    @Test
    public void hourglassSum_3() {
        int expected = 19;
        printTestHeader(name.getMethodName());
        int[][] values = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        int result = HourglassArray.hourglassSum(values);
        System.out.format(
                "\tThe largest hourglass sub-array has a value of %d.\n", result);
        assertEquals(expected, result);
    }

    @Test
    public void hourglassSum_4() {
        int expected = 13;
        printTestHeader(name.getMethodName());
        int[][] values = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 9, 2, -4, -4, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, -1, -2, -4, 0}
        };
        int result = HourglassArray.hourglassSum(values);
        System.out.format(
                "\tThe largest hourglass sub-array has a value of %d.\n", result);
        assertEquals(expected, result);
    }
}
