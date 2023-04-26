package Java.Code.Interview.Facebook.Practice;

public class ShiftZeros {
  /*
  Given an array of integers, move all non-zero values to the left and return the
  number of non-zero elements.

  Input #1: int[]
  Output:   int

  int removeZeros(int[] array);

  ----------
  Example #1
  ----------
  Input #1: [1, 0, 2, 0, 0, 3, 4]
  Output:   4
  Input #1: [4, 1, 3, 2, 0, 0, 0]
  */

  public static int removeZeros(int[] array) {
    int leftIndex = 0;
    int rightIndex = array.length - 1;

    while (leftIndex < rightIndex) {
      while (array[leftIndex] == 0) {
        if (array[rightIndex] != 0) {
          array[leftIndex] = array[rightIndex];
          array[rightIndex] = 0;
        }
        rightIndex--;
      }
      leftIndex++;
    }
    return leftIndex;
  }
}
