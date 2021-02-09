package Code.HackerRank.DictionariesAndHashmaps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {
  /*
  You are given an array and you need to find number of tripets of indices (i, j, k) such that the elements at those
   indices are in geometric progression for a given common ratio r and i < j < k.

  For example, arr = [1, 4, 16, 64]. If r=4, we have [1, 4, 16] and [4, 16, 640] at indices (0, 1, 2) and (1, 2, 4).

  Function Description

  Complete the countTriplets function in the editor below. It should return the number of triplets forming a geometric
   progression for a given r as an integer.

  countTriplets has the following parameter(s):
    arr: an array of integers
    r: an integer, the common ratio

  Input Format
    The first line contains two space-separated integers n and r, the size of arr and the common ratio.
    The next line contains space-seperated integers arr[i].

  Constraints

  Output Format
    Return the count of triplets that form a geometric progression.

  Sample Input 0
    4 2
    1 2 2 4

  Sample Output 0
    2

  Explanation 0
    There are 2 triplets in satisfying our criteria, whose indices are (0, 1, 3) and (0, 2, 3)

  Sample Input 1
    6 3
    1 3 9 9 27 81

  Sample Output 1
    6

  Explanation 1
      The triplets satisfying are index (0, 1, 2), (0, 1, 3), (1, 2, 4), (1, 3, 4), (2, 5, 5) and (3, 4, 5).

  Sample Input 2
    5 5
    1 5 5 25 125

  Sample Output 2
    4

  Explanation 2
    The triplets satisfying are index (0, 1, 3), (0, 2, 3), (1, 3, 2), (2, 3, 4).
  */

  public static long countTriplets(List<Long> arr, long r) {
    Map<Long, Long> exponents = new HashMap<>();
    // Extract exponent of value and populate map
    for (Long element : arr) {
      long exponent = -1l;
      if (r == 1) {
        if (element == 1) {
          exponent = 1;
        }
      } else if (r == 0) {
        if (element == 0) {
          exponent = 0;
        }
      } else {
        double raw = Math.floor((Math.log(element) / Math.log(r)) * 10000) / 10000;
        if ((raw == Math.floor(raw)) && !Double.isInfinite(raw)) {
          exponent = (long) raw;
        }
      }
      if (exponent != -1l) {
        if (exponents.containsKey(exponent)) {
          exponents.put(exponent, exponents.get(exponent) + 1);
        } else {
          exponents.put(exponent, 1l);
        }
      }
    }
    long count = 0;
    for (Long key : exponents.keySet()) {
      if ((r <= 1l) && (exponents.get(key) > 2)) {
        count = partialFactorial(exponents.get(key), 3) / partialFactorial(3, 3);
        int foo = 1;
      } else if ((exponents.containsKey(key + 1)) && (exponents.containsKey(key + 2))) {
        count += exponents.get(key) * exponents.get(key + 1) * exponents.get(key + 2);
      }
    }
    return count;
  }

  private static long partialFactorial(long value, long count) {
    long returnValue = value;
    for (long i = count - 1; i > 0; i--) {
      returnValue *= --value;
    }
    return returnValue;
  }
}
