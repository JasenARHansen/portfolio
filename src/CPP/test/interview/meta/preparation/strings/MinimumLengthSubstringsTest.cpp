#ifndef INTERVIEW_META_PREPARATION_MIN_LENGTH_SUBSTRING_TEST
#define INTERVIEW_META_PREPARATION_MIN_LENGTH_SUBSTRING_TEST

#include "gtest/gtest.h"
#include "../../../../../code/interview/meta/preparation/strings/MinimumLengthSubstrings.cpp"  // NOLINT : Ignore .cpp import

TEST(MinimumLengthSubstringsTest, description) {
    testing::internal::CaptureStdout();
    MinimumLengthSubstrings::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(MinimumLengthSubstringsTest, minLengthSubstring_1) {
    auto expected = 5;
    auto s = "dcbefebce";
    auto t = "fd";
    auto result = MinimumLengthSubstrings::minLengthSubstring(s, t);
    EXPECT_EQ(expected, result);
}

TEST(MinimumLengthSubstringsTest, minLengthSubstring_2) {
    auto expected = -1;
    auto s = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
    auto t = "cbccfafebccdccebdd";
    auto result = MinimumLengthSubstrings::minLengthSubstring(s, t);
    EXPECT_EQ(expected, result);
}

#endif