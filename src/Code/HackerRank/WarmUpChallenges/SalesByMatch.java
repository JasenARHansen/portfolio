package Code.HackerRank.WarmUpChallenges;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SalesByMatch {
  /*
  There is a large pile of socks that must be paired by color. Given an array of integers representing the color of
   each sock, determine how many pairs of socks with matching colors there are.
  Example
  n = 7
  ar = [1,2,1,2,1,3,2]
  There is one pair of color [1] and one of color [1]. There are three odd socks left, one of each color. The number
   of pairs is 2

  Function Description

  Complete the sockMerchant function in the editor below.

  sockMerchant has the following parameter(s):
      int n: the number of socks in the pile
      int ar[n]: the colors of each sock

  Returns
      int: the number of pairs

  Input Format

  The first line contains an integer n, the number of socks represented in ar.
  The second line contains n space-separated integers,ar[i], the colors of the socks in the pile.

  Sample Input
  STDIN                       Function
  -----                       --------
  9                           n = 9
  10 20 20 10 10 30 50 10 20  ar = [10, 20, 20, 10, 10, 30, 50, 10, 20]

  Sample Output

  3
  There are three pairs of socks.
  */

    public static int numberOfPairsMap(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int value : array) {
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }
        int pairs = 0;
        for (int key : map.keySet()) {
            pairs += map.get(key) / 2;
        }
        return pairs;
    }

    public static int numberOfPairsSet(int[] array) {
        Set<Integer> set = new HashSet<>();

        int pairs = 0;
        for (int value : array) {
            if (!set.add(value)) {
                pairs++;
                set.remove(value);
            }
        }

        return pairs;
    }
}
