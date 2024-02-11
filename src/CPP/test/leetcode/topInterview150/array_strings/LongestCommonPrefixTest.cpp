#ifndef LEETCODE_TOP_INTERVIEW_150_LONGEST_COMMON_PREFIX_TEST
#define LEETCODE_TOP_INTERVIEW_150_LONGEST_COMMON_PREFIX_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/array_strings/LongestCommonPrefix.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_LongestCommonPrefixTest, description) {
    testing::internal::CaptureStdout();
    LongestCommonPrefix::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_LongestCommonPrefixTest, longestCommonPrefix_1) {
    auto expected = "fl";
    vector<string> strings{"flower", "flow", "flight"};
    auto result = LongestCommonPrefix::longestCommonPrefix(strings);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_LongestCommonPrefixTest, longestCommonPrefix_2) {
    string expected;
    vector<string> strings{"dog", "racecar", "car"};
    auto result = LongestCommonPrefix::longestCommonPrefix(strings);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_LongestCommonPrefixTest, longestCommonPrefix_fail_1) {
    // 1 ≤ s.length
    auto size = 1 - 1;
    vector<string> strings(size);
    EXPECT_EXIT(LongestCommonPrefix::longestCommonPrefix(strings), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_LongestCommonPrefixTest, longestCommonPrefix_fail_2) {
    // s.length ≤ 200
    auto size = 200 + 1;
    vector<string> strings(size);
    EXPECT_EXIT(LongestCommonPrefix::longestCommonPrefix(strings), ::testing::ExitedWithCode(3), "");
}

#endif