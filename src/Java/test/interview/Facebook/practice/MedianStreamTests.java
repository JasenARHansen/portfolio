package Java.test.interview.Facebook.practice;

import static org.junit.Assert.assertArrayEquals;

import Java.code.interview.Facebook.practice.MedianStream;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MedianStreamTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void getDescription() {
    System.out.format("%s: ", name.getMethodName());
    MedianStream.getDescription();
  }

  @Test
  public void findMedian_1() {
    int[] expected = {5, 10, 5, 4};
    int[] values = {5, 15, 1, 3};
    int[] result = MedianStream.findMedian(values);
    System.out.format(
        "%s: The median values of the sub arrays of '%s' are '%s'.\n",
        name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
    assertArrayEquals(expected, result);
  }

  @Test
  public void findMedian_2() {
    int[] expected = {1, 1};
    int[] values = {1, 2};
    int[] result = MedianStream.findMedian(values);
    System.out.format(
        "%s: The median values of the sub arrays of '%s' are '%s'.\n",
        name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
    assertArrayEquals(expected, result);
  }

  @Test
  public void findMedian_3() {
    int[] expected = {2, 3, 4, 3, 4, 3};
    int[] values = {2, 4, 7, 1, 5, 3};
    int[] result = MedianStream.findMedian(values);
    System.out.format(
        "%s: The median values of the sub arrays of '%s' are '%s'.\n",
        name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
    assertArrayEquals(expected, result);
  }

  @Test
  public void findMedianPQ_1() {
    int[] expected = {5, 10, 5, 4};
    int[] values = {5, 15, 1, 3};
    int[] result = MedianStream.findMedianPQ(values);
    System.out.format(
        "%s: The median values of the sub arrays of '%s' are '%s'.\n",
        name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
    assertArrayEquals(expected, result);
  }

  @Test
  public void findMedianPQ_2() {
    int[] expected = {1, 1};
    int[] values = {1, 2};
    int[] result = MedianStream.findMedianPQ(values);
    System.out.format(
        "%s: The median values of the sub arrays of '%s' are '%s'.\n",
        name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
    assertArrayEquals(expected, result);
  }

  @Test
  public void findMedianPQ_3() {
    int[] expected = {2, 3, 4, 3, 4, 3};
    int[] values = {2, 4, 7, 1, 5, 3};
    int[] result = MedianStream.findMedianPQ(values);
    System.out.format(
        "%s: The median values of the sub arrays of '%s' are '%s'.\n",
        name.getMethodName(), Arrays.toString(values), Arrays.toString(result));
    assertArrayEquals(expected, result);
  }
}
