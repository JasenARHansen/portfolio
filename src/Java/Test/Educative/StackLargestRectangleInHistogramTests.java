package Java.Test.Educative;

import static org.junit.Assert.assertEquals;

import Java.Code.Educative.StackLargestRectangleInHistogram;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StackLargestRectangleInHistogramTests {
  @Rule public TestName name = new TestName();

  @Test
  public void largestRectangleArea_1() {
    int expected = 10;
    int[] source = {2, 1, 5, 6, 2, 3};
    int result = StackLargestRectangleInHistogram.largestRectangleArea(source);
    System.out.format(
        "%s: The largest Rectangle Area in %s is %d.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertEquals(expected, result);
  }

  @Test
  public void largestRectangleArea_2() {
    int expected = 4;
    int[] source = {2, 4};
    int result = StackLargestRectangleInHistogram.largestRectangleArea(source);
    System.out.format(
        "%s: The largest Rectangle Area in %s is %d.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertEquals(expected, result);
  }

  @Test
  public void largestRectangleArea_3() {
    int expected = 4;
    int[] source = {1, 2, 4};
    int result = StackLargestRectangleInHistogram.largestRectangleArea(source);
    System.out.format(
        "%s: The largest Rectangle Area in %s is %d.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertEquals(expected, result);
  }

  @Test
  public void largestRectangleArea_4() {
    int expected = 5;
    int[] source = {2, 1, 2, 3, 1};
    int result = StackLargestRectangleInHistogram.largestRectangleArea(source);
    System.out.format(
        "%s: The largest Rectangle Area in %s is %d.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertEquals(expected, result);
  }

  @Test
  public void largestRectangleArea_5() {
    int expected = 10;
    int[] source = {2, 1, 5, 6, 2, 3};
    int result = StackLargestRectangleInHistogram.largestRectangleAreaBrute(source);
    System.out.format(
        "%s: The largest Rectangle Area in %s is %d.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertEquals(expected, result);
  }

  @Test
  public void largestRectangleArea_6() {
    int expected = 4;
    int[] source = {2, 4};
    int result = StackLargestRectangleInHistogram.largestRectangleAreaBrute(source);
    System.out.format(
        "%s: The largest Rectangle Area in %s is %d.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertEquals(expected, result);
  }

  @Test
  public void largestRectangleArea_7() {
    int expected = 4;
    int[] source = {1, 2, 4};
    int result = StackLargestRectangleInHistogram.largestRectangleAreaBrute(source);
    System.out.format(
        "%s: The largest Rectangle Area in %s is %d.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertEquals(expected, result);
  }

  @Test
  public void largestRectangleArea_8() {
    int expected = 5;
    int[] source = {2, 1, 2, 3, 1};
    int result = StackLargestRectangleInHistogram.largestRectangleAreaBrute(source);
    System.out.format(
        "%s: The largest Rectangle Area in %s is %d.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertEquals(expected, result);
  }

  @Test
  public void largestRectangleArea_9() {
    int expected = 2;
    int[] source = {2, 0, 1, 0, 1};
    int result = StackLargestRectangleInHistogram.largestRectangleAreaBrute(source);
    System.out.format(
        "%s: The largest Rectangle Area in %s is %d.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertEquals(expected, result);
  }

  @Test
  public void largestRectangleArea_10() {
    int expected = 3;
    int[] source = {2, 1, 1, 0, 1};
    int result = StackLargestRectangleInHistogram.largestRectangleAreaBrute(source);
    System.out.format(
        "%s: The largest Rectangle Area in %s is %d.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertEquals(expected, result);
  }

  @Test
  public void largestRectangleArea_11() {
    int expected = 6;
    int[] source = {2, 0, 4, 3, 2};
    int result = StackLargestRectangleInHistogram.largestRectangleArea(source);
    System.out.format(
        "%s: The largest Rectangle Area in %s is %d.\n",
        name.getMethodName(), Arrays.toString(source), result);
    assertEquals(expected, result);
  }
}
