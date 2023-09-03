#ifndef LEETCODE_TOP_INTERVIEW_150_LONGEST_COMMON_PREFIX_TEST
#define LEETCODE_TOP_INTERVIEW_150_LONGEST_COMMON_PREFIX_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/LongestCommonPrefix.cpp"

TEST(LongestCommonPrefixTest, description) {
    testing::internal::CaptureStdout();
    LongestCommonPrefix::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LongestCommonPrefixTest, longestCommonPrefix_1) {
    auto expected = "fl";
    vector<string> strs{"flower", "flow", "flight"};
    auto result = LongestCommonPrefix::longestCommonPrefix(strs);
    EXPECT_EQ(expected, result);
}

TEST(LongestCommonPrefixTest, longestCommonPrefix_2) {
    string expected;
    vector<string> strs{"dog", "racecar", "car"};
    auto result = LongestCommonPrefix::longestCommonPrefix(strs);
    EXPECT_EQ(expected, result);
}

TEST(LongestCommonPrefixTest, longestCommonPrefix_fail_1) {
    // 1 <= s.length
    auto size = 1 - 1;
    vector<string> strs(size);
    EXPECT_EXIT(LongestCommonPrefix::longestCommonPrefix(strs), ::testing::ExitedWithCode(3), "");
}

TEST(LongestCommonPrefixTest, longestCommonPrefix_fail_2) {
    // s.length <= 200
    auto size = 200 + 1;
    vector<string> strs(size);
    EXPECT_EXIT(LongestCommonPrefix::longestCommonPrefix(strs), ::testing::ExitedWithCode(3), "");
}

#endif