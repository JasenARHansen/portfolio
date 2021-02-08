package Test.HackerRank.Arrays;

import HackerRank.Arrays.MinimumSwaps2;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MinimumSwaps2_tests {

  @Rule
  public TestName name = new TestName();

  @Test
  public void minimumSwaps_1() {
    int expected = 1;
    int[] values = {1, 4, 3, 2};
    int[] original = values.clone();
    int result = MinimumSwaps2.minimumSwaps(values);
    System.out.format(
            "%s: Sorting the array '%s' requires a minimum of %d swaps.\n",
            name.getMethodName(), Arrays.toString(original), result);
    assertEquals(expected, result);
  }

  @Test
  public void minimumSwaps_2() {
    int expected = 5;
    int[] values = {7, 1, 3, 2, 4, 5, 6};
    int result = MinimumSwaps2.minimumSwaps(values);
    System.out.format(
            "%s: Sorting the array '%s' requires a minimum of %d swaps.\n",
            name.getMethodName(), Arrays.toString(values), result);
    assertEquals(expected, result);
  }

  @Test
  public void minimumSwaps_3() {
    int expected = 3;
    int[] values = {4, 3, 1, 2};
    int result = MinimumSwaps2.minimumSwaps(values);
    System.out.format(
            "%s: Sorting the array '%s' requires a minimum of %d swaps.\n",
            name.getMethodName(), Arrays.toString(values), result);
    assertEquals(expected, result);
  }

  @Test
  public void minimumSwaps_4() {
    int expected = 3;
    int[] values = {2, 3, 4, 1, 5};
    int result = MinimumSwaps2.minimumSwaps(values);
    System.out.format(
            "%s: Sorting the array '%s' requires a minimum of %d swaps.\n",
            name.getMethodName(), Arrays.toString(values), result);
    assertEquals(expected, result);
  }

  @Test
  public void minimumSwaps_5() {
    int expected = 3;
    int[] values = {1, 3, 5, 2, 4, 6, 7};
    int result = MinimumSwaps2.minimumSwaps(values);
    System.out.format(
            "%s: Sorting the array '%s' requires a minimum of %d swaps.\n",
            name.getMethodName(), Arrays.toString(values), result);
    assertEquals(expected, result);
  }
}
