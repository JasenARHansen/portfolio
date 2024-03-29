package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.SumToZero;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("DuplicatedCode")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SumToZeroTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void sumTo_1() {
        printTestHeader(name.getMethodName());
        int numbers = 3;
        int sum = 0;
        int[] values = {3, 5, 8, 10, -9, -11, 16, 2};
        boolean result = SumToZero.sumTo(numbers, sum, values);
        System.out.format(
                "\tThe array '%s' has %d values that sum to %d: %b\n",
                Arrays.toString(values), numbers, sum, result);
        assertTrue(result);
    }

    @Test
    public void sumTo_2() {
        printTestHeader(name.getMethodName());
        int numbers = 7;
        int sum = 2;
        int[] values = {1, 1, 1, 1, 1, 1, -4, -2, 1, 1, -4, 10};
        boolean result = SumToZero.sumTo(numbers, sum, values);
        System.out.format(
                "\tThe array '%s' has %d values that sum to %d: %b\n",
                Arrays.toString(values), numbers, sum, result);
        assertTrue(result);
    }

    @Test
    public void sumTo_3() {
        printTestHeader(name.getMethodName());
        int numbers = 7;
        int sum = 2;
        int[] values = {1, 1, 1, 1, 1, -4};
        boolean result = SumToZero.sumTo(numbers, sum, values);
        System.out.format(
                "\tThe array '%s' has %d values that sum to %d: %b\n",
                Arrays.toString(values), numbers, sum, result);
        assertFalse(result);
    }

    @Test
    public void sumTo_4() {
        printTestHeader(name.getMethodName());
        int numbers = 1;
        int sum = -4;
        int[] values = {1, 1, 1, 1, 1, 1, -4, -2, 1, 1, -4, 10};
        boolean result = SumToZero.sumTo(numbers, sum, values);
        System.out.format(
                "\tThe array '%s' has %d values that sum to %d: %b\n",
                Arrays.toString(values), numbers, sum, result);
        assertTrue(result);
    }

    @Test
    public void sumTo_5() {
        printTestHeader(name.getMethodName());
        int numbers = 2;
        int sum = -1;
        int[] values = {1, 1, 1, 1, 1, 1, -4, -2, 1, 1, -4, 10};
        boolean result = SumToZero.sumTo(numbers, sum, values);
        System.out.format(
                "\tThe array '%s' has %d values that sum to %d: %b\n",
                Arrays.toString(values), numbers, sum, result);
        assertTrue(result);
    }

    @Test
    public void threeSumToZero_1() {
        printTestHeader(name.getMethodName());
        int[] values = {3, 5, 8, 10, -9, -11, 16, 2};
        boolean result = SumToZero.threeSumToZero(values);
        System.out.format(
                "\tThe array '%s' has 3 values that sum to zero: %b\n", Arrays.toString(values), result);
        assertTrue(result);
    }

    @Test
    public void threeSumToZero_2() {
        printTestHeader(name.getMethodName());
        int[] values = {3, 5, 4, 9, -16, -10};
        boolean result = SumToZero.threeSumToZero(values);
        System.out.format(
                "\tThe array '%s' has 3 values that sum to zero: %b\n", Arrays.toString(values), result);
        assertFalse(result);
    }

    @Test
    public void threeSumToZero_3() {
        printTestHeader(name.getMethodName());
        int[] values = {3, 5};
        boolean result = SumToZero.threeSumToZero(values);
        System.out.format(
                "\tThe array '%s' has 3 values that sum to zero: %b\n", Arrays.toString(values), result);
        assertFalse(result);
    }

    @Test
    public void threeSumToZero_4() {
        printTestHeader(name.getMethodName());
        int[] values = {-2, 3, 5, 8, 4, 10, -9, -10, -2, 16, 2};
        boolean result = SumToZero.threeSumToZero(values);
        System.out.format(
                "\tThe array '%s' has 3 values that sum to zero: %b\n", Arrays.toString(values), result);
        assertTrue(result);
    }

    @Test
    public void threeSumToZero_5() {
        printTestHeader(name.getMethodName());
        int[] values = {3, 5, 8, 4, -2, 16, 2};
        boolean result = SumToZero.threeSumToZero(values);
        System.out.format(
                "\tThe array '%s' has 3 values that sum to zero: %b\n", Arrays.toString(values), result);
        assertFalse(result);
    }
}
