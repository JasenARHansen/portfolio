#ifndef LEETCODE_TOP_INTERVIEW_150_NUMBER_OF_1_BITS_TEST
#define LEETCODE_TOP_INTERVIEW_150_NUMBER_OF_1_BITS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/bit_manipulation/NumberOf1Bits.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_NumberOf1BitsTest, description) {
    testing::internal::CaptureStdout();
    NumberOf1Bits::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_NumberOf1BitsTest, hammingWeight_1) {
    auto expected = 3;
    auto n = 0b00000000000000000000000000001011;
    auto result = NumberOf1Bits::hammingWeight(n);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_NumberOf1BitsTest, hammingWeight_2) {
    auto expected = 1;
    auto n = 0b00000000000000000000000010000000;
    auto result = NumberOf1Bits::hammingWeight(n);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_NumberOf1BitsTest, hammingWeight_3) {
    auto expected = 31;
    auto n = 0b11111111111111111111111111111101;
    auto result = NumberOf1Bits::hammingWeight(n);
    EXPECT_EQ(expected, result);
}

#endif