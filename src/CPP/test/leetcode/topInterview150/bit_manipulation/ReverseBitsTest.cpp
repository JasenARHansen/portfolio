#ifndef LEETCODE_TOP_INTERVIEW_150_REVERSE_BITS_TEST
#define LEETCODE_TOP_INTERVIEW_150_REVERSE_BITS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/bit_manipulation/ReverseBits.cpp"

TEST(ReverseBitsTest, description) {
    testing::internal::CaptureStdout();
    ReverseBits::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ReverseBitsTest, reverseBits_1) {
    auto expected = 0b00111001011110000010100101000000;
    auto n = 0b00000010100101000001111010011100;
    auto result = ReverseBits::reverseBits(n);
    EXPECT_EQ(expected, result);
}

TEST(ReverseBitsTest, reverseBits_2) {
    auto expected = 0b10111111111111111111111111111111;
    auto n = 0b11111111111111111111111111111101;
    auto result = ReverseBits::reverseBits(n);
    EXPECT_EQ(expected, result);
}

#endif