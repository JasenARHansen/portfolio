#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_FACTORIAL_TRAILING_ZEROES_TEST
#define LEETCODE_TOP_INTERVIEW_150_FACTORIAL_TRAILING_ZEROES_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/math/FactorialTrailingZeroes.cpp"

TEST(FactorialTrailingZeroesTest, description) {
    testing::internal::CaptureStdout();
    FactorialTrailingZeroes::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(FactorialTrailingZeroesTest, trailingZeroes_1) {
    int expected = 0;
    int n = 3;
    int result = FactorialTrailingZeroes::trailingZeroes(n);
    EXPECT_EQ(expected, result);
}

TEST(FactorialTrailingZeroesTest, trailingZeroes_2) {
    int expected = 1;
    int n = 5;
    int result = FactorialTrailingZeroes::trailingZeroes(n);
    EXPECT_EQ(expected, result);
}

TEST(FactorialTrailingZeroesTest, trailingZeroes_3) {
    int expected = 0;
    int n = 0;
    int result = FactorialTrailingZeroes::trailingZeroes(n);
    EXPECT_EQ(expected, result);
}

TEST(FactorialTrailingZeroesTest, trailingZeroes_4) {
    int expected = 7;
    int n = 30;
    int result = FactorialTrailingZeroes::trailingZeroes(n);
    EXPECT_EQ(expected, result);
}

TEST(FactorialTrailingZeroesTest, trailingZeroes_5) {
    int expected = 24;
    int n = 100;
    int result = FactorialTrailingZeroes::trailingZeroes(n);
    EXPECT_EQ(expected, result);
}

TEST(FactorialTrailingZeroesTest, trailingZeroes_fail_1) {
    // 0 <= n
    int n = 0 - 1;
    EXPECT_EXIT(FactorialTrailingZeroes::trailingZeroes(n), ::testing::ExitedWithCode(3), "");
}

TEST(FactorialTrailingZeroesTest, trailingZeroes_fail_2) {
    // n <= 10^4
    int n = pow(10, 4) + 1;
    EXPECT_EXIT(FactorialTrailingZeroes::trailingZeroes(n), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop