#ifndef LEETCODE_TOP_INTERVIEW_150_PALINDROME_NUMBER_TEST
#define LEETCODE_TOP_INTERVIEW_150_PALINDROME_NUMBER_TEST

#include "gtest/gtest.h"
#include "../../../../code/leetcode/topInterview150/math/PalindromeNumber.cpp"  // NOLINT : Ignore .cpp import

TEST(PalindromeNumberTest, description) {
    testing::internal::CaptureStdout();
    PalindromeNumber::description();
    EXPECT_NE("", testing::internal::GetCapturedStdout());
}

TEST(PalindromeNumberTest, isPalindrome_1) {
    auto expected = true;
    auto x = 121;
    auto result = PalindromeNumber::isPalindrome(x);
    EXPECT_EQ(expected, result);
}

TEST(PalindromeNumberTest, isPalindrome_2) {
    auto expected = false;
    auto x = -121;
    auto result = PalindromeNumber::isPalindrome(x);
    EXPECT_EQ(expected, result);
}

TEST(PalindromeNumberTest, isPalindrome_3) {
    auto expected = false;
    auto x = 10;
    vector<int> nums{1, 1, 1, 1, 1, 1, 1, 1};
    auto result = PalindromeNumber::isPalindrome(x);
    EXPECT_EQ(expected, result);
}

TEST(PalindromeNumberTest, isPalindrome_4) {
    auto expected = true;
    auto x = 1221;
    auto result = PalindromeNumber::isPalindrome(x);
    EXPECT_EQ(expected, result);
}

#endif