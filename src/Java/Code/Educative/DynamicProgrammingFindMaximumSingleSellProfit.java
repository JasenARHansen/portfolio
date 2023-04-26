package Java.Code.Educative;

public class DynamicProgrammingFindMaximumSingleSellProfit {
  /*
  Given a list of daily stock prices (integers for simplicity), return the buy and sell prices for making
   the maximum profit.

  We need to maximize the single buy/sell profit. If we can’t make any profit, we’ll try to minimize the
   loss. For the below examples, buy (orange) and sell (green) prices for making a maximum profit are
   highlighted.
    8 [5] 12 9 [19] 1   Buy 5 Sell 19 = Maximum Profit
    21 [12] [11] 9 6 3  Buy 12 Sell 11 = Minimum Loss

  Runtime complexity: Linear, O(n)
  Memory Complexity: Constant, O(1)

  The values in the array represent the cost of a stock each day. As we can buy and sell the stock only
   once, we need to find the best buy and sell prices for which our profit is maximized (or loss is
   minimized) over a given span of time.

  A naive solution, with runtime complexity of O(n^2), is to find the maximum gain between each element
   and its succeeding elements.

  There is a tricky linear solution to this problem that requires maintaining current_buy_price (which
   is the smallest number seen so far), current_profit, and global_profit as we iterate through the
   entire array of stock prices.

  At each iteration, we will compare the current_profit with the global_profit and update the
   global_profit accordingly.

  The basic algorithm is as follows:
  current buy = stock_prices[0]
  global sell = stock_prices[1]
  global profit = global sell - current buy

  for i = 1 to stock_prices.length:
    current profit = stock_prices[i] - current buy
    if current profit is greater than global profit
      then update global profit to current profit and update global sell to stock_prices[i]
    if stock_prices[i] is less than current buy
      then update current buy to stock_prices[i]

  return global profit and global sell
  */

  public static int[] find_buy_sell_stock_prices(int[] prices) {
    int buy = prices[0];
    int sell = prices[1];
    int profit = sell - buy;
    for (int leftIndex = 0; leftIndex < prices.length - 1; leftIndex++) {
      for (int rightIndex = leftIndex + 1; rightIndex < prices.length; rightIndex++) {
        if ((prices[rightIndex] - prices[leftIndex]) > profit) {
          buy = prices[leftIndex];
          sell = prices[rightIndex];
          profit = sell - buy;
        }
      }
    }
    return new int[]{buy, sell, sell - buy};
  }

  public static int[] find_sell_profit_stock_prices(int[] prices) {
    int buy = prices[0];
    int sell = prices[1];
    int profit = sell - buy;
    int current_profit;
    for (int index = 1; index < prices.length; index++) {
      current_profit = prices[index] - buy;

      if (profit < current_profit) {
        profit = current_profit;
        sell = prices[index];
      }
      if (prices[index] < buy) {
        buy = prices[index];
      }
    }
    return new int[]{sell - profit, sell, profit};
  }
}
