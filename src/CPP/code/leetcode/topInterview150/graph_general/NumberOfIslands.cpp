#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>

using namespace std;

class NumberOfIslands {

public:

    static void description() {
        cout << R"(200. Number of Islands
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

    Example 1:
        Input: grid = [
          ["1","1","1","1","0"],
          ["1","1","0","1","0"],
          ["1","1","0","0","0"],
          ["0","0","0","0","0"]
        ]
        Output: 1

    Example 2:
        Input: grid = [
          ["1","1","0","0","0"],
          ["1","1","0","0","0"],
          ["0","0","1","0","0"],
          ["0","0","0","1","1"]
        ]
        Output: 3

    Constraints:
        m == grid.length
        n == grid[i].length
        1 <= m, n <= 300
        grid[i][j] is '0' or '1'.)" << endl;
    }

    static int numIslands(vector<vector<char>> &grid) {
        assert (!grid.empty());
        assert (grid.size() <= 300);
        auto result = 0;
        vector<vector<bool>> available;
        auto length = grid[0].size();
        for (const auto row: grid) {
            assert (!row.empty());
            assert (row.size() <= 300);
            assert (row.size() == length);
            available.emplace_back(vector<bool>(row.size(), true));
        }
        for (auto row = 0; row < grid.size(); row++) {
            for (auto column = 0; column < grid[row].size(); column++) {
                if ((available[row][column]) && (grid[row][column] == '1')) {
                    result++;
                    traceIsland(grid, available, row, column);
                }
            }
        }
        return result;
    }

private:

    static void traceIsland(vector<vector<char>> grid, vector<vector<bool>> &available, int row, int column) {
        // Mark current used
        available[row][column] = false;
        // move up
        if ((0 <= (row - 1)) && (available[row - 1][column]) && (grid[row - 1][column] == '1')) {
            traceIsland(grid, available, row - 1, column);
        }
        // move down
        if (((row + 1) < grid.size()) && (available[row + 1][column]) && (grid[row + 1][column] == '1')) {
            traceIsland(grid, available, row + 1, column);
        }
        // move left
        if ((0 <= (column - 1)) && (available[row][column - 1]) && (grid[row][column - 1] == '1')) {
            traceIsland(grid, available, row, column - 1);
        }
        // move right
        if (((column + 1) < grid[row].size()) && (available[row][column + 1]) && (grid[row][column + 1] == '1')) {
            traceIsland(grid, available, row, column + 1);
        }
    }
};

#pragma clang diagnostic pop