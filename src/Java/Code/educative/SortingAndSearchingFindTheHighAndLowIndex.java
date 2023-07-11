package Java.code.educative;

public class SortingAndSearchingFindTheHighAndLowIndex {
  /*
  Given a sorted array of integers, return the low and high index of the given key. You must return -1 if the indexes
   are not found.
      The array length can be in the millions with many duplicates.
  In the following example, according to the key, the low and high indices would be:
      1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20
      key: 1, low = 0 and high = 0
      key: 2, low = 1 and high = 1
      key: 5, low = 2 and high = 9
      key: 20, low = 10 and high = 10
  For the testing of your code, the input array will be:
  1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6
  def find_low_index(arr, key):
    #Write - Your - Code
    return -2
  def find_high_index(arr, key):
    #Write - Your - Code
    return -2
  Runtime complexity: Logarithmic O(log n)
  Memory Complexity: Constant, O(1)
  Linearly scanning the sorted array for low and high indices are highly inefficient since our array size can be
   in millions. Instead, we will use a slightly modified binary search to find the low and high indices of a given
   key. We need to do binary search twice:
      Once for finding the low index.
      Once for finding the high index.
  Low index
  Let’s look at the algorithm for finding the low index:
      At every step, consider the array between low and high indices and calculate the middle index.
      If the element at middle index is less than the key, low becomes middle + 1 (to move towards the start of range).
      If the element at middle is greater or equal to the key, the high becomes middle - 1. Index at low remains the same.
      When low is greater than high, low would be pointing to the first occurrence of the key.
      If the element at low does not match the key, return -1.
  High index
  Similarly, we can find the high index by slightly modifying the above condition:
      Switch the low index to middle + 1 when the element at middle index is less than or equal to the key.
      Switch the high index to middle - 1 when the element at middle is greater than the key. */
  public static int find_low_index(int[] array, int value) {
    int returnValue = -1;
    int indexLow = 0;
    int indexHigh = array.length - 1;
    int middle = (indexLow + indexHigh) / 2;
    while (indexLow < indexHigh) {
      if (array[middle] < value) {
        indexLow = middle + 1;
      } else {
        indexHigh = middle - 1;
      }
      middle = (indexLow + indexHigh) / 2;
    }
    if (array[indexLow] == value) {
      returnValue = indexLow;
    } else if ((indexLow + 1 < array.length - 1) && (array[indexLow + 1] == value)) {
      returnValue = indexLow + 1;
    }
    return returnValue;
  }

  public static int find_high_index(int[] array, int value) {
    int returnValue = -1;
    int indexLow = 0;
    int indexHigh = array.length - 1;
    int middle = (indexLow + indexHigh) / 2;
    while (indexLow < indexHigh) {
      if (array[middle] <= value) {
        indexLow = middle + 1;
      } else {
        indexHigh = middle - 1;
      }
      middle = (indexLow + indexHigh) / 2;
    }
    if (array[indexLow] == value) {
      returnValue = indexLow;
    } else if ((indexLow - 1 >= 0) && (array[indexLow - 1] == value)) {
      returnValue = indexLow - 1;
    }
    return returnValue;
  }
}
