package Java.code.ctci.source.ch_08_Recursion_and_Dynamic_Programming.q8_11_Coins;

public class Question {
  public static int makeChangeHelper(int total, int[] denominations, int index) {
    int coin = denominations[index];
    if (index == denominations.length - 1) { // One denomination left, either you can do it or not
      int remaining = total % coin;
      return remaining == 0 ? 1 : 0;
    }
    int ways = 0;
    /* Try 1 coin, then 2 coins, 3 three, ... (using recursion for each time on rest). */
    for (int amount = 0; amount <= total; amount += coin) {
      ways += makeChangeHelper(total - amount, denominations, index + 1); // go to next denomination
    }
    return ways;
  }

  public static int makeChange(int amount, int[] denominations) {
    return makeChangeHelper(amount, denominations, 0);
  }

  public static void main(String[] args) {
    int[] denominations = {25, 10, 5, 1};
    int ways = makeChange(10, denominations);
    System.out.println(ways);
  }
}
