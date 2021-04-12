package Code.interview.Amazon.assessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class assessment_1 {
  /*
  An Amazon Fullfillment Associate has a set of items that need to be packed into 2 boxes.  Given an integer array of
   the item weights (arr) to be packed, divide the item weights into two subsets, A and B, for packing into the
   Associated boxes, while respecting the following conditions:

  The Intersection of A and B is nu..
  The Union of A and B is equal to the original array
  The sum of A's weights is greater than the sum of B's weights
  Return the subset A in increasing order where the sum oia A's weights is greater than the sum of B's weights.  If more
   than one subset A exists, return the one with the maximal total weight.

  Example
  N = 5
  arr = [3, 7, 5, ,2]

  The 2 subsets in the arr that satisfy the conditions are [5, 7] and [6,7]

  A in Minimal (size 2)
  */

  public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
    List<Integer> set_A = new ArrayList<>();
    int sum_A = 0;
    int sum_B = 0;

    Collections.sort(arr);
    while (!arr.isEmpty()) {
      // Set A
      sum_A += arr.get(arr.size() - 1);
      set_A.add(0, arr.remove(arr.size() - 1));
      // Set B
      while (!arr.isEmpty()) {
        if (sum_B + arr.get(0) < sum_A) {
          sum_B += arr.get(0);
          arr.remove(0);
        } else {
          break;
        }
      }
    }

    return set_A;
  }
}
