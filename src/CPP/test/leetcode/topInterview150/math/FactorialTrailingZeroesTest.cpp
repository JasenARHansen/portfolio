#ifndef LEETCODE_TOP_INTERVIEW_150_FACTORIAL_TRAILING_ZEROES_TEST
#define LEETCODE_TOP_INTERVIEW_150_FACTORIAL_TRAILING_ZEROES_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/math/FactorialTrailingZeroes.cpp"  // NOLINT : Ignore .cpp import

TEST(FactorialTrailingZeroesTest, description) {
    testing::internal::CaptureStdout();
    FactorialTrailingZeroes::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(FactorialTrailingZeroesTest, trailingZeroes_1) {
    auto expected = 0;
    auto n = 3;
    auto result = FactorialTrailingZeroes::trailingZeroes(n);
    EXPECT_EQ(expected, result);
}

TEST(FactorialTrailingZeroesTest, trailingZeroes_2) {
    auto expected = 1;
    auto n = 5;
    auto result = FactorialTrailingZeroes::trailingZeroes(n);
    EXPECT_EQ(expected, result);
}

TEST(FactorialTrailingZeroesTest, trailingZeroes_3) {
    auto expected = 0;
    auto n = 0;
    auto result = FactorialTrailingZeroes::trailingZeroes(n);
    EXPECT_EQ(expected, result);
}

TEST(FactorialTrailingZeroesTest, trailingZeroes_4) {
    auto expected = 7;
    auto n = 30;
    auto result = FactorialTrailingZeroes::trailingZeroes(n);
    EXPECT_EQ(expected, result);
}

TEST(FactorialTrailingZeroesTest, trailingZeroes_5) {
    auto expected = 24;
    auto n = 100;
    auto result = FactorialTrailingZeroes::trailingZeroes(n);
    EXPECT_EQ(expected, result);
}

TEST(FactorialTrailingZeroesTest, trailingZeroes_fail_1) {
    // 0 ≤ n
    auto n = 0 - 1;
    EXPECT_EXIT(FactorialTrailingZeroes::trailingZeroes(n), ::testing::ExitedWithCode(3), "");
}

TEST(FactorialTrailingZeroesTest, trailingZeroes_fail_2) {
    // n ≤ 10^4
    auto n = (int) pow(10, 4) + 1;
    EXPECT_EXIT(FactorialTrailingZeroes::trailingZeroes(n), ::testing::ExitedWithCode(3), "");
}

#endif