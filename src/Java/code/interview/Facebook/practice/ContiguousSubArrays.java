package Java.code.interview.Facebook.practice;

public class ContiguousSubArrays {
  public static void getDescription() {
    System.out.println(
        """
                Contiguous Sub-arrays
                You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous sub-arrays that fulfills the following conditions:
                The value at index i must be the maximum element in the contiguous sub-arrays, and
                These contiguous sub-arrays must either start from or end on index i.
                Signature
                 int[] countSubArrays(int[] arr)
                Input
                 Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
                 Size N is between 1 and 1,000,000
                Output
                 An array where each index i contains an integer denoting the maximum number of contiguous sub-arrays of arr[i]
                Example:
                 arr = [3, 4, 1, 6, 2]
                 output = [1, 3, 1, 5, 1]
                Explanation:
                 For index 0 - [3] is the only contiguous sub-array that starts (or ends) with 3, and the maximum value in this sub-array is 3.
                 For index 1 - [4], [3, 4], [4, 1]
                 For index 2 - [1]
                 For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
                 For index 4 - [2]
                 So, the answer for the above input is [1, 3, 1, 5, 1]"""
            .indent(2));
  }

  public static int[] countSubArrays(int[] arr) {
    int[] returnArray = new int[arr.length];
    for (int outerIndex = 0; outerIndex < arr.length; outerIndex++) {
      int count = 1;
      // left path
      int innerIndex = outerIndex - 1;
      while ((innerIndex >= 0) && (arr[innerIndex] < arr[outerIndex])) {
        innerIndex--;
        count++;
      }
      // right path
      innerIndex = outerIndex + 1;
      while ((innerIndex < arr.length) && (arr[innerIndex] < arr[outerIndex])) {
        innerIndex++;
        count++;
      }
      returnArray[outerIndex] = count;
    }
    return returnArray;
  }
}
