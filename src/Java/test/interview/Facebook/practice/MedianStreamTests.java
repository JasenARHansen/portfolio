package Java.test.interview.Facebook.practice;

import Java.code.interview.Facebook.practice.MedianStream;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertArrayEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MedianStreamTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void findMedianPQ_1() {
        int[] expected = {5, 10, 5, 4};
        printTestHeader(name.getMethodName());
        int[] values = {5, 15, 1, 3};
        int[] result = MedianStream.findMedianPQ(values);
        System.out.format(
                "\tThe median values of the sub arrays of '%s' are '%s'.\n",
                Arrays.toString(values), Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void findMedianPQ_2() {
        int[] expected = {1, 1};
        printTestHeader(name.getMethodName());
        int[] values = {1, 2};
        int[] result = MedianStream.findMedianPQ(values);
        System.out.format(
                "\tThe median values of the sub arrays of '%s' are '%s'.\n",
                Arrays.toString(values), Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void findMedianPQ_3() {
        int[] expected = {2, 3, 4, 3, 4, 3};
        printTestHeader(name.getMethodName());
        int[] values = {2, 4, 7, 1, 5, 3};
        int[] result = MedianStream.findMedianPQ(values);
        System.out.format(
                "\tThe median values of the sub arrays of '%s' are '%s'.\n",
                Arrays.toString(values), Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void findMedian_1() {
        int[] expected = {5, 10, 5, 4};
        printTestHeader(name.getMethodName());
        int[] values = {5, 15, 1, 3};
        int[] result = MedianStream.findMedian(values);
        System.out.format(
                "\tThe median values of the sub arrays of '%s' are '%s'.\n",
                Arrays.toString(values), Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void findMedian_2() {
        int[] expected = {1, 1};
        printTestHeader(name.getMethodName());
        int[] values = {1, 2};
        int[] result = MedianStream.findMedian(values);
        System.out.format(
                "\tThe median values of the sub arrays of '%s' are '%s'.\n",
                Arrays.toString(values), Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void findMedian_3() {
        int[] expected = {2, 3, 4, 3, 4, 3};
        printTestHeader(name.getMethodName());
        int[] values = {2, 4, 7, 1, 5, 3};
        int[] result = MedianStream.findMedian(values);
        System.out.format(
                "\tThe median values of the sub arrays of '%s' are '%s'.\n",
                Arrays.toString(values), Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        MedianStream.getDescription();
    }
}
