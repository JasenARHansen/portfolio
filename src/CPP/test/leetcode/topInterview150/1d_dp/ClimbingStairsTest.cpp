#ifndef LEETCODE_TOP_INTERVIEW_150_CLIMBING_STAIRS_TEST
#define LEETCODE_TOP_INTERVIEW_150_CLIMBING_STAIRS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/1d_dp/ClimbingStairs.cpp"  // NOLINT : Ignore .cpp import

TEST(ClimbingStairsTest, description) {
    testing::internal::CaptureStdout();
    ClimbingStairs::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ClimbingStairsTest, climbStairs_1) {
    auto expected = 2;
    auto n = 2;
    auto result = ClimbingStairs::climbStairs(n);
    EXPECT_EQ(expected, result);
}

TEST(ClimbingStairsTest, climbStairs_2) {
    auto expected = 3;
    auto n = 3;
    auto result = ClimbingStairs::climbStairs(n);
    EXPECT_EQ(expected, result);
}

TEST(ClimbingStairsTest, climbStairs_fail_1) {
    // 1 ≤ n
    auto n = 1 - 1;
    EXPECT_EXIT(ClimbingStairs::climbStairs(n), ::testing::ExitedWithCode(3), "");
}

TEST(ClimbingStairsTest, climbStairs_fail_2) {
    // n ≤ 45
    auto n = 45 + 1;
    EXPECT_EXIT(ClimbingStairs::climbStairs(n), ::testing::ExitedWithCode(3), "");
}

#endif