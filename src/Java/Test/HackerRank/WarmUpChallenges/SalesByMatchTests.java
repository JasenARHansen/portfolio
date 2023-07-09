package Java.Test.HackerRank.WarmUpChallenges;

import static org.junit.Assert.assertEquals;

import Java.Code.HackerRank.WarmUpChallenges.SalesByMatch;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SalesByMatchTests {
  @Rule public TestName name = new TestName();

  @Test
  public void numberOfPairsMap_1() {
    int expected = 2;
    int[] values = {1, 2, 1, 2, 1, 3, 2};
    int result = SalesByMatch.numberOfPairsMap(values);
    System.out.format(
        "%s:The list of colors '%s' has %d pairs.\n",
        name.getMethodName(), Arrays.toString(values), result);
    assertEquals(expected, result);
  }

  @Test
  public void numberOfPairsMap_2() {
    int expected = 3;
    int[] values = {10, 20, 20, 10, 10, 30, 50, 10, 20};
    int result = SalesByMatch.numberOfPairsMap(values);
    System.out.format(
        "%s:The list of colors '%s' has %d pairs.\n",
        name.getMethodName(), Arrays.toString(values), result);
    assertEquals(expected, result);
  }

  @Test
  public void numberOfPairsSet_1() {
    int expected = 2;
    int[] values = {1, 2, 1, 2, 1, 3, 2};
    int result = SalesByMatch.numberOfPairsSet(values);
    System.out.format(
        "%s:The list of colors '%s' has %d pairs.\n",
        name.getMethodName(), Arrays.toString(values), result);
    assertEquals(expected, result);
  }

  @Test
  public void numberOfPairsSet_2() {
    int expected = 3;
    int[] values = {10, 20, 20, 10, 10, 30, 50, 10, 20};
    int result = SalesByMatch.numberOfPairsSet(values);
    System.out.format(
        "%s:The list of colors '%s' has %d pairs.\n",
        name.getMethodName(), Arrays.toString(values), result);
    assertEquals(expected, result);
  }
}
