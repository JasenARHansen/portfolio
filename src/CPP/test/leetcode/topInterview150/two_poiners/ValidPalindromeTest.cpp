#pragma clang diagnostic push
#pragma ide diagnostic ignored "cppcoreguidelines-narrowing-conversions"
#ifndef LEETCODE_TOP_INTERVIEW_150_VALID_PALINDROME_TEST
#define LEETCODE_TOP_INTERVIEW_150_VALID_PALINDROME_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/two_poiners/ValidPalindrome.cpp"

TEST(ValidPalindromeTest, description) {
    testing::internal::CaptureStdout();
    ValidPalindrome::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(ValidPalindromeTest, isPalindrome_1) {
    bool expected = true;
    string s = "A man, a plan, a canal: Panama";
    bool result = ValidPalindrome::isPalindrome(s);
    EXPECT_EQ(expected, result);
}

TEST(ValidPalindromeTest, isPalindrome_2) {
    bool expected = false;
    string s = "race a car";
    bool result = ValidPalindrome::isPalindrome(s);
    EXPECT_EQ(expected, result);
}

TEST(ValidPalindromeTest, isPalindrome_3) {
    bool expected = true;
    string s = " ";
    bool result = ValidPalindrome::isPalindrome(s);
    EXPECT_EQ(expected, result);
}

TEST(ValidPalindromeTest, isPalindrome_4) {
    bool expected = false;
    string s = "0P";
    bool result = ValidPalindrome::isPalindrome(s);
    EXPECT_EQ(expected, result);
}

TEST(ValidPalindromeTest, isPalindrome_fail_1) {
    // 1 <= s.length
    int size = 1 - 1;
    string s(size, ' ');
    EXPECT_EXIT(ValidPalindrome::isPalindrome(s), ::testing::ExitedWithCode(3), "");
}

TEST(ValidPalindromeTest, isPalindrome_fail_2) {
    // s.length <= 2 * 10^5
    int size = 2 * pow(10, 5) + 1;
    string s(size, ' ');
    EXPECT_EXIT(ValidPalindrome::isPalindrome(s), ::testing::ExitedWithCode(3), "");
}

#endif
#pragma clang diagnostic pop