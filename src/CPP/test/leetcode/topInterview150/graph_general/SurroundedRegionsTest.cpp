#ifndef LEETCODE_TOP_INTERVIEW_150_SURROUNDED_REGIONS_TEST
#define LEETCODE_TOP_INTERVIEW_150_SURROUNDED_REGIONS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/graph_general/SurroundedRegions.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_SurroundedRegionsTest, description) {
    testing::internal::CaptureStdout();
    SurroundedRegions::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_SurroundedRegionsTest, solve_1) {
    vector<vector<char>> expected{{'X', 'X', 'X', 'X'},
                                  {'X', 'X', 'X', 'X'},
                                  {'X', 'X', 'X', 'X'},
                                  {'X', 'O', 'X', 'X'}};
    vector<vector<char>> board{{'X', 'X', 'X', 'X'},
                               {'X', 'O', 'O', 'X'},
                               {'X', 'X', 'O', 'X'},
                               {'X', 'O', 'X', 'X'}};
    SurroundedRegions::solve(board);
    for (auto index = 0; index < board.size(); index++) {
        EXPECT_EQ(string(expected[index].begin(), expected[index].end()),
                  string(board[index].begin(), board[index].end()));
    }
}

TEST(LeetCode_SurroundedRegionsTest, solve_2) {
    vector<vector<char>> expected{{'X'}};
    vector<vector<char>> board{{'X'}};
    SurroundedRegions::solve(board);
    for (auto index = 0; index < board.size(); index++) {
        EXPECT_EQ(string(expected[index].begin(), expected[index].end()),
                  string(board[index].begin(), board[index].end()));
    }
}

TEST(LeetCode_SurroundedRegionsTest, solve_3) {
    vector<vector<char>> expected{{'O', 'X', 'X', 'O', 'X'},
                                  {'X', 'X', 'X', 'X', 'O'},
                                  {'X', 'X', 'X', 'O', 'X'},
                                  {'O', 'X', 'O', 'O', 'O'},
                                  {'X', 'X', 'O', 'X', 'O'}};
    vector<vector<char>> board{{'O', 'X', 'X', 'O', 'X'},
                               {'X', 'O', 'O', 'X', 'O'},
                               {'X', 'O', 'X', 'O', 'X'},
                               {'O', 'X', 'O', 'O', 'O'},
                               {'X', 'X', 'O', 'X', 'O'}};
    SurroundedRegions::solve(board);
    for (auto index = 0; index < board.size(); index++) {
        EXPECT_EQ(string(expected[index].begin(), expected[index].end()),
                  string(board[index].begin(), board[index].end()));
    }
}

TEST(LeetCode_SurroundedRegionsTest, solve_4) {
    vector<vector<char>> expected{{'X', 'X', 'X', 'X', 'X'},
                                  {'X', 'X', 'X', 'X', 'X'},
                                  {'X', 'X', 'X', 'X', 'X'},
                                  {'X', 'X', 'X', 'X', 'X'},
                                  {'X', 'O', 'X', 'X', 'X'}};
    vector<vector<char>> board{{'X', 'X', 'X', 'X', 'X'},
                               {'X', 'O', 'O', 'O', 'X'},
                               {'X', 'X', 'O', 'O', 'X'},
                               {'X', 'X', 'X', 'O', 'X'},
                               {'X', 'O', 'X', 'X', 'X'}};
    SurroundedRegions::solve(board);
    for (auto index = 0; index < board.size(); index++) {
        EXPECT_EQ(string(expected[index].begin(), expected[index].end()),
                  string(board[index].begin(), board[index].end()));
    }
}

TEST(LeetCode_SurroundedRegionsTest, solve_5) {
    vector<vector<char>> expected{{'O', 'X', 'O', 'O', 'X', 'X'},
                                  {'O', 'X', 'X', 'X', 'O', 'X'},
                                  {'X', 'O', 'O', 'X', 'O', 'O'},
                                  {'X', 'O', 'X', 'X', 'X', 'X'},
                                  {'O', 'O', 'X', 'O', 'X', 'X'},
                                  {'X', 'X', 'O', 'O', 'O', 'O'}};
    vector<vector<char>> board{{'O', 'X', 'O', 'O', 'X', 'X'},
                               {'O', 'X', 'X', 'X', 'O', 'X'},
                               {'X', 'O', 'O', 'X', 'O', 'O'},
                               {'X', 'O', 'X', 'X', 'X', 'X'},
                               {'O', 'O', 'X', 'O', 'X', 'X'},
                               {'X', 'X', 'O', 'O', 'O', 'O'}};
    SurroundedRegions::solve(board);
    for (auto index = 0; index < board.size(); index++) {
        EXPECT_EQ(string(expected[index].begin(), expected[index].end()),
                  string(board[index].begin(), board[index].end()));
    }
}

TEST(LeetCode_SurroundedRegionsTest, solve_6) {
    vector<vector<char>> expected{{'X', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'O'},
                                  {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X'},
                                  {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X'},
                                  {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X'},
                                  {'O', 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'O'},
                                  {'X', 'O', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'O'},
                                  {'X', 'O', 'X', 'X', 'X', 'X', 'X', 'O', 'X', 'O'},
                                  {'X', 'X', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'X'},
                                  {'O', 'O', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'O'},
                                  {'X', 'X', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O'}};
    vector<vector<char>> board{{'X', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'X', 'O'},
                               {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'O', 'O', 'X'},
                               {'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X'},
                               {'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X'},
                               {'O', 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'O'},
                               {'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'O'},
                               {'X', 'O', 'X', 'O', 'O', 'X', 'X', 'O', 'X', 'O'},
                               {'X', 'X', 'O', 'X', 'X', 'O', 'X', 'O', 'O', 'X'},
                               {'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'X', 'O'},
                               {'X', 'X', 'O', 'X', 'X', 'X', 'X', 'O', 'O', 'O'}};
    SurroundedRegions::solve(board);
    for (auto index = 0; index < board.size(); index++) {
        EXPECT_EQ(string(expected[index].begin(), expected[index].end()),
                  string(board[index].begin(), board[index].end()));
    }
}

TEST(LeetCode_SurroundedRegionsTest, solve_fail_1) {
    // 1 ≤ board.length
    auto size = 1 - 1;
    vector<vector<char>> board(size);
    EXPECT_EXIT(SurroundedRegions::solve(board), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_SurroundedRegionsTest, solve_fail_2) {
    // board.length ≤ 200
    auto size = 200 + 1;
    vector<vector<char>> board(size);
    EXPECT_EXIT(SurroundedRegions::solve(board), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_SurroundedRegionsTest, solve_fail_3) {
    // 1 ≤ board{i].length
    auto size = 1 - 1;
    vector<vector<char>> board{vector<char>(size)};
    EXPECT_EXIT(SurroundedRegions::solve(board), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_SurroundedRegionsTest, solve_fail_4) {
    // board{i].length ≤ 200
    auto size = 200 + 1;
    vector<vector<char>> board{vector<char>(size)};
    EXPECT_EXIT(SurroundedRegions::solve(board), ::testing::ExitedWithCode(3), "");
}

#endif