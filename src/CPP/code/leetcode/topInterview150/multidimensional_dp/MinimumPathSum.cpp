#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <cmath>
#include <vector>

using namespace std;

class MinimumPathSum {
public:
    static void description() {
        cout << R"(64. Minimum Path Sum
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
    Note: You can only move either down or right at any point in time.

    Example 1:
        Input: grid = [[1, 3, 1], [1, 5, 1], [4, 2, 1]]
        Output: 7
        Explanation:
            Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

    Example 2:
        Input: grid = [[1, 2, 3], [4, 5, 6]]
        Output: 12

    Constraints:
        m == grid.length
        n == grid[i].length
        1 ≤ m, n ≤ 200
        0 ≤ grid[i][j] ≤ 200)" << endl;
    }

    static int minPathSum(const vector<vector<int>> &grid) {
        assert (!grid.empty());
        assert (grid.size() <= 200);
        auto n = grid[0].size();
        vector<vector<int>> testGrid;
        for (const auto &row: grid) {
            assert (!row.empty());
            assert (row.size() <= 200);
            assert (n == row.size());
            testGrid.emplace_back(n, -1);
        }
        return minPathSum(grid, 0, 0, testGrid);
    }

private:
    static int minPathSum(const vector<vector<int>> &grid, int row, int column, vector<vector<int>> &testGrid) {
        assert (0 <= grid[row][column]);
        assert (grid[row][column] <= 200);
        if (testGrid[row][column] < 0) {
            // end point reached
            if ((grid.size() - 1 == row) && (grid[row].size() - 1 == column)) {
                testGrid[row][column] = grid[row][column];
            }
                // row end point reached
            else if (grid.size() - 1 == row) {
                testGrid[row][column] = minPathSum(grid, row, column + 1, testGrid) + grid[row][column];
            }
                // column end point reached
            else if (grid[row].size() - 1 == column) {
                testGrid[row][column] = minPathSum(grid, row + 1, column, testGrid) + grid[row][column];
            }
                // compare the 2 paths:  go down 1 row, go down 1 column
            else {
                auto right = minPathSum(grid, row, column + 1, testGrid);
                auto down = minPathSum(grid, row + 1, column, testGrid);
                testGrid[row][column] = min(right, down) + grid[row][column];
            }
        }
        return testGrid[row][column];
    }
};

#pragma clang diagnostic pop