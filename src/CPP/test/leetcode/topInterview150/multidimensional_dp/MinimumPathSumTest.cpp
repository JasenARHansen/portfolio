#ifndef LEETCODE_TOP_INTERVIEW_150_MINIMUM_PATH_SUM_TEST
#define LEETCODE_TOP_INTERVIEW_150_MINIMUM_PATH_SUM_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/multidimensional_dp/MinimumPathSum.cpp"

TEST(MinimumPathSumTest, description) {
    testing::internal::CaptureStdout();
    MinimumPathSum::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MinimumPathSumTest, minPathSum_1) {
    auto expected = 7;
    vector<vector<int>> grid{{1, 3, 1},
                             {1, 5, 1},
                             {4, 2, 1}};
    auto result = MinimumPathSum::minPathSum(grid);
    EXPECT_EQ(expected, result);
}

TEST(MinimumPathSumTest, minPathSum_2) {
    auto expected = 12;
    vector<vector<int>> grid{{1, 2, 3},
                             {4, 5, 6}};
    auto result = MinimumPathSum::minPathSum(grid);
    EXPECT_EQ(expected, result);
}

TEST(MinimumPathSumTest, minPathSum_fail_1) {
    // 1 ≤ grid.length
    auto size = 1 - 1;
    vector<vector<int>> grid(size);
    EXPECT_EXIT(MinimumPathSum::minPathSum(grid), ::testing::ExitedWithCode(3), "");
}

TEST(MinimumPathSumTest, minPathSum_fail_2) {
    // grid.length ≤ 200
    auto size = 200 + 1;
    vector<vector<int>> grid(size);
    EXPECT_EXIT(MinimumPathSum::minPathSum(grid), ::testing::ExitedWithCode(3), "");
}

TEST(MinimumPathSumTest, minPathSum_fail_3) {
    // 1 ≤ grid[0].length
    auto size = 1 - 1;
    vector<vector<int>> grid{vector<int>(size)};
    EXPECT_EXIT(MinimumPathSum::minPathSum(grid), ::testing::ExitedWithCode(3), "");
}

TEST(MinimumPathSumTest, minPathSum_fail_4) {
    // grid[0].length< = 200
    auto size = 200 + 1;
    vector<vector<int>> grid{vector<int>(size)};
    EXPECT_EXIT(MinimumPathSum::minPathSum(grid), ::testing::ExitedWithCode(3), "");
}

TEST(MinimumPathSumTest, minPathSum_fail_5) {
    // grid[i].length == grid[i + 1].length
    auto size = 1;
    vector<vector<int>> grid{vector<int>(size), vector<int>(size + 2)};
    EXPECT_EXIT(MinimumPathSum::minPathSum(grid), ::testing::ExitedWithCode(3), "");
}

TEST(MinimumPathSumTest, minPathSum_fail_6) {
    // 0 ≤ grid[i][j]
    auto size = 0 - 1;
    vector<vector<int>> grid{{size}};
    EXPECT_EXIT(MinimumPathSum::minPathSum(grid), ::testing::ExitedWithCode(3), "");
}

TEST(MinimumPathSumTest, minPathSum_fail_7) {
    // grid[i][j] ≤ 200
    auto size = 200 + 1;
    vector<vector<int>> grid{{size}};
    EXPECT_EXIT(MinimumPathSum::minPathSum(grid), ::testing::ExitedWithCode(3), "");
}

#endif