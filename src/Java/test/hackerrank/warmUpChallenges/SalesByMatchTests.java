package Java.test.hackerrank.warmUpChallenges;

import Java.code.hackerrank.warmUpChallenges.SalesByMatch;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SalesByMatchTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void numberOfPairsMap_1() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        int[] values = {1, 2, 1, 2, 1, 3, 2};
        int result = SalesByMatch.numberOfPairsMap(values);
        System.out.format("\tThe list of colors '%s' has %d pairs.\n", Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void numberOfPairsMap_2() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        int[] values = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int result = SalesByMatch.numberOfPairsMap(values);
        System.out.format("\tThe list of colors '%s' has %d pairs.\n", Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void numberOfPairsSet_1() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        int[] values = {1, 2, 1, 2, 1, 3, 2};
        int result = SalesByMatch.numberOfPairsSet(values);
        System.out.format("\tThe list of colors '%s' has %d pairs.\n", Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void numberOfPairsSet_2() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        int[] values = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int result = SalesByMatch.numberOfPairsSet(values);
        System.out.format("\tThe list of colors '%s' has %d pairs.\n", Arrays.toString(values), result);
        assertEquals(expected, result);
    }
}
