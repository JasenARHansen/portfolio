package Code.Java.HackerRank.Sorting;

import java.util.Arrays;

public class CountingInversions {
  /*
  In an array, arr, the elements at indices i and j (where i < j) form an inversion if arr[i] > arr[j]. In other words,
   inverted elements arr[i] and arr[j] are considered to be "out of order". To correct an inversion, we can swap adjacent elements.

  Example
    arr = [2, 4, 1]
  To sort the array, we must perform the following two swaps to correct the inversions:
    arr = [2, 4, 1] -> swap arr[1] and arr[2], -> swap arr[0] and arr[1] -> [1, 2, 4]
  The sort has two inversions: (4, 1) and (2, 1).

  Given an array arr, return the number of inversions to sort the array.

  Function Description
    Complete the function countInversions in the editor below.

  countInversions has the following parameter(s):
    int arr[n]: an array of integers to sort

  Returns
      int: the number of inversions

  Input Format

  The first line contains an integer, d, the number of datasets.

  Each of the next d pairs of lines is as follows:
    The first line contains an integer, n, the number of elements in arr[].
    The second line contains n space-separated integers, arr[i].

  Constraints

  Sample Input
    STDIN       Function
    -----       --------
    2           d = 2
    5           arr[] size n = 5 for the first dataset
    1 1 1 2 2   arr = [1, 1, 1, 2, 2]
    5           arr[] size n = 5 for the second dataset
    2 1 3 1 2   arr = [2, 1, 3, 1, 2]

  Sample Output
    0
    4

  Explanation

  We sort the following d = 2 datasets:
    1. arr = [1, 1, 1, 2, 2] is already sorted, so there are no inversions for us to correct.
    2. arr = [2, 1, 3, 1, 2] -> [1, 2, 3, 1, 2] (1 swap) -> [1, 1, 2, 3, 2] (2 swap) -> [1, 1, 2, 2, 3] (1 swap)
      We performed a total of 1 + 2 + 1 = 4 swaps to correct inversions.
  */

  public static long countInversions(int[] arr) {
    return mergeSort(arr, 0, arr.length - 1);
  }

  private static long mergeSort(int[] arr, int leftIndex, int rightIndex) {
    long inversions = 0;
    if (leftIndex < rightIndex) {
      int offset = (rightIndex - leftIndex) / 2;

      inversions += mergeSort(arr, leftIndex, leftIndex + offset);
      inversions += mergeSort(arr, leftIndex + offset + 1, rightIndex);

      int[] leftSubarray = Arrays.copyOfRange(arr, leftIndex, leftIndex + offset + 1);
      int[] rightSubarray = Arrays.copyOfRange(arr, leftIndex + offset + 1, rightIndex + 1);
      int left = 0;
      int right = 0;
      int index = leftIndex;
      while ((left < leftSubarray.length) && (right < rightSubarray.length)) {
        if (leftSubarray[left] <= rightSubarray[right]) {
          arr[index++] = leftSubarray[left++];
        } else {
          arr[index++] = rightSubarray[right++];
          inversions += (leftIndex + offset + 1) - (leftIndex + left);
        }
      }
      while (left < leftSubarray.length) {
        arr[index++] = leftSubarray[left++];
      }
      while (right < rightSubarray.length) {
        arr[index++] = rightSubarray[right++];
      }
    }
    return inversions;
  }
}
