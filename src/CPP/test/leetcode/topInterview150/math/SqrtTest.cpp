#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_SQRT_TEST
#define LEETCODE_TOP_INTERVIEW_150_SQRT_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/math/Sqrt.cpp"

TEST(SqrtTest, description) {
    testing::internal::CaptureStdout();
    Sqrt::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(SqrtTest, mySqrt_1) {
    int expected = 2;
    int x = 4;
    int result = Sqrt::mySqrt(x);
    EXPECT_EQ(expected, result);
}

TEST(SqrtTest, mySqrt_2) {
    int expected = 2;
    int x = 8;
    int result = Sqrt::mySqrt(x);
    EXPECT_EQ(expected, result);
}

TEST(SqrtTest, mySqrt_fail_1) {
    // 0 <= x
    int x = 0 - 1;
    EXPECT_EXIT(Sqrt::mySqrt(x), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop