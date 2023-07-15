package Java.code.ctci.source.ch_08_Recursion_and_Dynamic_Programming.q8_11_Coins;

public class QuestionB {

    public static void main(String[] args) {
        int[] denominations = {25, 10, 5, 1};
        int ways = makeChange(10, denominations);
        System.out.println(ways);
    }

    public static int makeChange(int n, int[] denominations) {
        int[][] map = new int[n + 1][denominations.length];
        return makeChangeHelper(n, denominations, 0, map);
    }

    public static int makeChangeHelper(int total, int[] denominations, int index, int[][] map) {
        /* Check cache for prior result. */
        if (map[total][index] > 0) { // retrieve value
            return map[total][index];
        }
        int coin = denominations[index];
        if (index == denominations.length - 1) {
            int remaining = total % coin;
            return remaining == 0 ? 1 : 0;
        }
        int numberOfWays = 0;
        /* Try 1 coin, then 2 coins, 3 three, ... (using recursion for each time on rest). */
        for (int amount = 0; amount <= total; amount += coin) {
            numberOfWays +=
                    makeChangeHelper(
                            total - amount, denominations, index + 1, map); // go to next denomination
        }
        /* Update cache with current result. */
        map[total][index] = numberOfWays;
        return numberOfWays;
    }
}
