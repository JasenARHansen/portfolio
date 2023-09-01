#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_ROMAN_TO_INTEGER_TEST
#define LEETCODE_TOP_INTERVIEW_150_ROMAN_TO_INTEGER_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/RomanToInteger.cpp"

TEST(RomanToIntegerTest, description) {
    testing::internal::CaptureStdout();
    RomanToInteger::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(RomanToIntegerTest, romanToInt_1) {
    int expected = 3;
    string s = "III";
    int result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_2) {
    int expected = 58;
    string s = "LVIII";
    int result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_3) {
    int expected = 1994;
    string s = "MCMXCIV";
    int result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_4) {
    int expected = 2;
    string s = "II";
    int result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_5) {
    int expected = 20;
    string s = "XX";
    int result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_6) {
    int expected = 102;
    string s = "CII";
    int result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_7) {
    int expected = 660;
    string s = "DCLX";
    int result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_8) {
    int expected = 9;
    string s = "IX";
    int result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_9) {
    int expected = 24;
    string s = "XXIV";
    int result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_10) {
    int expected = 299;
    string s = "CCXCIX";
    int result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_11) {
    int expected = 2307;
    string s = "MCMCDVII";
    int result = RomanToInteger::romanToInt(s);
    EXPECT_EQ(expected, result);
}

TEST(RomanToIntegerTest, romanToInt_fail_1) {
    // 1 <= s.length
    int size = 1 - 1;
    string s(size, 0);
    EXPECT_EXIT(RomanToInteger::romanToInt(s), ::testing::ExitedWithCode(3), "");
}

TEST(RomanToIntegerTest, romanToInt_fail_2) {
    // s.length <= 15
    int size = 15 + 1;
    string s(size, 0);
    EXPECT_EXIT(RomanToInteger::romanToInt(s), ::testing::ExitedWithCode(3), "");
}

TEST(RomanToIntegerTest, romanToInt_fail_3) {
    // s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M')
    string s = "INVALID";
    EXPECT_EXIT(RomanToInteger::romanToInt(s), ::testing::ExitedWithCode(3), "");
}

TEST(RomanToIntegerTest, romanToInt_fail_4) {
    // total <= 3999
    string s = "MMMM";
    EXPECT_EXIT(RomanToInteger::romanToInt(s), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop