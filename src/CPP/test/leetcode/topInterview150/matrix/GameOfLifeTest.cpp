#ifndef LEETCODE_TOP_INTERVIEW_150_GAME_OF_LIFE_TEST
#define LEETCODE_TOP_INTERVIEW_150_GAME_OF_LIFE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/matrix/GameOfLife.cpp"  // NOLINT : Ignore .cpp import

TEST(GameOfLifeTest, description) {
    testing::internal::CaptureStdout();
    GameOfLife::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(GameOfLifeTest, gameOfLife_1) {
    vector<vector<int>> expected{{0, 0, 0},
                                 {1, 0, 1},
                                 {0, 1, 1},
                                 {0, 1, 0}};
    vector<vector<int>> board{{0, 1, 0},
                              {0, 0, 1},
                              {1, 1, 1},
                              {0, 0, 0}};
    GameOfLife::gameOfLife(board);
    EXPECT_EQ(expected, board);
}

TEST(GameOfLifeTest, gameOfLife_2) {
    vector<vector<int>> expected{{1, 1},
                                 {1, 1}};
    vector<vector<int>> board{{1, 1},
                              {1, 0}};
    GameOfLife::gameOfLife(board);
    EXPECT_EQ(expected, board);
}

TEST(GameOfLifeTest, gameOfLife_fail_1) {
    // 1 ≤ board.length
    auto size = 1 - 1;
    vector<vector<int>> board(size);
    EXPECT_EXIT(GameOfLife::gameOfLife(board), ::testing::ExitedWithCode(3), "");
}

TEST(GameOfLifeTest, gameOfLife_fail_2) {
    // board.length ≤ 25
    auto size = 25 + 1;
    vector<vector<int>> board(size);
    EXPECT_EXIT(GameOfLife::gameOfLife(board), ::testing::ExitedWithCode(3), "");
}

TEST(GameOfLifeTest, gameOfLife_fail_3) {
    // 1 ≤ board[i].length
    auto size = 1 - 1;
    vector<vector<int>> board{vector<int>(size)};
    EXPECT_EXIT(GameOfLife::gameOfLife(board), ::testing::ExitedWithCode(3), "");
}

TEST(GameOfLifeTest, gameOfLife_fail_4) {
    // board[i].length ≤ 25
    auto size = 25 + 1;
    vector<vector<int>> board{vector<int>(size)};
    EXPECT_EXIT(GameOfLife::gameOfLife(board), ::testing::ExitedWithCode(3), "");
}

#endif