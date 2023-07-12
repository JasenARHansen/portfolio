package Java.test.educative;

import static org.junit.Assert.assertArrayEquals;

import Java.code.educative.DynamicProgrammingFindMaximumSingleSellProfit;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DynamicProgrammingFindMaximumSingleSellProfitTests {
  @Rule public final TestName name = new TestName();

  @Test
  public void DynamicProgrammingFindMaximumSingleSellProfit() {
    System.out.format("%s:", name.getMethodName());
    DynamicProgrammingFindMaximumSingleSellProfit.getDescription();
  }

  @Test
  public void find_stock_prices_1() {
    int[] expected = {5, 19, 14};
    int[] values = {8, 5, 12, 9, 19, 1};
    int[] result = DynamicProgrammingFindMaximumSingleSellProfit.find_buy_sell_stock_prices(values);
    System.out.format(
        "%s: Given the prices '%s' to get the maximum profit or minimum loss is the buy price is %d"
            + " and the sell price is %d with a profit of %d.\n",
        name.getMethodName(), Arrays.toString(values), result[0], result[1], result[2]);
    assertArrayEquals(expected, result);
  }

  @Test
  public void find_stock_prices_2() {
    int[] expected = {12, 11, -1};
    int[] values = {21, 12, 11, 9, 6, 3};
    int[] result = DynamicProgrammingFindMaximumSingleSellProfit.find_buy_sell_stock_prices(values);
    System.out.format(
        "%s: Given the prices '%s' to get the maximum profit or minimum loss is the buy price is %d"
            + " and the sell price is %d with a profit of %d.\n",
        name.getMethodName(), Arrays.toString(values), result[0], result[1], result[2]);
    assertArrayEquals(expected, result);
  }

  @Test
  public void find_stock_prices_3() {
    int[] expected = {5, 19, 14};
    int[] values = {8, 5, 12, 9, 19, 1};
    int[] result =
        DynamicProgrammingFindMaximumSingleSellProfit.find_sell_profit_stock_prices(values);
    System.out.format(
        "%s: Given the prices '%s' to get the maximum profit or minimum loss is the buy price is %d"
            + " and the sell price is %d with a profit of %d.\n",
        name.getMethodName(), Arrays.toString(values), result[0], result[1], result[2]);
    assertArrayEquals(expected, result);
  }

  @Test
  public void find_stock_prices_4() {
    int[] expected = {12, 11, -1};
    int[] values = {21, 12, 11, 9, 6, 3};
    int[] result =
        DynamicProgrammingFindMaximumSingleSellProfit.find_sell_profit_stock_prices(values);
    System.out.format(
        "%s: Given the prices '%s' to get the maximum profit or minimum loss is the buy price is %d"
            + " and the sell price is %d with a profit of %d.\n",
        name.getMethodName(), Arrays.toString(values), result[0], result[1], result[2]);
    assertArrayEquals(expected, result);
  }
}
