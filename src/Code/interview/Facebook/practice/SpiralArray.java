package Code.interview.Facebook.practice;

public class SpiralArray {
  /*
  Question 1: 2D Spiral Array
  Find the pattern and complete the function:
  int[][] spiral(int n);
  where n is the size of the 2D array.
  input = 3
  123
  894
  765

  input = 4
  01 02 03 04
  12 13 14 05
  11 16 15 06
  10 09 08 07

  input = 8
  1 2 3 4 5 6 7 8
  28 29 30 31 32 33 34 9
  27 48 49 50 51 52 35 10
  26 47 60 61 62 53 36 11
  25 46 59 64 63 54 37 12
  24 45 58 57 56 55 38 13
  23 44 43 42 41 40 39 14
  22 21 20 19 18 17 16 15
  */

    public static int[][] genSpiral(int n) {
        int[][] spiral = new int[n][n];
        int count = 1;
        for (int shell = 0; shell < (n + 1) / 2; shell++) {
            // Top
            for (int x = 0; x < n - 2 * shell; x++) {
                spiral[0 + shell][x + shell] = count;
                count++;
            }
            // Right Side
            for (int y = 0; y < n - 2 * shell - 1; y++) {
                spiral[y + shell + 1][n - shell - 1] = count;
                count++;
            }
            // Bottom
            for (int x = 0; x < n - 2 * shell - 1; x++) {
                spiral[n - shell - 1][n - (x + shell) - 2] = count;
                count++;
            }
            // Left Side
            for (int y = 0; y < n - 2 * (shell + 1); y++) {
                spiral[n - 2 - y - shell][shell] = count;
                count++;
            }
        }
        return spiral;
    }

    public static void printSpiral(int[][] spiral) {
        for (int row = 0; row < spiral.length; row++) {
            for (int col = 0; col < spiral.length; col++) {
                System.out.printf("%5d", spiral[row][col]);
            }
            System.out.printf("\n");
        }
    }
}
