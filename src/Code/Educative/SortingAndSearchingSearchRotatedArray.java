package Code.Educative;

public class SortingAndSearchingSearchRotatedArray {
  /*
  Search for a given number in a sorted array, with unique elements, that has been rotated by some arbitrary number.
   Return -1 if the number does not exist.
  Assume that the array does not contain duplicates
  Below is an original array before rotation.
    1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162, 176, 188, 199, 200, 210, 222
  After performing rotation on this array 6 times it changes to:
    176, 188, 199, 200, 210, 222, 1, 10, 20, 47, 59, 63, 75, 88, 99, 107, 120, 133, 155, 162

  The task is to find a given number in this array.
  def binary_search_rotated(arr, key):
    #Write - Your - Code
    return -1
  Runtime complexity: Logarithmic, O(log n)

  Memory Complexity: Logarithmic, O(log n)

  The solution is essentially a binary search but with some modifications. If we look at the array in the example
   closely, we notice that at least one half of the array is always sorted. We can use this property to our advantage.

  If the number n lies within the sorted half of the array, then our problem is a basic binary search. Otherwise,
   discard the sorted half and keep examining the unsorted half. Since we are partitioning the array in half at each
   step, this gives us O(log n) runtime complexity.

  */

  public static int binary_search_rotated(int[] array, int value) {
    // Termination cases
    if ((array == null) || (array.length == 0)) {
      return -1;
    }

    // Quick test to short circuit
    if (array[0] == value) {
      return 0;
    }

    int returnValue = -1;
    int indexLow = 0;
    int indexHigh = array.length - 1;
    int middle;
    // Find rotation division, left will be the index of the smallest value
    while (indexLow < indexHigh) {
      middle = indexLow + (indexHigh - indexLow) / 2;
      if (array[indexHigh] < array[middle]) {
        indexLow = middle + 1;
      } else {
        indexHigh = middle;
      }
    }
    int smallest = indexLow;
    indexLow = 0;
    indexHigh = array.length - 1;

    if ((array[smallest] <= value) && (value <= array[indexHigh])) {
      indexLow = smallest;
    } else {
      indexHigh = smallest;
    }

    while (indexLow <= indexHigh) {
      middle = indexLow + (indexHigh - indexLow) / 2;
      if (array[middle] == value) {
        return middle;
      } else if (array[middle] < value) {
        indexLow = middle + 1;
      } else {
        indexHigh = middle - 1;

      }
    }

    return returnValue;
  }
}
