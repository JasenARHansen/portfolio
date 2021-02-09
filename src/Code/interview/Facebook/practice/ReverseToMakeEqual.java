package Code.interview.Facebook.practice;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseToMakeEqual {
  /*
  Reverse to Make Equal
  Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays
   from array B any number of times.
  Signature
  bool areTheyEqual(int[] arr_a, int[] arr_b)
  Input
  All integers in array are in the range [0, 1,000,000,000].
  Output
  Return true if B can be made equal to A, return false otherwise.
  Example
  A = [1, 2, 3, 4]
  B = [1, 4, 3, 2]
  output = true
  After reversing the subarray of B from indices 1 to 3, array B will equal array A.
  */
  public static int[] reverse(int[] array) {
    return IntStream.rangeClosed(1, array.length).map(i -> array[array.length - i]).toArray();
  }

  public static boolean areTheyEqual(int[] array_a, int[] array_b) {
    if (Arrays.equals(array_a, array_b)) {
      return true;
    } else {
      int length = array_a.length;
      for (int index = 1; index < length; index++) {
        int[] a_left = Arrays.copyOfRange(array_a, 0, index);
        int[] b_left = Arrays.copyOfRange(array_b, 0, index);
        boolean leftEqual;
        if (areTheyEqual(a_left, b_left)) {
          leftEqual = true;
        } else {
          leftEqual = areTheyEqual(a_left, reverse(b_left));
        }
        boolean rightEqual;
        int[] a_right = Arrays.copyOfRange(array_a, index, length);
        int[] b_right = Arrays.copyOfRange(array_b, index, length);
        if (areTheyEqual(a_right, b_right)) {
          rightEqual = true;
        } else {
          rightEqual = areTheyEqual(a_right, reverse(b_right));
        }
        if (leftEqual && rightEqual) {
          return true;
        }
      }
    }
    return false;
  }
}
