#pragma clang diagnostic push
#pragma ide diagnostic ignored "bugprone-branch-clone"
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#pragma ide diagnostic ignored "OCInconsistentNamingInspection"

#include <iostream>
#include <vector>
#include <cassert>
#include <bitset>

using namespace std;

class ValidSudoku {
public:

    static void description() {
        cout << R"(36. Valid Sudoku
    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
        Each row must contain the digits 1-9 without repetition.
        Each column must contain the digits 1-9 without repetition.
        Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    Note:
        A Sudoku board (partially filled) could be valid but is not necessarily solvable.
        Only the filled cells need to be validated according to the mentioned rules.

    Example 1:
        Input: board =
        [["5","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]
        Output: true

    Example 2:
        Input: board =
        [["8","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]
        Output: false
        Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

    Constraints:
        board.length == 9
        board[i].length == 9
        board[i][j] is a digit 1-9 or '.'.)" << endl;
    }

    static bool isValidSudoku(vector<vector<char>> &board) {
        assert (board.size() == 9);
        bitset<256> numbers;
        char current;
        // validate rows
        for (int row = 0; row < 9; row++) {
            assert (board[row].size() == 9);
            numbers.reset();
            for (int column = 0; column < 9; column++) {
                current = board[row][column];
                assert (isdigit(current) || current == '.');
                if (isdigit(current)) {
                    int value = current - '0';
                    if (numbers.test(value)) {
                        return false;
                    }
                    numbers.flip(value);
                }
            }
        }
        // validate columns
        for (int column = 0; column < 9; column++) {
            numbers.reset();
            for (int row = 0; row < 9; row++) {
                current = board[row][column];
                if (isdigit(current)) {
                    int value = current - '0';
                    if (numbers.test(value)) {
                        return false;
                    }
                    numbers.flip(value);
                }
            }
        }
        // validate squares
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                numbers.reset();
                for (int row = 0; row < 3; row++) {
                    for (int column = 0; column < 3; column++) {
                        current = board[3 * x + row][3 * y + column];
                        if (isdigit(current)) {
                            int value = current - '0';
                            if (numbers.test(value)) {
                                return false;
                            }
                            numbers.flip(value);

                        }
                    }
                }
            }
        }
        return true;
    }
};

#pragma clang diagnostic pop