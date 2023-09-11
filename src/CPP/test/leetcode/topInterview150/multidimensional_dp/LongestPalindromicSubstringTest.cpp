#ifndef LEETCODE_TOP_INTERVIEW_150_LONGEST_PALINDROMIC_SUBSTRING_TEST
#define LEETCODE_TOP_INTERVIEW_150_LONGEST_PALINDROMIC_SUBSTRING_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/multidimensional_dp/LongestPalindromicSubstring.cpp"

TEST(LongestPalindromicSubstringTest, description) {
    testing::internal::CaptureStdout();
    LongestPalindromicSubstring::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LongestPalindromicSubstringTest, longestPalindrome_1) {
    auto expected = "bab";
    auto s = "babad";
    auto result = LongestPalindromicSubstring::longestPalindrome(s);
    EXPECT_EQ(expected, result);
}

TEST(LongestPalindromicSubstringTest, longestPalindrome_2) {
    auto expected = "bb";
    auto s = "cbbd";
    auto result = LongestPalindromicSubstring::longestPalindrome(s);
    EXPECT_EQ(expected, result);
}

TEST(LongestPalindromicSubstringTest, longestPalindrome_3) {
    auto expected = "abcdcba";
    auto s = "1234abcdcba1234";
    auto result = LongestPalindromicSubstring::longestPalindrome(s);
    EXPECT_EQ(expected, result);
}

TEST(LongestPalindromicSubstringTest, longestPalindrome_fail_1) {
    // 1 ≤ s.length
    auto size = 1 - 1;
    string s(size, ' ');
    EXPECT_EXIT(LongestPalindromicSubstring::longestPalindrome(s), ::testing::ExitedWithCode(3), "");
}

TEST(LongestPalindromicSubstringTest, longestPalindrome_fail_2) {
    // s.length ≤ 1000
    auto size = 1000 + 1;
    string s(size, ' ');
    EXPECT_EXIT(LongestPalindromicSubstring::longestPalindrome(s), ::testing::ExitedWithCode(3), "");
}

#endif