#ifndef LEETCODE_TOP_INTERVIEW_150_VALID_SUDOKU_TEST
#define LEETCODE_TOP_INTERVIEW_150_VALID_SUDOKU_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/matrix/ValidSudoku.cpp"

TEST(ValidSudokuTest, description) {
    testing::internal::CaptureStdout();
    ValidSudoku::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ValidSudokuTest, isValidSudoku_1) {
    auto expected = true;
    vector<vector<char>> board{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                               {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                               {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                               {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                               {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                               {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                               {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                               {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                               {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    auto result = ValidSudoku::isValidSudoku(board);
    EXPECT_EQ(expected, result);
}

TEST(ValidSudokuTest, isValidSudoku_2) {
    // column 4 is bad
    auto expected = false;
    vector<vector<char>> board{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                               {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                               {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                               {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                               {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                               {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                               {'.', '6', '.', '4', '.', '.', '2', '8', '.'},
                               {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                               {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    auto result = ValidSudoku::isValidSudoku(board);
    EXPECT_EQ(expected, result);
}

TEST(ValidSudokuTest, isValidSudoku_3) {
    // row 4 is bad
    auto expected = false;
    vector<vector<char>> board{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                               {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                               {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                               {'8', '.', '.', '.', '8', '.', '.', '.', '3'},
                               {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                               {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                               {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                               {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                               {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    auto result = ValidSudoku::isValidSudoku(board);
    EXPECT_EQ(expected, result);
}

TEST(ValidSudokuTest, isValidSudoku_4) {
    // matrix[1][1] is bad
    auto expected = false;
    vector<vector<char>> board{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                               {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                               {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                               {'8', '.', '.', '3', '6', '.', '.', '.', '3'},
                               {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                               {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                               {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                               {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                               {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    auto result = ValidSudoku::isValidSudoku(board);
    EXPECT_EQ(expected, result);
}

TEST(ValidSudokuTest, isValidSudoku_fail_1) {
    // board.length == 9
    auto size = 9 - 1;
    vector<vector<char>> board(size);
    EXPECT_EXIT(ValidSudoku::isValidSudoku(board), ::testing::ExitedWithCode(3), "");
}

TEST(ValidSudokuTest, isValidSudoku_fail_2) {
    // board.length == 9
    auto size = 9 + 1;
    vector<vector<char>> board(size);
    EXPECT_EXIT(ValidSudoku::isValidSudoku(board), ::testing::ExitedWithCode(3), "");
}

TEST(ValidSudokuTest, isValidSudoku_fail_3) {
    // board.length == 9
    auto size = 9 - 1;
    vector<vector<char>> board{vector<char>(size)};
    EXPECT_EXIT(ValidSudoku::isValidSudoku(board), ::testing::ExitedWithCode(3), "");
}

TEST(ValidSudokuTest, isValidSudoku_fail_4) {
    // board.length == 9
    auto size = 9 + 1;
    vector<vector<char>> board{vector<char>(size)};
    EXPECT_EXIT(ValidSudoku::isValidSudoku(board), ::testing::ExitedWithCode(3), "");
}

#endif