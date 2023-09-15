#ifndef LEETCODE_TOP_INTERVIEW_150_ROMAN_TO_INTEGER_TEST
#define LEETCODE_TOP_INTERVIEW_150_ROMAN_TO_INTEGER_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/RomanToInteger.cpp"  // NOLINT : Ignore .cpp import

TEST(RomanToIntegerTest, description) {
    testing::internal::CaptureStdout();
    RomanToInteger::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RomanToIntegerTest, romanToInt_1) {
    auto expected = 3;
    auto s = "III";
    auto result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_2) {
    auto expected = 58;
    auto s = "LVIII";
    auto result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_3) {
    auto expected = 1994;
    auto s = "MCMXCIV";
    auto result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_4) {
    auto expected = 2;
    auto s = "II";
    auto result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_5) {
    auto expected = 20;
    auto s = "XX";
    auto result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_6) {
    auto expected = 102;
    auto s = "CII";
    auto result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_7) {
    auto expected = 660;
    auto s = "DCLX";
    auto result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_8) {
    auto expected = 9;
    auto s = "IX";
    auto result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_9) {
    auto expected = 24;
    auto s = "XXIV";
    auto result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_10) {
    auto expected = 299;
    auto s = "CCXCIX";
    auto result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_11) {
    auto expected = 2307;
    auto s = "MCMCDVII";
    auto result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_fail_1) {
    // 1 ≤ s.length
    auto size = 1 - 1;
    string s(size, 0);
    EXPECT_EXIT(RomanToInteger::romanToInt(s), ::testing::ExitedWithCode(3), "");
}

TEST(RomanToIntegerTest, romanToInt_fail_2) {
    // s.length ≤ 15
    auto size = 15 + 1;
    string s(size, 0);
    EXPECT_EXIT(RomanToInteger::romanToInt(s), ::testing::ExitedWithCode(3), "");
}

TEST(RomanToIntegerTest, romanToInt_fail_3) {
    // s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M')
    auto s = "INVALID";
    EXPECT_EXIT(RomanToInteger::romanToInt(s), ::testing::ExitedWithCode(3), "");
}

TEST(RomanToIntegerTest, romanToInt_fail_4) {
    // total ≤ 3999
    auto s = "MMMM";
    EXPECT_EXIT(RomanToInteger::romanToInt(s), ::testing::ExitedWithCode(3), "");
}

#endif