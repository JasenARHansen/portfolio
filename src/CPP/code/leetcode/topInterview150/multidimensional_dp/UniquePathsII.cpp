#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>

using namespace std;

class UniquePathsII {

public:

    static void description() {
        cout << R"(63. Unique Paths II
    You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
    An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
    Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
    The testcases are generated so that the answer will be less than or equal to 2 * 10^9.

    Example 1:
        Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
        Output: 2
        Explanation:
            There is one obstacle in the middle of the 3x3 grid above.
            There are two ways to reach the bottom-right corner:
            1. Right -> Right -> Down -> Down
            2. Down -> Down -> Right -> Right

    Example 2:
        Input: obstacleGrid = [[0,1],[0,0]]
        Output: 1

    Constraints:
        m == obstacleGrid.length
        n == obstacleGrid[i].length
        1 ≤ m, n ≤ 100
        obstacleGrid[i][j] is 0 or 1.)" << endl;
    }

    static int uniquePathsWithObstacles(vector<vector<int>> &obstacleGrid) {
        assert (!obstacleGrid.empty());
        assert (obstacleGrid.size() <= 100);
        auto n = obstacleGrid[0].size();
        vector<vector<int>> testGrid;
        for (const auto &row: obstacleGrid) {
            assert (!row.empty());
            assert (row.size() <= 100);
            assert (n == row.size());
            testGrid.emplace_back(n, -1);
        }
        if (obstacleGrid[0][0]) {
            return 0;
        }
        return uniquePathsWithObstacles(obstacleGrid, 0, 0, testGrid);
    }

private:

    static int
    uniquePathsWithObstacles(const vector<vector<int>> &obstacleGrid, int row, int column,
                             vector<vector<int>> &testGrid) {
        assert (0 <= obstacleGrid[row][column]);
        assert (obstacleGrid[row][column] <= 200);
        if (testGrid[row][column] < 0) {
            // end point reached
            auto down = 0;
            auto right = 0;
            if ((obstacleGrid.size() - 1 == row) && (obstacleGrid[row].size() - 1 == column)) {
                if (!obstacleGrid[row][column]) {
                    // using an arbitrary variable for storage
                    right = 1;
                }
            }
                // row end point reached
            else if (obstacleGrid.size() - 1 == row) {
                if (!obstacleGrid[row][column + 1]) {
                    right = uniquePathsWithObstacles(obstacleGrid, row, column + 1, testGrid) +
                            obstacleGrid[row][column];
                }
            }
                // column end point reached
            else if (obstacleGrid[row].size() - 1 == column) {
                if (!obstacleGrid[row + 1][column]) {
                    down = uniquePathsWithObstacles(obstacleGrid, row + 1, column, testGrid) +
                           obstacleGrid[row][column];
                }
            }
                // compare the 2 paths:  go down 1 row, go down 1 column
            else {
                if (!obstacleGrid[row][column + 1]) {
                    right = uniquePathsWithObstacles(obstacleGrid, row, column + 1, testGrid);
                }
                if (!obstacleGrid[row + 1][column]) {
                    down = uniquePathsWithObstacles(obstacleGrid, row + 1, column, testGrid);
                }
            }
            testGrid[row][column] = right + down;
        }
        return testGrid[row][column];
    }
};

#pragma clang diagnostic pop