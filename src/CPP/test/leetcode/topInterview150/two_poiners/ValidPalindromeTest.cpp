#ifndef LEETCODE_TOP_INTERVIEW_150_VALID_PALINDROME_TEST
#define LEETCODE_TOP_INTERVIEW_150_VALID_PALINDROME_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/two_poiners/ValidPalindrome.cpp"  // NOLINT : Ignore .cpp import

TEST(LeetCode_ValidPalindromeTest, description) {
    testing::internal::CaptureStdout();
    ValidPalindrome::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(LeetCode_ValidPalindromeTest, isPalindrome_1) {
    auto expected = true;
    auto s = "A man, a plan, a canal: Panama";
    auto result = ValidPalindrome::isPalindrome(s);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_ValidPalindromeTest, isPalindrome_2) {
    auto expected = false;
    auto s = "race a car";
    auto result = ValidPalindrome::isPalindrome(s);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_ValidPalindromeTest, isPalindrome_3) {
    auto expected = true;
    auto s = " ";
    auto result = ValidPalindrome::isPalindrome(s);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_ValidPalindromeTest, isPalindrome_4) {
    auto expected = false;
    auto s = "0P";
    auto result = ValidPalindrome::isPalindrome(s);
    EXPECT_EQ(expected, result);
}

TEST(LeetCode_ValidPalindromeTest, isPalindrome_fail_1) {
    // 1 ≤ s.length
    auto size = 1 - 1;
    string s(size, ' ');
    EXPECT_EXIT(ValidPalindrome::isPalindrome(s), ::testing::ExitedWithCode(3), "");
}

TEST(LeetCode_ValidPalindromeTest, isPalindrome_fail_2) {
    // s.length ≤ 2 * 10^5
    auto size = 2 * (int) pow(10, 5) + 1;
    string s(size, ' ');
    EXPECT_EXIT(ValidPalindrome::isPalindrome(s), ::testing::ExitedWithCode(3), "");
}

#endif