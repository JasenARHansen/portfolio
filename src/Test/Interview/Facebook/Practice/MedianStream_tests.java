package Test.Interview.Facebook.Practice;

import Code.Interview.Facebook.Practice.MedianStream;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MedianStream_tests {

    @Rule
    public TestName name = new TestName();

    @Test
    public void findMedian_1() {
        int[] expected = {5, 10, 5, 4};
        int[] values = {5, 15, 1, 3};
        int[] result = MedianStream.findMedian(values);
        System.out.format(
                "%s: The median values of the sub arrays of '%s' are '%s'.\n",
                name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    @Test
    public void findMedian_2() {
        int[] expected = {1, 1};
        int[] values = {1, 2};
        int[] result = MedianStream.findMedian(values);
        System.out.format(
                "%s: The median values of the sub arrays of '%s' are '%s'.\n",
                name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

    @Test
    public void findMedian_3() {
        int[] expected = {2, 3, 4, 3, 4, 3};
        int[] values = {2, 4, 7, 1, 5, 3};
        int[] result = MedianStream.findMedian(values);
        System.out.format(
                "%s: The median values of the sub arrays of '%s' are '%s'.\n",
                name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }
}
