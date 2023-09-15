#ifndef LEETCODE_TOP_INTERVIEW_150_BITWISE_AND_OF_NUMBERS_RANGE_TEST
#define LEETCODE_TOP_INTERVIEW_150_BITWISE_AND_OF_NUMBERS_RANGE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/bit_manipulation/BitwiseANDofNumbersRange.cpp"  // NOLINT : Ignore .cpp import

TEST(BitwiseANDofNumbersRangeTest, description) {
    testing::internal::CaptureStdout();
    BitwiseANDofNumbersRange::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(BitwiseANDofNumbersRangeTest, rangeBitwiseAnd_1) {
    auto expected = 4;
    auto left = 5;
    auto right = 7;
    auto result = BitwiseANDofNumbersRange::rangeBitwiseAnd(left, right);
    EXPECT_EQ(expected, result);
}

TEST(BitwiseANDofNumbersRangeTest, rangeBitwiseAnd_2) {
    auto expected = 0;
    auto left = 0;
    auto right = 0;
    auto result = BitwiseANDofNumbersRange::rangeBitwiseAnd(left, right);
    EXPECT_EQ(expected, result);
}

TEST(BitwiseANDofNumbersRangeTest, rangeBitwiseAnd_3) {
    auto expected = 0;
    auto left = 1;
    auto right = 2147483647;
    auto result = BitwiseANDofNumbersRange::rangeBitwiseAnd(left, right);
    EXPECT_EQ(expected, result);
}

TEST(BitwiseANDofNumbersRangeTest, rangeBitwiseAnd_fail_1) {
    // 0 ≤ left
    auto left = 0 - 1;
    auto right = 7;
    EXPECT_EXIT(BitwiseANDofNumbersRange::rangeBitwiseAnd(left, right), ::testing::ExitedWithCode(3), "");
}

TEST(BitwiseANDofNumbersRangeTest, rangeBitwiseAnd_fail_2) {
    // 0 ≤ right
    auto left = 5;
    auto right = 0 - 1;
    EXPECT_EXIT(BitwiseANDofNumbersRange::rangeBitwiseAnd(left, right), ::testing::ExitedWithCode(3), "");
}

TEST(BitwiseANDofNumbersRangeTest, rangeBitwiseAnd_fail_3) {
    // left ≤ right
    auto left = 5;
    auto right = left - 1;
    EXPECT_EXIT(BitwiseANDofNumbersRange::rangeBitwiseAnd(left, right), ::testing::ExitedWithCode(3), "");
}

#endif