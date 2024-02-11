#ifndef LEETCODE_TOP_INTERVIEW_150_LONGEST_SUBSTRING_WITHOUT_REPEATING_CHARACTERS_TEST
#define LEETCODE_TOP_INTERVIEW_150_LONGEST_SUBSTRING_WITHOUT_REPEATING_CHARACTERS_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/sliding_window/LongestSubstringWithoutRepeatingCharacters.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_LongestSubstringWithoutRepeatingCharactersTest, description) {
    testing::internal::CaptureStdout();
    LongestSubstringWithoutRepeatingCharacters::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_LongestSubstringWithoutRepeatingCharactersTest, lengthOfLongestSubstring_1) {
    auto expected = 3;
    auto s = "abcabcbb";
    auto result = LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring(s);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_LongestSubstringWithoutRepeatingCharactersTest, lengthOfLongestSubstring_2) {
    auto expected = 1;
    auto s = "bbbbb";
    auto result = LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring(s);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_LongestSubstringWithoutRepeatingCharactersTest, lengthOfLongestSubstring_3) {
    auto expected = 3;
    auto s = "pwwkew";
    auto result = LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring(s);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_LongestSubstringWithoutRepeatingCharactersTest, lengthOfLongestSubstring_4) {
    auto expected = 3;
    auto s = "dvdf";
    auto result = LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring(s);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_LongestSubstringWithoutRepeatingCharactersTest, lengthOfLongestSubstring_fail_1) {
    // 0 ≤ s.length
    auto size = 5 * (int) pow(10, 4) + 1;
    string s(size, ' ');
    EXPECT_EXIT(LongestSubstringWithoutRepeatingCharacters::lengthOfLongestSubstring(s), ::testing::ExitedWithCode(3),
                "");
}

#endif