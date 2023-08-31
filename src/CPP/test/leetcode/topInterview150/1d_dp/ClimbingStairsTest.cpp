#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_CLIMBING_STAIRS_TEST
#define LEETCODE_TOP_INTERVIEW_150_CLIMBING_STAIRS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/1d_dp/ClimbingStairs.cpp"

TEST(ClimbingStairsTest, description) {
    testing::internal::CaptureStdout();
    ClimbingStairs::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ClimbingStairsTest, climbStairs_1) {
    int expected = 2;
    int n = 2;
    int result = ClimbingStairs::climbStairs(n);
    EXPECT_EQ(expected, result);
}

TEST(ClimbingStairsTest, climbStairs_2) {
    int expected = 3;
    int n = 3;
    int result = ClimbingStairs::climbStairs(n);
    EXPECT_EQ(expected, result);
}

TEST(ClimbingStairsTest, climbStairs_fail_1) {
    // 1 <= n
    int n = 1 - 1;
    EXPECT_EXIT(ClimbingStairs::climbStairs(n), ::testing::ExitedWithCode(3), "");
}

TEST(ClimbingStairsTest, climbStairs_fail_2) {
    // n <= 45
    int n = 45 + 1;
    EXPECT_EXIT(ClimbingStairs::climbStairs(n), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop