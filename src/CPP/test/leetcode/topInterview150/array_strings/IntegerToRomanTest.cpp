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
    auto expected = "III";
    auto num = 3;
    auto result = IntegerToRoman::intToRoman(num);
    EXPECT_EQ(expected, result);
}

TEST(IntegerToRomanTest, intToRoman_2) {
    auto expected = "LVIII";
    auto num = 58;
    auto result = IntegerToRoman::intToRoman(num);
    EXPECT_EQ(expected, result);
}

TEST(IntegerToRomanTest, intToRoman_3) {
    auto expected = "MCMXCIV";
    auto num = 1994;
    auto result = IntegerToRoman::intToRoman(num);
    EXPECT_EQ(expected, result);
}

TEST(IntegerToRomanTest, intToRoman_4) {
    auto expected = "XL";
    auto num = 40;
    auto result = IntegerToRoman::intToRoman(num);
    EXPECT_EQ(expected, result);
}

TEST(IntegerToRomanTest, intToRoman_fail_1) {
    // 1 <= num
    auto num = 1 - 1;
    EXPECT_EXIT(IntegerToRoman::intToRoman(num), ::testing::ExitedWithCode(3), "");
}

TEST(IntegerToRomanTest, intToRoman_fail_2) {
    // num <= 3999
    auto num = 3999 + 1;
    EXPECT_EXIT(IntegerToRoman::intToRoman(num), ::testing::ExitedWithCode(3), "");
}

#endif