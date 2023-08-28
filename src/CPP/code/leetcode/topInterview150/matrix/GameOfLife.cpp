#pragma clang diagnostic push
#pragma ide diagnostic ignored "hicpp-multiway-paths-covered"
#pragma ide diagnostic ignored "bugprone-branch-clone"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <cassert>

using namespace std;

class GameOfLife {
public:

    static void description() {
        cout << R"(289. Game of Life
    According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
    The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
        Any live cell with fewer than two live neighbors dies as if caused by under-population.
        Any live cell with two or three live neighbors lives on to the next generation.
        Any live cell with more than three live neighbors dies, as if by over-population.
        Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

    Example 1:
        Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
        Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]

    Example 2:
        Input: board = [[1,1],[1,0]]
        Output: [[1,1],[1,1]]

    Constraints:
        m == board.length
        n == board[i].length
        1 <= m, n <= 25
        board[i][j] is 0 or 1.

    Follow up:
        Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
        In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?)"
             << endl;
    }

    static void gameOfLife(vector<vector<int>> &board) {
        assert (!board.empty());
        assert (board.size() <= 25);
        vector<vector<bool>> test;
        int size = board[0].size();
        for (const auto &i: board) {
            assert (!i.empty());
            assert (i.size() == size);
            assert (i.size() <= 25);
            test.emplace_back(size, false);
        }
        int liveCount;
        for (int row = 0; row < board.size(); row++) {
            for (int column = 0; column < board[row].size(); column++) {
                liveCount = 0;
                if ((row > 0) && (column > 0) && (board[row - 1][column - 1])) {
                    liveCount++;
                }
                if ((row > 0) && (board[row - 1][column])) {
                    liveCount++;
                }
                if ((row > 0) && (column < board[row].size() - 1) && (board[row - 1][column + 1])) {
                    liveCount++;
                }
                if ((column > 0) && (board[row][column - 1])) {
                    liveCount++;
                }
                if ((column < board[row].size() - 1) && (board[row][column + 1])) {
                    liveCount++;
                }
                if ((row < board.size() - 1) && (column > 0) && (board[row + 1][column - 1])) {
                    liveCount++;
                }
                if ((row < board.size() - 1) && (board[row + 1][column])) {
                    liveCount++;
                }
                if ((row < board.size() - 1) && (column < board[row].size() - 1) &&
                    (board[row + 1][column + 1])) {
                    liveCount++;
                }
                // Any live cell with fewer than two live neighbors dies as if caused by under-population.
                // Any live cell with two or three live neighbors lives on to the next generation.
                // Any live cell with more than three live neighbors dies, as if by over-population.
                // Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
                switch (liveCount) {
                    case 0:
                    case 1:
                        if (board[row][column]) {
                            test[row][column] = true;
                        }
                        break;
                    case 2:
                    case 3:
                        if ((liveCount == 3) && (!board[row][column])) {
                            test[row][column] = true;
                        }
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        if (board[row][column]) {
                            test[row][column] = true;
                        }
                        break;
                }
            }
        }
        for (int row = 0; row < board.size(); row++) {
            for (int column = 0; column < board[row].size(); column++) {
                if (test[row][column]) {
                    board[row][column] = !board[row][column];
                }
            }
        }
    }
};

#pragma clang diagnostic pop