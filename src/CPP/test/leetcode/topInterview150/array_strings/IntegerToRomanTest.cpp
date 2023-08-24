#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_INTEGER_TO_ROMAN_TEST
#define LEETCODE_TOP_INTERVIEW_150_INTEGER_TO_ROMAN_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/IntegerToRoman.cpp"

TEST(IntegerToRomanTest, description) {
    testing::internal::CaptureStdout();
    IntegerToRoman::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(IntegerToRomanTest, intToRoman_1) {
    string expected = "III";
    int num = 3;
    string result = IntegerToRoman::intToRoman(num);
    EXPECT_EQ(expected, result);
}

TEST(IntegerToRomanTest, intToRoman_2) {
    string expected = "LVIII";
    int num = 58;
    string result = IntegerToRoman::intToRoman(num);
    EXPECT_EQ(expected, result);
}

TEST(IntegerToRomanTest, intToRoman_3) {
    string expected = "MCMXCIV";
    int num = 1994;
    string result = IntegerToRoman::intToRoman(num);
    EXPECT_EQ(expected, result);
}

TEST(IntegerToRomanTest, intToRoman_4) {
    string expected = "XL";
    int num = 40;
    string result = IntegerToRoman::intToRoman(num);
    EXPECT_EQ(expected, result);
}
TEST(IntegerToRomanTest, intToRoman_fail_1) {
    // 1 <= num
    int num = 1 - 1;
    EXPECT_EXIT(IntegerToRoman::intToRoman(num), ::testing::ExitedWithCode(3), "");
}

TEST(IntegerToRomanTest, intToRoman_fail_2) {
    // num <= 3999
    int num = 3999 + 1;
    EXPECT_EXIT(IntegerToRoman::intToRoman(num), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop