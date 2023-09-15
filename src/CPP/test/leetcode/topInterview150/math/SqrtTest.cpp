#ifndef LEETCODE_TOP_INTERVIEW_150_SQRT_TEST
#define LEETCODE_TOP_INTERVIEW_150_SQRT_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/math/Sqrt.cpp"  // NOLINT : Ignore .cpp import

TEST(SqrtTest, description) {
    testing::internal::CaptureStdout();
    Sqrt::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SqrtTest, mySqrt_1) {
    auto expected = 2;
    auto x = 4;
    auto result = Sqrt::mySqrt(x);
    EXPECT_EQ(expected, result);
}

TEST(SqrtTest, mySqrt_2) {
    auto expected = 2;
    auto x = 8;
    auto result = Sqrt::mySqrt(x);
    EXPECT_EQ(expected, result);
}

TEST(SqrtTest, mySqrt_fail_1) {
    // 0 ≤ x
    auto x = 0 - 1;
    EXPECT_EXIT(Sqrt::mySqrt(x), ::testing::ExitedWithCode(3), "");
}

#endif