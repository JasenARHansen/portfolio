#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>

using namespace std;

class SurroundedRegions {
public:
    static void description() {
        cout << R"(130. Surrounded Regions
    Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
    A region is captured by flipping all 'O's into 'X's in that surrounded region.

    Example 1:
        Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
        Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
        Explanation:
            Notice that an 'O' should not be flipped if:
            - It is on the border, or
            - It is adjacent to an 'O' that should not be flipped.
            The bottom 'O' is on the border, so it is not flipped.
            The other three 'O' form a surrounded region, so they are flipped.

    Example 2:
        Input: board = [["X"]]
        Output: [["X"]]

    Constraints:
        m == board.length
        n == board[i].length
        1 ≤ m, n ≤ 200
        board[i][j] is 'X' or 'O'.)" << endl;
    }

    static void solve(vector<vector<char>> &board) {
        assert (!board.empty());
        assert (board.size() <= 200);
        vector<vector<int>> possibleFlip;
        auto length = board[0].size();
        for (const auto &row: board) {
            assert (!row.empty());
            assert (row.size() <= 200);
            assert (row.size() == length);
            possibleFlip.emplace_back(row.size(), 0);
        }
        // If it is on the border it can not flip, so edge rows and columns are skipped
        // Check ranges per rows 1 -> size - 2 since the 'O' on the edges can not be changed
        for (auto row = 1; row < board.size() - 1; row++) {
            int startIndex = 0;
            int stopIndex = 0;
            // Find first left 'X' if there is one
            while ((startIndex < board[row].size()) && (board[row][startIndex] != 'X')) {
                startIndex++;
            }
            while ((startIndex < board[row].size() - 1) && (stopIndex < board[row].size())) {
                if (board[row][startIndex + 1] == 'X') {
                    startIndex++;
                } else {
                    // Find right 'X'
                    stopIndex = startIndex + 1;
                    while ((stopIndex < board[row].size()) && (board[row][stopIndex] != 'X')) {
                        stopIndex++;
                    }
                    // Test rage length
                    if ((stopIndex < board[row].size()) && ((stopIndex - startIndex) > 1)) {
                        for (auto i = startIndex + 1; i < startIndex + (stopIndex - startIndex); i++) {
                            possibleFlip[row][i]++;
                        }
                    }
                    startIndex = stopIndex;
                }
            }
        }
        // Check ranges per columns 1 -> size - 2 since the 'O' on the edges can not be changed
        for (auto column = 1; column < board[0].size() - 1; column++) {
            int startIndex = 0;
            int stopIndex = 0;
            // Find first top 'X' if there is one
            while ((startIndex < board.size()) && (board[startIndex][column] != 'X')) {
                startIndex++;
            }
            while ((startIndex < board.size() - 1) && (stopIndex < board.size())) {
                if (board[startIndex + 1][column] == 'X') {
                    startIndex++;
                } else {
                    // Find bottom 'X'
                    stopIndex = startIndex + 1;
                    while ((stopIndex < board.size()) && (board[stopIndex][column] != 'X')) {
                        stopIndex++;
                    }
                    // Test rage length
                    if ((stopIndex < board.size()) && ((stopIndex - startIndex) > 1)) {
                        for (auto i = startIndex + 1; i < startIndex + (stopIndex - startIndex); i++) {
                            possibleFlip[i][column]++;
                        }
                    }
                    startIndex = stopIndex;
                }
            }
        }
        // If a cell with a 'O' is adjacent to an 'O' that should not be flipped, so process 'O' chains
        // From top
        for (auto column = 1; column < board[0].size() - 1; column++) {
            if (board[0][column] == 'O') {
                processChain(board, possibleFlip, 0, column);
            }
        }
        // From bottom
        for (auto column = 1; column < board[board.size() - 1].size() - 1; column++) {
            if (board[board.size() - 1][column] == 'O') {
                processChain(board, possibleFlip, (int) board.size() - 1, column);
            }
        }
        // From left
        for (auto row = 1; row < board.size() - 1; row++) {
            if (board[row][0] == 'O') {
                processChain(board, possibleFlip, row, 0);
            }
        }
        // From right
        for (auto row = 1; row < board.size() - 1; row++) {
            if (board[row][board[row].size() - 1] == 'O') {
                processChain(board, possibleFlip, row, (int) board[row].size() - 1);
            }
        }
        // Flip 'O' that need to be flipped
        for (auto row = 1; row < board.size() - 1; row++) {
            for (auto column = 1; column < board[0].size() - 1; column++) {
                // Check above
                if (possibleFlip[row][column] == 2) {
                    board[row][column] = 'X';
                }
            }
        }
    }

private:
    static void processChain(vector<vector<char>> &board, vector<vector<int>> &possibleFlip, int row, int column) {
        // Check up
        auto offset = row - 1;
        if (0 <= offset) {
            if ((board[offset][column] == 'O') && (possibleFlip[offset][column] != -1)) {
                possibleFlip[offset][column] = -1;
                processChain(board, possibleFlip, offset, column);
            }
        }
        // Check down
        offset = row + 1;
        if (offset < board.size()) {
            if ((board[offset][column] == 'O') && (possibleFlip[offset][column] != -1)) {
                possibleFlip[offset][column] = -1;
                processChain(board, possibleFlip, offset, column);
            }
        }
        // Check left
        offset = column - 1;
        if (0 <= offset) {
            if ((board[row][offset] == 'O') && (possibleFlip[row][offset] != -1)) {
                possibleFlip[row][offset] = -1;
                processChain(board, possibleFlip, row, offset);
            }
        }
        // Check right
        offset = column + 1;
        if (offset < board[row].size()) {
            if ((board[row][offset] == 'O') && (possibleFlip[row][offset] != -1)) {
                possibleFlip[row][offset] = -1;
                processChain(board, possibleFlip, row, offset);
            }
        }
    }
};

#pragma clang diagnostic pop