#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_LENGTH_OF_LAST_WORD_TEST
#define LEETCODE_TOP_INTERVIEW_150_LENGTH_OF_LAST_WORD_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/LongestCommonPrefix.cpp"

TEST(LongestCommonPrefixTest, description) {
    testing::internal::CaptureStdout();
    LongestCommonPrefix::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LongestCommonPrefixTest, longestCommonPrefix_1) {
    string expected = "fl";
    vector<string> strs{"flower", "flow", "flight"};
    string result = LongestCommonPrefix::longestCommonPrefix(strs);
    EXPECT_EQ(expected, result);
}

TEST(LongestCommonPrefixTest, longestCommonPrefix_2) {
    string expected = "";
    vector<string> strs{"dog", "racecar", "car"};
    string result = LongestCommonPrefix::longestCommonPrefix(strs);
    EXPECT_EQ(expected, result);
}

TEST(LongestCommonPrefixTest, longestCommonPrefix_fail_1) {
    // 1 <= s.length
    int size = 1 - 1;
    vector<string> strs(size);
    EXPECT_EXIT(LongestCommonPrefix::longestCommonPrefix(strs), ::testing::ExitedWithCode(3), "");
}

TEST(LongestCommonPrefixTest, longestCommonPrefix_fail_2) {
    // s.length <= 200
    int size = 200 + 1;
    vector<string> strs(size);
    EXPECT_EXIT(LongestCommonPrefix::longestCommonPrefix(strs), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop