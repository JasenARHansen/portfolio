package Java.code.interview.Facebook.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimizingPermutations {
  public static void getDescription() {
    System.out.println(
        """
                Minimizing Permutations
                In this problem, you are given an integer N, and a permutation, P of the integers from 1 to N, denoted as (a_1, a_2, ..., a_N). You want to rearrange the elements of the permutation into increasing order, repeatedly making the following operation:
                Select a sub-portion of the permutation, (a_i, ..., a_j), and reverse its order.
                Your goal is to compute the minimum number of such operations required to return the permutation to increasing order.
                Signature
                 int minOperations(int[] arr)
                Input
                 Array arr is a permutation of all integers from 1 to N, N is between 1 and 8
                Output
                 An integer denoting the minimum number of operations required to arrange the permutation in increasing order
                Example
                 If N = 3, and P = (3, 1, 2), we can do the following operations:
                 Select (1, 2) and reverse it: P = (3, 2, 1).
                 Select (3, 2, 1) and reverse it: P = (1, 2, 3).
                 output = 2
                """
            .indent(2));
  }

  public static int minOperations(int[] arr) {
    Set<String> tried = new HashSet<>();
    return minOperations(arr, arr.length, tried);
  }

  private static int minOperations(int[] array, int max, Set<String> tried) {
    int count = Integer.MAX_VALUE;
    String theArray = Arrays.toString(array);
    if (tried.contains(theArray)) {
      return count;
    }
    tried.add(theArray);
    if (isSorted(array)) {
      return 0;
    }
    if (max > 0) {
      for (int outerIndex = 0; outerIndex < array.length - 1; outerIndex++) {
        for (int innerIndex = outerIndex + 1; innerIndex < array.length; innerIndex++) {
          int localCount =
              minOperations(reverseSegment(array, outerIndex, innerIndex), max - 1, tried);
          if (localCount < count) {
            count = localCount + 1;
          }
        }
      }
    }
    return count;
  }

  private static int[] reverseSegment(int[] array, int start, int stop) {
    int[] returnArray = array.clone();
    for (int index = stop - start; index >= 0; index--) {
      returnArray[start + index] = array[stop - index];
    }
    return returnArray;
  }

  private static boolean isSorted(int[] arr) {
    int index = 0;
    while (index < arr.length - 1) {
      if (arr[index] > arr[index + 1]) {
        return false;
      }
      index++;
    }
    return true;
  }
}
