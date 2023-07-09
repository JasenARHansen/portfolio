package Java.Code.Interview.Facebook.Interview.Mar_25_2021;

import java.util.Arrays;

public class Question3 {
  public static void getDescription() {
    System.out.println(
        """
                Add 2 String Numbers
                Given 2 Natural numbers (inclusive of 0) as Strings
                Add the 2 numbers together and output the result.
                Example:
                 a = "1234"
                 b = "1111"
                 result = "2345"
                Assume always a valid number
                Almost Sorted Array
                Given an almost sorted array where any given element is at most K elements away from their correctly sorted position, sort the array. You are given K.
                Example: [1, 2, 3, 6, 4, 5]
                6 is out of position, and 3 spots away from the correctly sorted position. K = 3"""
            .indent(2));
  }

  public static String addString(String left, String right) {
    // left pad zeros
    String returnString = "";
    int maxLength = Math.max(left.length(), right.length());
    if (left.length() > right.length()) {
      // pad right
      right = "0".repeat((maxLength - right.length())) + right;
    } else {
      // pad left
      left = "0".repeat((maxLength - left.length())) + left;
    }
    // Note : Now this would be something like 1234 + 0056
    int carry = 0;
    for (int index = maxLength; index > 0; index--) {
      int top = Integer.parseInt(left.substring(index - 1, index));
      int bottom = Integer.parseInt(right.substring(index - 1, index));
      int value = carry + top + bottom;
      carry = value / 10;
      value = value % 10;
      //noinspection StringConcatenationInLoop
      returnString = value + returnString;
    }
    if (carry > 0) {
      returnString = carry + returnString;
    }
    return returnString;
  }

  public static void almostSorted(int[] array, int k) {
    // sort a range if something is detected out of place
    for (int index = 0; index < array.length - 1; index++) {
      if (array[index] > array[index + 1]) {
        sortRange(array, index, k + 1);
      }
    }
  }

  private static void sortRange(int[] array, int index, int k) {
    // implement bubble sort type logic
    int startRange = 0;
    if (index > k) {
      startRange = index - k;
    }
    int stopRange = index + k;
    if (stopRange > array.length) {
      stopRange = array.length;
    }
    int[] sub_array = Arrays.copyOfRange(array, startRange, stopRange);
    mergeSort(sub_array, 0, sub_array.length - 1);
    System.arraycopy(sub_array, 0, array, startRange, sub_array.length);
  }

  private static void mergeSort(int[] array, int low, int high) {
    // The merge sort is not my code.  https://stackabuse.com/merge-sort-in-java/
    if (high <= low) return;
    int mid = (low + high) / 2;
    mergeSort(array, low, mid);
    mergeSort(array, mid + 1, high);
    merge(array, low, mid, high);
  }

  private static void merge(int[] array, int low, int mid, int high) {
    // Creating temporary sub arrays
    int[] leftArray = new int[mid - low + 1];
    int[] rightArray = new int[high - mid];
    // Copying our sub arrays into temporaries
    System.arraycopy(array, low, leftArray, 0, leftArray.length);
    for (int i = 0; i < rightArray.length; i++) rightArray[i] = array[mid + i + 1];
    // Iterators containing current index of temp sub arrays
    int leftIndex = 0;
    int rightIndex = 0;
    // Copying from leftArray and rightArray back into array
    for (int i = low; i < high + 1; i++) {
      // If there are still un-copied elements in R and L, copy minimum of the two
      if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
        if (leftArray[leftIndex] < rightArray[rightIndex]) {
          array[i] = leftArray[leftIndex];
          leftIndex++;
        } else {
          array[i] = rightArray[rightIndex];
          rightIndex++;
        }
      } else if (leftIndex < leftArray.length) {
        // If all elements have been copied from rightArray, copy rest of leftArray
        array[i] = leftArray[leftIndex];
        leftIndex++;
      } else if (rightIndex < rightArray.length) {
        // If all elements have been copied from leftArray, copy rest of rightArray
        array[i] = rightArray[rightIndex];
        rightIndex++;
      }
    }
  }
}
