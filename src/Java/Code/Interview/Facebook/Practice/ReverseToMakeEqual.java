package Java.Code.Interview.Facebook.Practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseToMakeEqual {
  public static void getDescription() {
    System.out.println(
        """
                Reverse to Make Equal
                Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any sub-arrays from array B any number of times.
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
                After reversing the sub-array of B from indices 1 to 3, array B will equal array A.
                """
            .indent(2));
  }

  public static boolean areTheyEqual(int[] array_a, int[] array_b) {
    if (array_a.length != array_b.length) {
      return false;
    }
    if (Arrays.equals(array_a, array_b)) {
      return true;
    } else {
      List<Integer> list_b = Arrays.stream(array_b).boxed().collect(Collectors.toList());
      int length = array_a.length;
      for (int index = 0; index < length; ) {
        if (array_a[index] == list_b.get(index)) {
          index++;
        } else {
          int inner = index;
          while ((array_a[index] != list_b.get(inner)) && (inner < length)) {
            inner++;
            if (inner == length) {
              return false;
            }
          }
          ReverseToMakeEqual.reversSubList(list_b, index, inner);
        }
      }
    }
    return true;
  }

  static <E> void reversSubList(List<E> list, int startIndex, int endIndex) {
    List<E> subList = list.subList(startIndex, endIndex + 1);
    Collections.reverse(subList);
  }
}
