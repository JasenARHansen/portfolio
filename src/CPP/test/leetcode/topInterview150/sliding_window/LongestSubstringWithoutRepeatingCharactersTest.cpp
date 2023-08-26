#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_Longest_Substring_Without_Repeating_Characters_TEST
#define LEETCODE_TOP_INTERVIEW_150_Longest_Substring_Without_Repeating_Characters_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/sliding_window/LongestSubstringWithoutRepeatingCharacters.cpp"

TEST(LongestSubstringWithoutRepeatingCharactersTest, description) {
    testing::internal::CaptureStdout();
    LongestSubstringWithoutRepeatingCharacters::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LongestSubstringWithoutRepeatingCharactersTest, lengthOfLongestSubstring_1) {
    int expected = 3;
    string s = "abcabcbb";
    int result = LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring(s);
    EXPECT_EQ(expected, result);
}

TEST(LongestSubstringWithoutRepeatingCharactersTest, lengthOfLongestSubstring_2) {
    int expected = 1;
    string s = "bbbbb";
    int result = LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring(s);
    EXPECT_EQ(expected, result);
}

TEST(LongestSubstringWithoutRepeatingCharactersTest, lengthOfLongestSubstring_3) {
    int expected = 3;
    string s = "pwwkew";
    int result = LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring(s);
    EXPECT_EQ(expected, result);
}

TEST(LongestSubstringWithoutRepeatingCharactersTest, lengthOfLongestSubstring_4) {
    int expected = 3;
    string s = "dvdf";
    int result = LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring(s);
    EXPECT_EQ(expected, result);
}

TEST(LongestSubstringWithoutRepeatingCharactersTest, lengthOfLongestSubstring_fail_1) {
    // 0 <= s.length
    int size = 5 * pow(10, 4) + 1;
    string s(size, ' ');
    EXPECT_EXIT(LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring(s), ::testing::ExitedWithCode(3),
                "");
}

#endif
#pragma clang diagnostic pop