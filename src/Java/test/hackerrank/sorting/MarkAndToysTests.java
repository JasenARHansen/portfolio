package Java.test.hackerrank.sorting;

import Java.code.hackerrank.sorting.MarkAndToys;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MarkAndToysTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void maximumToys_1() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        int[] values = {1, 2, 3, 4};
        int k = 7;
        int result = MarkAndToys.maximumToys(values, k);
        System.out.format(
                "\tWith a budget of %d units of currency and a set of prices being '%s', you are able to purchase %d toys.\n",
                k, Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void maximumToys_2() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        int[] values = {1, 12, 5, 111, 200, 1000, 10};
        int k = 50;
        int result = MarkAndToys.maximumToys(values, k);
        System.out.format(
                "\tWith a budget of %d units of currency and a set of prices being '%s', you are able to purchase %d toys.\n",
                k, Arrays.toString(values), result);
        assertEquals(expected, result);
    }

    @Test
    public void maximumToys_3() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        int[] values = {3, 7, 2, 9, 4};
        int k = 15;
        int result = MarkAndToys.maximumToys(values, k);
        System.out.format(
                "\tWith a budget of %d units of currency and a set of prices being '%s', you are able to purchase %d toys.\n",
                k, Arrays.toString(values), result);
        assertEquals(expected, result);
    }
}
