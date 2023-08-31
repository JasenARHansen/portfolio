#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_BITWISE_AND_OF_NUMBERS_RANGE_TEST
#define LEETCODE_TOP_INTERVIEW_150_BITWISE_AND_OF_NUMBERS_RANGE_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/bit_manipulation/BitwiseANDofNumbersRange.cpp"

TEST(BitwiseANDofNumbersRangeTest, description) {
    testing::internal::CaptureStdout();
    BitwiseANDofNumbersRange::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(BitwiseANDofNumbersRangeTest, rangeBitwiseAnd_1) {
    int expected = 4;
    int left = 5;
    int right = 7;
    int result = BitwiseANDofNumbersRange::rangeBitwiseAnd(left, right);
    EXPECT_EQ(expected, result);
}

TEST(BitwiseANDofNumbersRangeTest, rangeBitwiseAnd_2) {
    int expected = 0;
    int left = 0;
    int right = 0;
    int result = BitwiseANDofNumbersRange::rangeBitwiseAnd(left, right);
    EXPECT_EQ(expected, result);
}

TEST(BitwiseANDofNumbersRangeTest, rangeBitwiseAnd_3) {
    int expected = 0;
    int left = 1;
    int right = 2147483647;
    int result = BitwiseANDofNumbersRange::rangeBitwiseAnd(left, right);
    EXPECT_EQ(expected, result);
}

TEST(BitwiseANDofNumbersRangeTest, rangeBitwiseAnd_fail_1) {
    // 0 <= left
    int left = 0 - 1;
    int right = 7;
    EXPECT_EXIT(BitwiseANDofNumbersRange::rangeBitwiseAnd(left, right), ::testing::ExitedWithCode(3), "");
}

TEST(BitwiseANDofNumbersRangeTest, rangeBitwiseAnd_fail_2) {
    // 0 <= right
    int left = 5;
    int right = 0 - 1;
    EXPECT_EXIT(BitwiseANDofNumbersRange::rangeBitwiseAnd(left, right), ::testing::ExitedWithCode(3), "");
}

TEST(BitwiseANDofNumbersRangeTest, rangeBitwiseAnd_fail_3) {
    // left <= right
    int left = 5;
    int right = left - 1;
    EXPECT_EXIT(BitwiseANDofNumbersRange::rangeBitwiseAnd(left, right), ::testing::ExitedWithCode(3), "");
}


#endif
#pragma clang diagnostic pop