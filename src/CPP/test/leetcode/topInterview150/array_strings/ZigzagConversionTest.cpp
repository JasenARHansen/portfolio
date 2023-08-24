#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_ZIGZAG_CONVERSION_TEST
#define LEETCODE_TOP_INTERVIEW_150_ZIGZAG_CONVERSION_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/ZigzagConversion.cpp"

TEST(ZigzagConversionTest, description) {
    testing::internal::CaptureStdout();
    ZigzagConversion::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ZigzagConversionTest, convert_1) {
    string expected = "PAHNAPLSIIGYIR";
    string s = "PAYPALISHIRING";
    int numRow = 3;
    string result = ZigzagConversion::convert(s, numRow);
    EXPECT_EQ(expected, result);
}

TEST(ZigzagConversionTest, convert_2) {
    string expected = "PINALSIGYAHRPI";
    string s = "PAYPALISHIRING";
    int numRow = 4;
    string result = ZigzagConversion::convert(s, numRow);
    EXPECT_EQ(expected, result);
}

TEST(ZigzagConversionTest, convert_3) {
    string expected = "A";
    string s = "A";
    int numRow = 1;
    string result = ZigzagConversion::convert(s, numRow);
    EXPECT_EQ(expected, result);
}

TEST(ZigzagConversionTest, convert_4) {
    string expected = "PAYPALISHIRING";
    string s = "PAYPALISHIRING";
    int numRow = 1;
    string result = ZigzagConversion::convert(s, numRow);
    EXPECT_EQ(expected, result);
}

TEST(ZigzagConversionTest, convert_fail_1) {
    // 1 <= s.length
    int size = 1 - 1;
    string s(size, 0);
    int numRow = 1;
    EXPECT_EXIT(ZigzagConversion::convert(s, numRow), ::testing::ExitedWithCode(3), "");
}

TEST(ZigzagConversionTest, convert_fail_2) {
    // s.length <= 1000
    int size = 1000 + 1;
    string s(size, 0);
    int numRow = 1;
    EXPECT_EXIT(ZigzagConversion::convert(s, numRow), ::testing::ExitedWithCode(3), "");
}

TEST(ZigzagConversionTest, convert_fail_3) {
    // 1 <= numRows
    string s = "PAYPALISHIRING";
    int numRow = 1 - 1;
    EXPECT_EXIT(ZigzagConversion::convert(s, numRow), ::testing::ExitedWithCode(3), "");
}

TEST(ZigzagConversionTest, convert_fail_4) {
    // numRows <= 1000
    string s = "PAYPALISHIRING";
    int numRow = 1000 + 1;
    EXPECT_EXIT(ZigzagConversion::convert(s, numRow), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop
