package Code.Educative;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingFindAllPossibleSubsets {
  /*
  We are given a set of integers, and we have to find all the possible subsets of this set of integers.

  Runtime complexity: Exponential, O(2^{n} * n), where nnn is the number of integers in the given set

  Memory Complexity: Constant, O(2^{n} * n)

  There are several ways to solve this problem. We will discuss the one that is neat and easier to understand. We know
   that for a set of ‘n’ elements there are 2^{n} subsets. For example, a set with 3 elements will have 8 subsets.
   Here is the algorithm we will use:
  n = size of given integer set
  subsets_count = 2^n
  for i = 0 to subsets_count
      form a subset using the value of 'i' as following:
          bits in number 'i' represent index of elements to choose from original set,
          if a specific bit is 1 choose that number from original set and add it to current subset,
          e.g. if i = 6 i.e. 110 in binary means that 1st and 2nd elements in original array need to be picked.
      add current subset to list of all subsets

  Note that the ordering of bits for picking integers from the set does not matter; picking integers from left to
   right would produce the same output as picking integers from right to left.

  */

  public static List<List<Integer>> get_all_subsets(int[] data) {
    boolean[] vector = new boolean[data.length];
    List<List<Integer>> returnSets = new ArrayList<>();
    ArrayList<Integer> permutation = new ArrayList<>();
    returnSets.add(permutation);
    for (int i = 0; i < Math.pow(2, data.length) - 1; i++) {
      incrementValues(vector);
      permutation = new ArrayList<>();
      for (int index = 0; index < data.length; index++) {
        if (vector[index]) {
          permutation.add(data[index]);
        }
      }
      returnSets.add(permutation);
    }
    return returnSets;
  }

  private static void incrementValues(boolean[] values) {
    int index = values.length - 1;
    if (values[index]) {
      values[index] = false;
      index--;
      while ((index >= 0) && (values[index])) {
        values[index] = false;
        index--;
      }
      if (index >= 0) {
        values[index] = true;
      }
    } else {
      values[index] = true;
    }
  }
}
