package Java.Code.Educative;

public class MatrixRotate {
  /*
  You are given an n x n 2D matrix representing an image.
  Rotate the image by 90 degrees (clockwise).
  You need to do this in place.
  Note that if you end up using an additional array, you will only receive partial score.

  Example:
  If the array is
  [
      [1, 2],
      [3, 4]
  ]
  Then the rotated array becomes:
  [
      [3, 1],
      [4, 2]
  ]
    */
  public static void rotateMatrix_square(int[][] array) {
    int storage;
    for (int shell = 0; shell < (array.length + 1) / 2; shell++) {
      // Top
      for (int space = 0; space < array.length - 2 * shell - 1; space++) {
        // Top -> Storage : 1 -> S
        storage = array[shell][space + shell];
        // Left -> Top : 4 -> 1
        array[shell][space + shell] = array[array.length - 1 - shell - space][shell];
        // Bottom -> Left : 3 -> 4
        array[array.length - 1 - shell - space][shell] =
                array[array.length - 1 - shell][array.length - 1 - shell - space];
        // Right --> Bottom : 2 -> 3
        array[array.length - 1 - shell][array.length - 1 - shell - space] =
                array[shell + space][array.length - 1 - shell];
        // Storage -> Right : S -> 2
        array[shell + space][array.length - 1 - shell] = storage;
      }
    }
  }

  public static int[][] rotateMatrix_rectangle(int[][] array) {
    int[][] returnArray = new int[array[0].length][array.length];
    for (int row = 0; row < array.length; row++) {
      for (int col = 0; col < array[0].length; col++) {
        returnArray[col][array.length - 1 - row] = array[row][col];
      }
    }
    return returnArray;
  }

  public static void printArray(int[][] array) {
    for (int[] ints : array) {
      for (int col = 0; col < array[0].length; col++) {
        System.out.printf("%5d", ints[col]);
      }
      System.out.print("\n");
    }
  }
}
