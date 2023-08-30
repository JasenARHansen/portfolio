#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_NUMBER_OF_1_BITS_TEST
#define LEETCODE_TOP_INTERVIEW_150_NUMBER_OF_1_BITS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/bit_manipulation/NumberOf1Bits.cpp"

TEST(NumberOf1BitsTest, description) {
    testing::internal::CaptureStdout();
    NumberOf1Bits::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(NumberOf1BitsTest, hammingWeight_1) {
    int expected = 3;
    uint32_t n = 0b00000000000000000000000000001011;
    int result = NumberOf1Bits::hammingWeight(n);
    EXPECT_EQ(expected, result);
}

TEST(NumberOf1BitsTest, hammingWeight_2) {
    int expected = 1;
    uint32_t n = 0b00000000000000000000000010000000;
    int result = NumberOf1Bits::hammingWeight(n);
    EXPECT_EQ(expected, result);
}


TEST(NumberOf1BitsTest, hammingWeight_3) {
    int expected = 31;
    uint32_t n = 0b11111111111111111111111111111101;
    int result = NumberOf1Bits::hammingWeight(n);
    EXPECT_EQ(expected, result);
}

#endif
#pragma clang diagnostic pop