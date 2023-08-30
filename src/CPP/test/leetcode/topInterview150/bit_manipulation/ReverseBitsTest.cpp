#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
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
    uint32_t expected = 0b00111001011110000010100101000000;
    uint32_t n = 0b00000010100101000001111010011100;
    uint32_t result = ReverseBits::reverseBits(n);
    EXPECT_EQ(expected, result);
}

TEST(ReverseBitsTest, reverseBits_2) {
    uint32_t expected = 0b10111111111111111111111111111111;
    uint32_t n = 0b11111111111111111111111111111101;
    uint32_t result = ReverseBits::reverseBits(n);
    EXPECT_EQ(expected, result);
}

#endif
#pragma clang diagnostic pop