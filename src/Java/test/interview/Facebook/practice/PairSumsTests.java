package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.PairSums;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PairSumsTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        PairSums.getDescription();
    }

    @Test
    public void numberOfWays_1() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        int sum = 6;
        int[] values = {1, 2, 3, 4, 5};
        int result = PairSums.numberOfWays(values, sum);
        System.out.format(
                "\tThe array %s has %d pairs that sum to %d\n",
                Arrays.toString(values), result, sum);
        assertEquals(expected, result);
    }

    @Test
    public void numberOfWays_2() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        int sum = 6;
        int[] values = {1, 5, 3, 3, 3};
        int result = PairSums.numberOfWays(values, sum);
        System.out.format(
                "\tThe array %s has %d pairs that sum to %d\n",
                Arrays.toString(values), result, sum);
        assertEquals(expected, result);
    }

    @Test
    public void numberOfWays_3() {
        int expected = 0;
        printTestHeader(name.getMethodName());
        int sum = 7;
        int[] values = {1, 5, 3, 3, 3};
        int result = PairSums.numberOfWays(values, sum);
        System.out.format(
                "\tThe array %s has %d pairs that sum to %d\n",
                Arrays.toString(values), result, sum);
        assertEquals(expected, result);
    }
}
