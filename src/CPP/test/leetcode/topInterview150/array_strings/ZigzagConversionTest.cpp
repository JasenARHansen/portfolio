#ifndef LEETCODE_TOP_INTERVIEW_150_ZIGZAG_CONVERSION_TEST
#define LEETCODE_TOP_INTERVIEW_150_ZIGZAG_CONVERSION_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/ZigzagConversion.cpp"  // NOLINT : Ignore .cpp import

TEST(ZigzagConversionTest, description) {
    testing::internal::CaptureStdout();
    ZigzagConversion::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ZigzagConversionTest, convert_1) {
    auto expected = "PAHNAPLSIIGYIR";
    auto s = "PAYPALISHIRING";
    auto numRow = 3;
    auto result = ZigzagConversion::convert(s, numRow);
    EXPECT_EQ(expected, result);
}

TEST(ZigzagConversionTest, convert_2) {
    auto expected = "PINALSIGYAHRPI";
    auto s = "PAYPALISHIRING";
    auto numRow = 4;
    auto result = ZigzagConversion::convert(s, numRow);
    EXPECT_EQ(expected, result);
}

TEST(ZigzagConversionTest, convert_3) {
    auto expected = "A";
    auto s = "A";
    auto numRow = 1;
    auto result = ZigzagConversion::convert(s, numRow);
    EXPECT_EQ(expected, result);
}

TEST(ZigzagConversionTest, convert_4) {
    auto expected = "PAYPALISHIRING";
    auto s = "PAYPALISHIRING";
    auto numRow = 1;
    auto result = ZigzagConversion::convert(s, numRow);
    EXPECT_EQ(expected, result);
}

TEST(ZigzagConversionTest, convert_fail_1) {
    // 1 ≤ s.length
    auto size = 1 - 1;
    string s(size, 0);
    auto numRow = 1;
    EXPECT_EXIT(ZigzagConversion::convert(s, numRow), ::testing::ExitedWithCode(3), "");
}

TEST(ZigzagConversionTest, convert_fail_2) {
    // s.length ≤ 1000
    auto size = 1000 + 1;
    string s(size, 0);
    auto numRow = 1;
    EXPECT_EXIT(ZigzagConversion::convert(s, numRow), ::testing::ExitedWithCode(3), "");
}

TEST(ZigzagConversionTest, convert_fail_3) {
    // 1 ≤ numRows
    auto s = "PAYPALISHIRING";
    auto numRow = 1 - 1;
    EXPECT_EXIT(ZigzagConversion::convert(s, numRow), ::testing::ExitedWithCode(3), "");
}

TEST(ZigzagConversionTest, convert_fail_4) {
    // numRows ≤ 1000
    auto s = "PAYPALISHIRING";
    auto numRow = 1000 + 1;
    EXPECT_EXIT(ZigzagConversion::convert(s, numRow), ::testing::ExitedWithCode(3), "");
}

#endif
