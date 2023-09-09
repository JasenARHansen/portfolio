#ifndef LEETCODE_TOP_INTERVIEW_150_WORD_SEARCH_TEST
#define LEETCODE_TOP_INTERVIEW_150_WORD_SEARCH_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/backtracking/WordSearch.cpp"

TEST(WordSearchTest, description) {
    testing::internal::CaptureStdout();
    WordSearch::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(WordSearchTest, exist_1) {
    auto expected = true;
    vector<vector<char>> board = {{'A', 'B', 'C', 'E'},
                                  {'S', 'F', 'C', 'S'},
                                  {'A', 'D', 'E', 'E'}};
    string word = "ABCCED";
    auto result = WordSearch::exist(board, word);
    EXPECT_EQ(expected, result);
}

TEST(WordSearchTest, exist_2) {
    auto expected = true;
    vector<vector<char>> board = {{'A', 'B', 'C', 'E'},
                                  {'S', 'F', 'C', 'S'},
                                  {'A', 'D', 'E', 'E'}};
    string word = "SEE";
    auto result = WordSearch::exist(board, word);
    EXPECT_EQ(expected, result);
}

TEST(WordSearchTest, exist_3) {
    auto expected = false;
    vector<vector<char>> board = {{'A', 'B', 'C', 'E'},
                                  {'S', 'F', 'C', 'S'},
                                  {'A', 'D', 'E', 'E'}};
    string word = "ABCB";
    auto result = WordSearch::exist(board, word);
    EXPECT_EQ(expected, result);
}

TEST(AddBinaryTest, exist_fail_1) {
    // 1 <= board.length
    auto size = 1 - 1;
    vector<vector<char>> board(size);
    string word = "ABCB";
    EXPECT_EXIT(WordSearch::exist(board, word), ::testing::ExitedWithCode(3), "");
}

TEST(AddBinaryTest, exist_fail_2) {
    // board.length  <= 6
    auto size = 6 + 1;
    vector<vector<char>> board(size);
    string word = "ABCB";
    EXPECT_EXIT(WordSearch::exist(board, word), ::testing::ExitedWithCode(3), "");
}

TEST(AddBinaryTest, exist_fail_3) {
    // 1 <= board[i].length
    auto size = 1 - 1;
    vector<vector<char>> board{vector<char>(size)};
    string word = "ABCB";
    EXPECT_EXIT(WordSearch::exist(board, word), ::testing::ExitedWithCode(3), "");
}

TEST(AddBinaryTest, exist_fail_4) {
    // board[i].length <= 6
    auto size = 6 + 1;
    vector<vector<char>> board{vector<char>(size)};
    string word = "ABCB";
    EXPECT_EXIT(WordSearch::exist(board, word), ::testing::ExitedWithCode(3), "");
}

TEST(AddBinaryTest, exist_fail_5) {
    //  1 <= word.length
    vector<vector<char>> board = {{'A', 'B', 'C', 'E'},
                                  {'S', 'F', 'C', 'S'},
                                  {'A', 'D', 'E', 'E'}};
    auto size = 1 - 1;
    string word(size, ' ');
    EXPECT_EXIT(WordSearch::exist(board, word), ::testing::ExitedWithCode(3), "");
}

TEST(AddBinaryTest, exist_fail_6) {
    //  word.length <= 15
    vector<vector<char>> board = {{'A', 'B', 'C', 'E'},
                                  {'S', 'F', 'C', 'S'},
                                  {'A', 'D', 'E', 'E'}};
    auto size = 15 + 1;
    string word(size, ' ');
    EXPECT_EXIT(WordSearch::exist(board, word), ::testing::ExitedWithCode(3), "");
}

#endif