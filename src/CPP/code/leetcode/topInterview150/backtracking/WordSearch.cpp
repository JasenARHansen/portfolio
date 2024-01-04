#pragma clang diagnostic push
#pragma ide diagnostic ignored "misc-no-recursion"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <cassert>
#include <vector>

using namespace std;

class WordSearch {
public:
    static void description() {
        cout << R"(79: Word Search
    Given an m x n grid of characters board and a string word, return true if word exists in the grid.
    The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are
     horizontally or vertically neighboring.
    The same letter cell may not be used more than once.
    Example 1:
        Input: board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word = "ABCCED"
        Output: true
    Example 2:
        Input: board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word = "SEE"
        Output: true
    Example 3:
        Input: board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], word = "ABCB"
        Output: false
    Constraints:
        m == board.length
        n = board[i].length
        1 ≤ m, n ≤ 6
        1 ≤ word.length ≤ 15
        board and word consists of only lowercase and uppercase English letters.
    Follow up:
        Could you use search pruning to make your solution faster with a larger board?)" << endl;
    }

    static bool exist(vector<vector<char>> &board, string word) {
        assert(!word.empty());
        assert(word.size() <= 15);
        assert(!board.empty());
        assert(board.size() <= 6);
        vector<vector<bool>> available;
        auto length = (int) board[0].size();
        for (const auto &row: board) {
            assert (!row.empty());
            assert (row.size() <= 6);
            assert (row.size() == length);
            available.emplace_back(row.size(), true);
        }
        bool result;
        for (auto boardRow = 0; boardRow < board.size(); boardRow++) {
            for (auto boardColumn = 0; boardColumn < board[boardRow].size(); boardColumn++) {
                if (board[boardRow][boardColumn] == word.at(0)) {
                    available[boardRow][boardColumn] = false;
                    result = exist(board, boardRow, boardColumn, word, 1, available);
                    if (result) {
                        return result;
                    }
                    available[boardRow][boardColumn] = true;
                }
            }
        }
        return false;
    }

private:
    static bool exist(vector<vector<char>> &board, int boardRow, int boardColumn, string word, int wordIndex,
                      vector<vector<bool>> &available) {
        if (wordIndex == word.size()) {
            return true;
        }
        // check up
        auto offset = boardRow - 1;
        if ((0 <= offset) && (board[offset][boardColumn] == word.at(wordIndex)) &&
            (available[offset][boardColumn])) {
            available[offset][boardColumn] = false;
            if (exist(board, offset, boardColumn, word, wordIndex + 1, available)) {
                return true;
            }
            available[offset][boardColumn] = true;
        }
        // check down
        offset = boardRow + 1;
        if ((offset < board.size()) && (board[offset][boardColumn] == word.at(wordIndex)) &&
            (available[offset][boardColumn])) {
            available[offset][boardColumn] = false;
            if (exist(board, offset, boardColumn, word, wordIndex + 1, available)) {
                return true;
            }
            available[offset][boardColumn] = true;
        }
        // check left
        offset = boardColumn - 1;
        if ((0 <= offset) && (board[boardRow][offset] == word.at(wordIndex)) &&
            (available[boardRow][offset])) {
            available[boardRow][offset] = false;
            if (exist(board, boardRow, offset, word, wordIndex + 1, available)) {
                return true;
            }
            available[boardRow][offset] = true;
        }
        // check right
        offset = boardColumn + 1;
        if ((offset < board[boardRow].size()) && (board[boardRow][offset] == word.at(wordIndex)) &&
            (available[boardRow][offset])) {
            available[boardRow][offset] = false;
            if (exist(board, boardRow, offset, word, wordIndex + 1, available)) {
                return true;
            }
            available[boardRow][offset] = true;
        }
        // not found
        return false;
    }
};

#pragma clang diagnostic pop