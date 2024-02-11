#ifndef LEETCODE_TOP_INTERVIEW_150_MINIMUM_NUMBER_OF_ARROWS_TO_BURST_BALLOONS_TEST
#define LEETCODE_TOP_INTERVIEW_150_MINIMUM_NUMBER_OF_ARROWS_TO_BURST_BALLOONS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/intervals/MinimumNumberOfArrowsToBurstBalloons.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_MinimumNumberOfArrowsToBurstBalloonsTest, description) {
    testing::internal::CaptureStdout();
    MinimumNumberOfArrowsToBurstBalloons::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_MinimumNumberOfArrowsToBurstBalloonsTest, findMinArrowShots_1) {
    auto expected = 2;
    vector<vector<int>> points{{10, 16},
                               {2,  8},
                               {1,  6},
                               {7,  12}};
    auto result = MinimumNumberOfArrowsToBurstBalloons::findMinArrowShots(points);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_MinimumNumberOfArrowsToBurstBalloonsTest, findMinArrowShots_2) {
    auto expected = 4;
    vector<vector<int>> points{{1, 2},
                               {3, 4},
                               {5, 6},
                               {7, 8}};
    auto result = MinimumNumberOfArrowsToBurstBalloons::findMinArrowShots(points);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_MinimumNumberOfArrowsToBurstBalloonsTest, findMinArrowShots_3) {
    auto expected = 2;
    vector<vector<int>> points{{1, 2},
                               {2, 3},
                               {3, 4},
                               {4, 5}};
    auto result = MinimumNumberOfArrowsToBurstBalloons::findMinArrowShots(points);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_MinimumNumberOfArrowsToBurstBalloonsTest, findMinArrowShots_4) {
    auto expected = 2;
    vector<vector<int>> points{{9, 12},
                               {1, 10},
                               {4, 11},
                               {8, 12},
                               {3, 9},
                               {6, 9},
                               {6, 7}};
    auto result = MinimumNumberOfArrowsToBurstBalloons::findMinArrowShots(points);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_MinimumNumberOfArrowsToBurstBalloonsTest, findMinArrowShots_fail_1) {
    // 1 ≤ points.length
    auto size = 1 - 1;
    vector<vector<int>> points(size);
    EXPECT_EXIT(MinimumNumberOfArrowsToBurstBalloons::findMinArrowShots(points), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_MinimumNumberOfArrowsToBurstBalloonsTest, findMinArrowShots_fail_2) {
    // points.length ≤ 10^5
    auto size = (int) pow(10, 5) + 1;
    vector<vector<int>> points(size);
    EXPECT_EXIT(MinimumNumberOfArrowsToBurstBalloons::findMinArrowShots(points), ::testing::ExitedWithCode(3), "");
}

#endif