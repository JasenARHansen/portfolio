package Java.test.educative;

import Java.code.educative.StackLargestRectangleInHistogram;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StackLargestRectangleInHistogramTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void largestRectangleArea_1() {
        int expected = 10;
        printTestHeader(name.getMethodName());
        int[] source = {2, 1, 5, 6, 2, 3};
        int result = StackLargestRectangleInHistogram.largestRectangleArea(source);
        System.out.format(
                "\tThe largest Rectangle Area in %s is %d.\n", Arrays.toString(source), result);
        assertEquals(expected, result);
    }

    @Test
    public void largestRectangleArea_10() {
        int expected = 3;
        printTestHeader(name.getMethodName());
        int[] source = {2, 1, 1, 0, 1};
        int result = StackLargestRectangleInHistogram.largestRectangleAreaBrute(source);
        System.out.format(
                "\tThe largest Rectangle Area in %s is %d.\n", Arrays.toString(source), result);
        assertEquals(expected, result);
    }

    @Test
    public void largestRectangleArea_11() {
        int expected = 6;
        printTestHeader(name.getMethodName());
        int[] source = {2, 0, 4, 3, 2};
        int result = StackLargestRectangleInHistogram.largestRectangleArea(source);
        System.out.format(
                "\tThe largest Rectangle Area in %s is %d.\n", Arrays.toString(source), result);
        assertEquals(expected, result);
    }

    @Test
    public void largestRectangleArea_2() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        int[] source = {2, 4};
        int result = StackLargestRectangleInHistogram.largestRectangleArea(source);
        System.out.format(
                "\tThe largest Rectangle Area in %s is %d.\n", Arrays.toString(source), result);
        assertEquals(expected, result);
    }

    @Test
    public void largestRectangleArea_3() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        int[] source = {1, 2, 4};
        int result = StackLargestRectangleInHistogram.largestRectangleArea(source);
        System.out.format(
                "\tThe largest Rectangle Area in %s is %d.\n", Arrays.toString(source), result);
        assertEquals(expected, result);
    }

    @Test
    public void largestRectangleArea_4() {
        int expected = 5;
        printTestHeader(name.getMethodName());
        int[] source = {2, 1, 2, 3, 1};
        int result = StackLargestRectangleInHistogram.largestRectangleArea(source);
        System.out.format(
                "\tThe largest Rectangle Area in %s is %d.\n", Arrays.toString(source), result);
        assertEquals(expected, result);
    }

    @Test
    public void largestRectangleArea_5() {
        int expected = 10;
        printTestHeader(name.getMethodName());
        int[] source = {2, 1, 5, 6, 2, 3};
        int result = StackLargestRectangleInHistogram.largestRectangleAreaBrute(source);
        System.out.format(
                "\tThe largest Rectangle Area in %s is %d.\n", Arrays.toString(source), result);
        assertEquals(expected, result);
    }

    @Test
    public void largestRectangleArea_6() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        int[] source = {2, 4};
        int result = StackLargestRectangleInHistogram.largestRectangleAreaBrute(source);
        System.out.format(
                "\tThe largest Rectangle Area in %s is %d.\n", Arrays.toString(source), result);
        assertEquals(expected, result);
    }

    @Test
    public void largestRectangleArea_7() {
        int expected = 4;
        printTestHeader(name.getMethodName());
        int[] source = {1, 2, 4};
        int result = StackLargestRectangleInHistogram.largestRectangleAreaBrute(source);
        System.out.format(
                "\tThe largest Rectangle Area in %s is %d.\n", Arrays.toString(source), result);
        assertEquals(expected, result);
    }

    @Test
    public void largestRectangleArea_8() {
        int expected = 5;
        printTestHeader(name.getMethodName());
        int[] source = {2, 1, 2, 3, 1};
        int result = StackLargestRectangleInHistogram.largestRectangleAreaBrute(source);
        System.out.format(
                "\tThe largest Rectangle Area in %s is %d.\n", Arrays.toString(source), result);
        assertEquals(expected, result);
    }

    @Test
    public void largestRectangleArea_9() {
        int expected = 2;
        printTestHeader(name.getMethodName());
        int[] source = {2, 0, 1, 0, 1};
        int result = StackLargestRectangleInHistogram.largestRectangleAreaBrute(source);
        System.out.format(
                "\tThe largest Rectangle Area in %s is %d.\n", Arrays.toString(source), result);
        assertEquals(expected, result);
    }
}
