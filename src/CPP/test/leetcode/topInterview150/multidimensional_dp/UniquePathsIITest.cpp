#ifndef LEETCODE_TOP_INTERVIEW_150_UNIQUE_PATHS_II_TEST
#define LEETCODE_TOP_INTERVIEW_150_UNIQUE_PATHS_II_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/multidimensional_dp/UniquePathsII.cpp"  // NOLINT : Ignore .cpp import

TEST(UniquePathsIITest, description) {
    testing::internal::CaptureStdout();
    UniquePathsII::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(UniquePathsIITest, uniquePathsWithObstacles_1) {
    auto expected = 2;
    vector<vector<int>> obstacleGrid{{0, 0, 0},
                                     {0, 1, 0},
                                     {0, 0, 0}};
    auto result = UniquePathsII::uniquePathsWithObstacles(obstacleGrid);
    EXPECT_EQ(expected, result);
}

TEST(UniquePathsIITest, uniquePathsWithObstacles_2) {
    auto expected = 1;
    vector<vector<int>> obstacleGrid{{0, 1},
                                     {0, 0}};
    auto result = UniquePathsII::uniquePathsWithObstacles(obstacleGrid);
    EXPECT_EQ(expected, result);
}

TEST(UniquePathsIITest, uniquePathsWithObstacles_3) {
    auto expected = 0;
    vector<vector<int>> obstacleGrid{{1}};
    auto result = UniquePathsII::uniquePathsWithObstacles(obstacleGrid);
    EXPECT_EQ(expected, result);
}

TEST(UniquePathsIITest, uniquePathsWithObstacles_4) {
    auto expected = 0;
    vector<vector<int>> obstacleGrid{{1, 0}};
    auto result = UniquePathsII::uniquePathsWithObstacles(obstacleGrid);
    EXPECT_EQ(expected, result);
}

TEST(UniquePathsIITest, uniquePathsWithObstacles_5) {
    auto expected = 0;
    vector<vector<int>> obstacleGrid{{1},
                                     {0}};
    auto result = UniquePathsII::uniquePathsWithObstacles(obstacleGrid);
    EXPECT_EQ(expected, result);
}

TEST(UniquePathsIITest, uniquePathsWithObstacles_fail_1) {
    // 1 ≤ obstacleGrid.length
    auto size = 1 - 1;
    vector<vector<int>> obstacleGrid(size);
    EXPECT_EXIT(UniquePathsII::uniquePathsWithObstacles(obstacleGrid), ::testing::ExitedWithCode(3), "");
}

TEST(UniquePathsIITest, uniquePathsWithObstacles_fail_2) {
    // obstacleGrid.length ≤ 100
    auto size = 100 + 1;
    vector<vector<int>> obstacleGrid(size);
    EXPECT_EXIT(UniquePathsII::uniquePathsWithObstacles(obstacleGrid), ::testing::ExitedWithCode(3), "");
}

TEST(UniquePathsIITest, uniquePathsWithObstacles_fail_3) {
    // 1 ≤ obstacleGrid[0].length
    auto size = 1 - 1;
    vector<vector<int>> obstacleGrid{vector<int>(size)};
    EXPECT_EXIT(UniquePathsII::uniquePathsWithObstacles(obstacleGrid), ::testing::ExitedWithCode(3), "");
}

TEST(UniquePathsIITest, uniquePathsWithObstacles_fail_4) {
    // obstacleGrid[0].length< = 100
    auto size = 100 + 1;
    vector<vector<int>> obstacleGrid{vector<int>(size)};
    EXPECT_EXIT(UniquePathsII::uniquePathsWithObstacles(obstacleGrid), ::testing::ExitedWithCode(3), "");
}

TEST(UniquePathsIITest, uniquePathsWithObstacles_fail_5) {
    // obstacleGrid[i].length == obstacleGrid[i + 1].length
    auto size = 1;
    vector<vector<int>> obstacleGrid{vector<int>(size), vector<int>(size + 2)};
    EXPECT_EXIT(UniquePathsII::uniquePathsWithObstacles(obstacleGrid), ::testing::ExitedWithCode(3), "");
}

#endif