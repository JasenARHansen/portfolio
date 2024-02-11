#ifndef LEETCODE_TOP_INTERVIEW_150_CLIMBING_STAIRS_TEST
#define LEETCODE_TOP_INTERVIEW_150_CLIMBING_STAIRS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/graph_general/NumberOfIslands.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_NumberOfIslandsTest, description) {
    testing::internal::CaptureStdout();
    NumberOfIslands::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_NumberOfIslandsTest, numIslands_1) {
    auto expected = 1;
    vector<vector<char>> grid{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
    };
    auto result = NumberOfIslands::numIslands(grid);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_NumberOfIslandsTest, numIslands_2) {
    auto expected = 3;
    vector<vector<char>> grid{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
    };
    auto result = NumberOfIslands::numIslands(grid);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_NumberOfIslandsTest, numIslands_fail_1) {
    // 1 ≤ grid.length
    auto size = 1 - 1;
    vector<vector<char>> grid(size);
    EXPECT_EXIT(NumberOfIslands::numIslands(grid), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_NumberOfIslandsTest, numIslands_fail_2) {
    // grid.length ≤ 300
    auto size = 300 + 1;
    vector<vector<char>> grid(size);
    EXPECT_EXIT(NumberOfIslands::numIslands(grid), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_NumberOfIslandsTest, numIslands_fail_3) {
    // 1 ≤ grid[i].length
    auto size = 1 - 1;
    vector<vector<char>> grid{vector<char>(size)};
    EXPECT_EXIT(NumberOfIslands::numIslands(grid), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_NumberOfIslandsTest, numIslands_fail_4) {
    // grid[i].length ≤ 300
    auto size = 300 + 1;
    vector<vector<char>> grid{vector<char>(size)};
    EXPECT_EXIT(NumberOfIslands::numIslands(grid), ::testing::ExitedWithCode(3), "");
}

#endif