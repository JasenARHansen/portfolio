package Java.test.educative;

import Java.code.educative.DynamicProgrammingFindMaximumSingleSellProfit;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

import static Java.test.library.Library.printTestHeader;
import static org.junit.Assert.assertArrayEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DynamicProgrammingFindMaximumSingleSellProfitTests {
    @Rule
    public final TestName name = new TestName();

    @Test
    public void find_stock_prices_1() {
        int[] expected = {5, 19, 14};
        printTestHeader(name.getMethodName());
        int[] values = {8, 5, 12, 9, 19, 1};
        int[] result = DynamicProgrammingFindMaximumSingleSellProfit.find_buy_sell_stock_prices(values);
        System.out.format(
                "\tGiven the prices '%s' to get the maximum profit or minimum loss is the buy price is %d"
                        + " and the sell price is %d with a profit of %d.\n",
                Arrays.toString(values), result[0], result[1], result[2]);
        assertArrayEquals(expected, result);
    }

    @Test
    public void find_stock_prices_2() {
        int[] expected = {12, 11, -1};
        printTestHeader(name.getMethodName());
        int[] values = {21, 12, 11, 9, 6, 3};
        int[] result = DynamicProgrammingFindMaximumSingleSellProfit.find_buy_sell_stock_prices(values);
        System.out.format(
                "\tGiven the prices '%s' to get the maximum profit or minimum loss is the buy price is %d"
                        + " and the sell price is %d with a profit of %d.\n",
                Arrays.toString(values), result[0], result[1], result[2]);
        assertArrayEquals(expected, result);
    }

    @Test
    public void find_stock_prices_3() {
        int[] expected = {5, 19, 14};
        printTestHeader(name.getMethodName());
        int[] values = {8, 5, 12, 9, 19, 1};
        int[] result =
                DynamicProgrammingFindMaximumSingleSellProfit.find_sell_profit_stock_prices(values);
        System.out.format(
                "\tGiven the prices '%s' to get the maximum profit or minimum loss is the buy price is %d"
                        + " and the sell price is %d with a profit of %d.\n",
                Arrays.toString(values), result[0], result[1], result[2]);
        assertArrayEquals(expected, result);
    }

    @Test
    public void find_stock_prices_4() {
        int[] expected = {12, 11, -1};
        printTestHeader(name.getMethodName());
        int[] values = {21, 12, 11, 9, 6, 3};
        int[] result =
                DynamicProgrammingFindMaximumSingleSellProfit.find_sell_profit_stock_prices(values);
        System.out.format(
                "\tGiven the prices '%s' to get the maximum profit or minimum loss is the buy price is %d"
                        + " and the sell price is %d with a profit of %d.\n",
                Arrays.toString(values), result[0], result[1], result[2]);
        assertArrayEquals(expected, result);
    }

    @Test
    public void getDescription() {
        printTestHeader(name.getMethodName());
        DynamicProgrammingFindMaximumSingleSellProfit.getDescription();
    }
}
