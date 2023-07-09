package Java.Code.Educative;

public class DynamicProgrammingCountAllPossiblePaths {
  public static void getDescription() {
    System.out.println(
        """
                A robot is located in the top-left corner of an m x n grid (marked 'Start'
                 in the diagram below).
                The robot can only move either down or right at any point in time.
                The robot is trying to reach the bottom-right corner of the grid (marked
                 'Finish' in the diagram below).
                How many possible unique paths are there?
                Example 1:
                 Input: m = 3, n = 7
                 Output: 28
                Example 2:
                 Input: m = 3, n = 2
                 Output: 3
                Explanation:
                 From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
                 1. Right -> Down -> Down
                 2. Down -> Down -> Right
                 3. Down -> Right -> Down
                Example 3:
                Input: m = 7, n = 3
                Output: 28
                Example 4:
                Input: m = 3, n = 3
                Output: 6
                Constraints:
                  1 <= m, n <= 100
                  It's guaranteed that the answer will be less than or equal to 2   10^9."""
            .indent(2));
  }

  public static int uniquePaths(int m, int n) {
    int[][] matrix = new int[m][n];
    // fill first col and row with 1's
    for (int i = 0; i < m; i++) {
      matrix[i][0] = 1;
    }
    for (int i = 0; i < n; i++) {
      matrix[0][i] = 1;
    }
    // use paths to above cell + baths to left cell to find total paths to cell
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
      }
    }
    return matrix[m - 1][n - 1];
  }
}
